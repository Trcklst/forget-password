package com.trcklst.forgetpassword.reset.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResetDto {

    private String password;
}
