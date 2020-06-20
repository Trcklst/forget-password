package com.trcklst.forgetpassword.reset;

import com.trcklst.forgetpassword.reset.dto.ResetDto;
import com.trcklst.forgetpassword.reset.dto.ResetIn;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/forget-password/reset/")
public class ResetController {

    private final ResetService resetService;

    @PostMapping
    public ResetDto reset(@RequestBody ResetIn resetIn) {
        return resetService.process(resetIn);
    }
}
