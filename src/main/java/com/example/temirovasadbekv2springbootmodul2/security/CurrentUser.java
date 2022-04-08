package com.example.temirovasadbekv2springbootmodul2.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.PARAMETER})
@AuthenticationPrincipal
public @interface CurrentUser {
}
