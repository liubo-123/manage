package com.mall.service;


import com.mall.domain.RoleMenuResponse;

import java.util.List;

/**
 * @author lb
 * @date 2022/3/2
 */
public interface RoleMenuService {
    /**
     * 新增
     * @param menuId
     * @param roleId
     */
    public void addRoleMenu(Long menuId,Long roleId);


    /**
     * 删除
     * @param menuId
     */
    public void deleteRoleMenu(List<Long> menuId);


    /**
     * 角色菜单
     * @param roleName
     * @return UserRoleResponse
     */
    public List<RoleMenuResponse>  findRoleMenu(String roleName);

}
