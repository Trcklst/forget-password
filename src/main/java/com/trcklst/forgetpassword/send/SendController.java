package com.trcklst.forgetpassword.send;

import com.trcklst.forgetpassword.send.dto.SendDto;
import com.trcklst.forgetpassword.send.dto.SendIn;
import com.trcklst.forgetpassword.send.exceptions.EmailNotExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/forget-password/send/")
public class SendController {

    private final SendService sendService;

    @PostMapping
    public SendDto send(@RequestBody SendIn sendIn) throws EmailNotExistsException {
        return sendService.process(sendIn);
    }
}
