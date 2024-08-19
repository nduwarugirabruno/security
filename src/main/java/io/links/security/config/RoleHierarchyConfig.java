package io.links.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

@Configuration
public class RoleHierarchyConfig {

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();

        // Définir la hiérarchie ici
        String hierarchy = """
                ADMIN_SUDO > ADMIN_SUDO_POOLS
                ADMIN_SUDO > SERVICE_CLIENT
                ADMIN_SUDO_POOLS > ADMIN_POOL
                ADMIN_POOL > MANAGER_TRANSACTIONS
                MANAGER_TRANSACTIONS > SERVICE_CLIENT""";

        roleHierarchy.setHierarchy(hierarchy);
        return roleHierarchy;
    }
}
