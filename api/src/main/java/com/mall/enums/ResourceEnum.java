package com.mall.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author lb
 */
@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ResourceEnum {
    MENU("MenuController", "菜单管理"),
    RESOURCE("ResourceController", "资源管理"),
    USER("UserInfoController", "用户管理"),
    ROLE("RoleInfoController", "角色管理"),
    USER_ROLE("UserRoleController", "用户角色管理"),
    ROLE_MENU("RoleMenuController", "角色菜单管理"),
    ROLE_RESOURCE("RoleResourceController", "角色资源管理");
    String code;
    String desc;

    public static String descOf(String code){
        return Arrays.stream(ResourceEnum.values())
                .filter(ls->Objects.equals(ls.code,code))
                .map(ResourceEnum::getDesc)
                .findFirst()
                .orElse(null);
    }
}
