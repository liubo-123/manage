package com.mall.domain;

import com.mall.dto.UserInfo;
import lombok.Data;

import java.util.List;

/**
 * @author lb
 * @date 2022/3/3
 */
@Data
public class RoleUserResponse {
    /**
     * id
     */
    private Long roleId;
    private String roleName;
    /**
     * 角色
     */
    private List<UserInfo> user;
}
