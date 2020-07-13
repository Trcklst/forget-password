package com.trcklst.forgetpassword.update;

import com.trcklst.forgetpassword.update.dto.UpdatePasswordDto;
import com.trcklst.forgetpassword.update.dto.UpdatePasswordIn;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/password/update/")
public class UpdatePasswordController {

    private final UpdatePasswordService updatePasswordService;

    @PatchMapping
    public UpdatePasswordDto updatePassword(@RequestBody @Valid UpdatePasswordIn updatePasswordIn) {
        return updatePasswordService.process(updatePasswordIn);
    }
}
