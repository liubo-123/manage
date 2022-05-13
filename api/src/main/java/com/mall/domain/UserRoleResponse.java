package com.mall.domain;

import com.mall.dto.RoleInfo;
import lombok.Data;

import java.util.List;

/**
 * @author lb
 * @date 2022/3/3
 */
@Data
public class UserRoleResponse {
    /**
     * id
     */
    private Long userId;
    /**
     * name
     */
    private String userName;
    /**
     * 角色
     */
    private List<RoleInfo> role;
}
