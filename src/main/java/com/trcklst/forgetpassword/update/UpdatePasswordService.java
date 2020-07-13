package com.trcklst.forgetpassword.update;

import com.trcklst.forgetpassword.db.User;
import com.trcklst.forgetpassword.db.UserRepository;
import com.trcklst.forgetpassword.update.dto.UpdatePasswordDto;
import com.trcklst.forgetpassword.update.dto.UpdatePasswordIn;
import com.trcklst.forgetpassword.update.exceptions.InvalidTokenException;
import com.trcklst.forgetpassword.update.utils.RequestUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePasswordService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UpdatePasswordDto process(UpdatePasswordIn updatePasswordIn) {
        Integer userId = RequestUtils.getUserIdFromHeader();
        User user = userRepository.findById(userId).orElseThrow(InvalidTokenException::new);
        user.setPassword(passwordEncoder.encode(updatePasswordIn.getNewPassword()));
        userRepository.save(user);
        UpdatePasswordDto updatePasswordDto = new UpdatePasswordDto();
        updatePasswordDto.setEmail(user.getUsername());
        return updatePasswordDto;
    }

}
