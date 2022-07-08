package br.com.isaquebrb.authentications.adapter.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserPermission {

    BURGER_READ("burger:read"),
    BURGER_WRITE("burger:write"),
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write");

    private final String permission;
}
