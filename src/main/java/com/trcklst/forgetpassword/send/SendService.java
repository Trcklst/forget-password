package com.trcklst.forgetpassword.send;

import com.trcklst.forgetpassword.db.User;
import com.trcklst.forgetpassword.db.UserRepository;
import com.trcklst.forgetpassword.send.dto.SendDto;
import com.trcklst.forgetpassword.send.dto.SendIn;
import com.trcklst.forgetpassword.send.exceptions.EmailNotExistsException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SendService {

    private final UserRepository userRepository;
    private final JavaMailSender javaMailSender;
    private final MessageSourceAccessor messageSourceAccessor;

    public SendDto process(SendIn sendIn) {
        Optional<User> userOpt = userRepository.findByUsername(sendIn.getEmail());
        User user = userOpt.orElseThrow(() -> new EmailNotExistsException(sendIn.getEmail()));
        user.setRestPasswordToken(generateToken());
        sendEmail(user);
        userRepository.save(user);
        return map(user);
    }

    private SendDto map(User user) {
        return SendDto.builder()
                .token(createTokenWithUserId(user))
                .build();
    }

    private String createTokenWithUserId(User user) {
        return String.format("%d-%s", user.getId(), user.getRestPasswordToken());
    }

    private String generateToken() {
        return RandomStringUtils.randomAlphanumeric(200);
    }

    private void sendEmail(User user) {
        Object[] mailToken = new Object[] {createTokenWithUserId(user)};
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(user.getUsername());
        simpleMailMessage.setSubject(messageSourceAccessor.getMessage("send.email.subject"));
        simpleMailMessage.setText(messageSourceAccessor.getMessage("send.email.text", mailToken));
        javaMailSender.send(simpleMailMessage);
    }
}
