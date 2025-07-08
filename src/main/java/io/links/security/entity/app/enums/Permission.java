/*
 * Copyright (c) 2025. Bruno NDUWARUGIRA
 */

package io.links.security.entity.app.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {
    ADMIN_SUDO_READ("admin.sudo::read"),
    ADMIN_SUDO_CREATE("admin.sudo::create"),
    ADMIN_SUDO_UPDATE("admin.sudo::update"),
    ADMIN_SUDO_DELETE("admin.sudo::delete"),
    ADMIN_SUDO_PATCH("admin.sudo::patch"),
    ADMIN_SUDO_OPTIONS("admin.sudo::options"),
    ADMIN_SUDO_TRACE("admin.sudo::trace"),

    ADMIN_READ("admin::read"),
    ADMIN_CREATE("admin::create"),
    ADMIN_UPDATE("admin::update"),
    ADMIN_DELETE("admin::delete"),
    ADMIN_PATCH("admin::patch"),
    ADMIN_OPTIONS("admin::options"),
    ADMIN_TRACE("admin::trace"),

    DEVELOPER_READ("developer::read"),
    DEVELOPER_CREATE("developer::create"),
    DEVELOPER_UPDATE("developer::update"),
    DEVELOPER_DELETE("developer::delete"),
    DEVELOPER_PATCH("developer::patch"),
    DEVELOPER_OPTIONS("developer::options"),
    DEVELOPER_TRACE("developer::trace"),

    SECURITY_MANAGER_READ("security.manager::read"),
    SECURITY_MANAGER_CREATE("security.manager::create"),
    SECURITY_MANAGER_UPDATE("security.manager::update"),
    SECURITY_MANAGER_DELETE("security.manager::delete"),
    SECURITY_MANAGER_PATCH("security.manager::patch"),
    SECURITY_MANAGER_OPTIONS("security.manager::options"),
    SECURITY_MANAGER_TRACE("security.manager::trace"),

    MANAGER_USERS_READ("manager.users::read"),
    MANAGER_USERS_CREATE("manager.users::create"),
    MANAGER_USERS_UPDATE("manager.users::update"),
    MANAGER_USERS_DELETE("manager.users::delete"),
    MANAGER_USERS_PATCH("manager.users::patch"),
    MANAGER_USERS_OPTIONS("manager.users::options"),
    MANAGER_USERS_TRACE("manager.users::trace"),

    MANAGER_TRANSACTIONS_READ("manager.transactions::read"),
    MANAGER_TRANSACTIONS_CREATE("manager.transactions::create"),
    MANAGER_TRANSACTIONS_UPDATE("manager.transactions::update"),
    MANAGER_TRANSACTIONS_DELETE("manager.transactions::delete"),
    MANAGER_TRANSACTIONS_PATCH("manager.transactions::patch"),
    MANAGER_TRANSACTIONS_OPTIONS("manager.transactions::options"),
    MANAGER_TRANSACTIONS_TRACE("manager.transactions::trace"),

    SERVICE_CLIENT_READ("service.client::read"),
    SERVICE_CLIENT_CREATE("service.client::create"),
    SERVICE_CLIENT_UPDATE("service.client::update"),
    SERVICE_CLIENT_DELETE("service.client::delete"),
    SERVICE_CLIENT_PATCH("service.client::patch"),
    SERVICE_CLIENT_OPTIONS("service.client::options"),
    SERVICE_CLIENT_TRACE("service.client::trace"),

    BUSINESS_NEEDS_ANALYST_READ("business.needs.analyst::read"),
    BUSINESS_NEEDS_ANALYST_CREATE("business.needs.analyst::create"),
    BUSINESS_NEEDS_ANALYST_UPDATE("business.needs.analyst::update"),
    BUSINESS_NEEDS_ANALYST_DELETE("business.needs.analyst::delete"),
    BUSINESS_NEEDS_ANALYST_PATCH("business.needs.analyst::patch"),
    BUSINESS_NEEDS_ANALYST_OPTIONS("business.needs.analyst::options"),
    BUSINESS_NEEDS_ANALYST_TRACE("business.needs.analyst::trace"),

    USER_PARTNER_READ("user.partner::read"),
    USER_PARTNER_CREATE("user.partner::create"),
    USER_PARTNER_UPDATE("user.partner::update"),
    USER_PARTNER_DELETE("user.partner::delete"),
    USER_PARTNER_PATCH("user.partner::patch"),
    USER_PARTNER_OPTIONS("user.partner::options"),
    USER_PARTNER_TRACE("user.partner::trace"),

    USER_STANDARD_READ("user.standard::read"),
    USER_STANDARD_CREATE("user.standard::create"),
    USER_STANDARD_UPDATE("user.standard::update"),
    USER_STANDARD_DELETE("user.standard::delete"),
    USER_STANDARD_PATCH("user.standard::patch"),
    USER_STANDARD_OPTIONS("user.standard::options"),
    USER_STANDARD_TRACE("user.standard::trace");

    private final String permission;
}
