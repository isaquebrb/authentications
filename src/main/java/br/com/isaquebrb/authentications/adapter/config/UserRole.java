package br.com.isaquebrb.authentications.adapter.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static br.com.isaquebrb.authentications.adapter.config.UserPermission.ADMIN_READ;
import static br.com.isaquebrb.authentications.adapter.config.UserPermission.ADMIN_WRITE;
import static br.com.isaquebrb.authentications.adapter.config.UserPermission.BURGER_READ;
import static br.com.isaquebrb.authentications.adapter.config.UserPermission.BURGER_WRITE;

@Getter
@RequiredArgsConstructor
public enum UserRole {

    USER_BURGER(Set.of(BURGER_READ, BURGER_WRITE)),
    USER_ADMIN(Set.of(BURGER_READ, BURGER_WRITE, ADMIN_READ, ADMIN_WRITE));

    private final Set<UserPermission> userPermissions;

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getUserPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
