package com.trcklst.forgetpassword.send.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SendDto {

    private String token;
}
