package com.mall.service;

import com.mall.domain.RoleResourceResponse;

import java.util.List;

/**
 * @author lb
 * @date 2022/3/2
 */
public interface RoleResourceService {
    /**
     * 新增
     * @param resourceId
     * @param roleId
     */
    public void addRoleResource(Long resourceId,Long roleId);


    /**
     * 删除
     * @param resourceId
     */
    public void deleteRoleResource(List<Long> resourceId);


    /**
     * 角色菜单
     * @param roleName
     * @return RoleResourceResponse
     */
    public List<RoleResourceResponse>  findRoleResource(String roleName);
}
