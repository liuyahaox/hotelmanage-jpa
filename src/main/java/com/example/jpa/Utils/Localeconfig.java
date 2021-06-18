package com.example.jpa.Utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
@Configuration
public class Localeconfig {
    @Bean//为了让区域信息解析器生效，将区域信息解析器注册在容器中
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
