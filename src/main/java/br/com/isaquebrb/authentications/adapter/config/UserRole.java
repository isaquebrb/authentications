package br.com.isaquebrb.authentications.adapter.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static br.com.isaquebrb.authentications.adapter.config.UserPermission.*;

@Getter
@RequiredArgsConstructor
public enum UserRole {

    USER_BURGER(Set.of(BURGER_READ, BURGER_WRITE)),
    USER_ADMIN(Set.of(BURGER_READ, BURGER_WRITE, ADMIN_READ, ADMIN_WRITE));

    private final Set<UserPermission> userPermissions;
}
