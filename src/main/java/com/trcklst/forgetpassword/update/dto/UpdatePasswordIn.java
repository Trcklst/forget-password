package com.trcklst.forgetpassword.update.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UpdatePasswordIn {

    @NotBlank
    private String newPassword;
}
