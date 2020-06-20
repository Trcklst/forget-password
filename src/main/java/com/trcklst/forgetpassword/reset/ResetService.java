package com.trcklst.forgetpassword.reset;

import com.trcklst.forgetpassword.db.User;
import com.trcklst.forgetpassword.db.UserRepository;
import com.trcklst.forgetpassword.reset.dto.ResetDto;
import com.trcklst.forgetpassword.reset.dto.ResetIn;
import com.trcklst.forgetpassword.reset.exceptions.InvalidTokenException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResetService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public ResetDto process(ResetIn resetIn) {
        if (resetIn.getToken() == null || !resetIn.getToken().contains("-"))
            throw new InvalidTokenException();

        String[] idAndToken = resetIn.getToken().split("-");
        if (idAndToken.length != 2)
            throw new InvalidTokenException();

        Optional<User> userOpt = findUser(idAndToken);
        User user = userOpt.orElseThrow(InvalidTokenException::new);
        user = resetPassword(user, resetIn);
        return map(user);
    }

    private Optional<User> findUser(String[] idAndToken) {
        Integer userId = parseUserId(idAndToken);
        String token = idAndToken[1];
        return userRepository.findByIdAndRestPasswordToken(userId, token);
    }

    private User resetPassword(User user, ResetIn resetIn) {
        String encodedPassword = passwordEncoder.encode(resetIn.getNewPassword());
        user.setPassword(encodedPassword);
        user.setRestPasswordToken(null);
        return userRepository.save(user);
    }

    private Integer parseUserId(String[] idAndToken) {
        try {
            return Integer.parseInt(idAndToken[0]);
        } catch (NumberFormatException e) {
            throw new InvalidTokenException();
        }
    }

    private ResetDto map(User user) {
        return ResetDto.builder()
                .password(user.getPassword())
                .build();
    }

}
