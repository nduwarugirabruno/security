package io.links.security.entity.app.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static io.links.security.entity.app.enums.Permission.*;

@Getter
@RequiredArgsConstructor
public enum Role {
    ADMIN_SUDO(
            Set.of(
                    ADMIN_SUDO_READ, ADMIN_SUDO_CREATE, ADMIN_SUDO_UPDATE, ADMIN_SUDO_DELETE, ADMIN_SUDO_PATCH, ADMIN_SUDO_OPTIONS, ADMIN_SUDO_TRACE
            )
    ),
    ADMIN(
            Set.of(
                    ADMIN_READ, ADMIN_CREATE, ADMIN_UPDATE, ADMIN_DELETE, ADMIN_PATCH,  ADMIN_OPTIONS, ADMIN_TRACE
            )
    ),
    DEVELOPER(
            Set.of(
                    DEVELOPER_READ, DEVELOPER_CREATE, DEVELOPER_UPDATE, DEVELOPER_DELETE, DEVELOPER_PATCH, DEVELOPER_OPTIONS, DEVELOPER_TRACE
            )
    ),
    SECURITY_MANAGER(
            Set.of(
                    SECURITY_MANAGER_READ, SECURITY_MANAGER_CREATE, SECURITY_MANAGER_UPDATE, SECURITY_MANAGER_DELETE, SECURITY_MANAGER_PATCH, SECURITY_MANAGER_OPTIONS, SECURITY_MANAGER_TRACE
            )
    ),
    MANAGER_USERS(
            Set.of(
                    MANAGER_USERS_READ, MANAGER_USERS_CREATE, MANAGER_USERS_UPDATE, MANAGER_USERS_DELETE, MANAGER_USERS_PATCH, MANAGER_USERS_OPTIONS, MANAGER_USERS_TRACE, ADMIN_READ
            )
    ),
    MANAGER_TRANSACTIONS(
            Set.of(
                    MANAGER_TRANSACTIONS_READ, MANAGER_TRANSACTIONS_CREATE, MANAGER_TRANSACTIONS_UPDATE, MANAGER_TRANSACTIONS_DELETE, MANAGER_TRANSACTIONS_PATCH, MANAGER_TRANSACTIONS_OPTIONS, MANAGER_TRANSACTIONS_TRACE
            )
    ),
    SERVICE_CLIENT(
            Set.of(
                    SERVICE_CLIENT_READ, SERVICE_CLIENT_CREATE, SERVICE_CLIENT_UPDATE, SERVICE_CLIENT_DELETE, SERVICE_CLIENT_PATCH, SERVICE_CLIENT_OPTIONS, SERVICE_CLIENT_TRACE
            )
    ),
    BUSINESS_NEEDS_ANALYST(
            Set.of(
                    BUSINESS_NEEDS_ANALYST_READ, BUSINESS_NEEDS_ANALYST_CREATE, BUSINESS_NEEDS_ANALYST_UPDATE, BUSINESS_NEEDS_ANALYST_DELETE, BUSINESS_NEEDS_ANALYST_PATCH, BUSINESS_NEEDS_ANALYST_OPTIONS, BUSINESS_NEEDS_ANALYST_TRACE
            )
    ),
    USER_PARTNER(
            Set.of(
                    USER_PARTNER_READ, USER_PARTNER_CREATE, USER_PARTNER_UPDATE, USER_PARTNER_DELETE, USER_PARTNER_PATCH, USER_PARTNER_OPTIONS, USER_PARTNER_TRACE
            )
    ),
    USER_STANDARD(
            Set.of(
                    USER_STANDARD_READ, USER_STANDARD_CREATE, USER_STANDARD_UPDATE, USER_STANDARD_DELETE, USER_STANDARD_PATCH, USER_STANDARD_OPTIONS, USER_STANDARD_TRACE
            )
    );

    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission())) //permission.name()
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
