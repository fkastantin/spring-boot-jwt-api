package com.karma.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    public final String SECRET = "sdf22wedssqq.,.m/";
    public final long EXPIRATION_TIME = 864_000_000;
    public final String TOKEN_PREFIX = "Bearer ";
    public final String HEADER_STRING = "Authorization";
    public final String SIGN_UP_URL = "/users/sign-up";

}
