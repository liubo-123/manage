package com.mall.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * @author lb
 */
@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum RoleEnum {
    ADMIN("ADMIN", "管理员"),
    TEST("TEST", "测试"),
    NORMAL("NORMAL", "普通");
    String code;
    String desc;
}
