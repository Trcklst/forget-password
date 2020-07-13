package com.trcklst.forgetpassword.update.utils;

import com.trcklst.forgetpassword.update.exceptions.InvalidTokenException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {

    public static Integer getUserIdFromHeader() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            return Integer.valueOf(request.getHeader("userId"));
        } catch (Exception e) {
            throw new InvalidTokenException();
        }
    }
}
