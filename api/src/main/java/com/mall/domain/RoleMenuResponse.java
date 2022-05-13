package com.mall.domain;

import com.mall.dto.MenuInfo;
import lombok.Data;

import java.util.List;

/**
 * @author lb
 * @date 2022/3/3
 */
@Data
public class RoleMenuResponse {
    /**
     * id
     */
    private Long roleId;
    /**
     * name
     */
    private String roleName;
    /**
     * 角色
     */
    private List<MenuInfo> menu;
}
