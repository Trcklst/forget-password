package com.trcklst.forgetpassword.reset.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ResetIn {

    @NotNull
    private String token;
    @NotBlank
    private String newPassword;
}
