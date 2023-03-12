package com.TechInc.blog.models.enums;
import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_WORKER, ROLE_DIRECTOR, ROLE_ADMIN;
    @Override
    public String getAuthority() {
        return name();
    }
}