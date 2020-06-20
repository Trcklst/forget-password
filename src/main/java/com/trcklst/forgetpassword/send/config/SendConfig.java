package com.trcklst.forgetpassword.send.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;

import java.util.Locale;

@Configuration
public class SendConfig {

    @Bean
    public MessageSourceAccessor messageSourceAccessor(MessageSource messageSource) {
        return new MessageSourceAccessor(messageSource, Locale.getDefault());
    }
}
