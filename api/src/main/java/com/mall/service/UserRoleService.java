package com.mall.service;

import com.mall.domain.RoleUserResponse;
import com.mall.domain.UserRoleResponse;

import java.util.List;

/**
 * @author lb
 * @date 2022/3/2
 */
public interface UserRoleService {
    /**
     * 新增
     * @param userId
     * @param roleId
     */
    public void addUserRole(Long userId,Long roleId);


    /**
     * 删除
     * @param roleId
     */
    public void deleteUserRole(List<Long> roleId);

    /**
     * 删除
     * @param userId
     */
    public void deleteRoleUser(List<Long> userId);

    /**
     * 用户角色
     * @param userName
     * @return UserRoleResponse
     */
    public List<UserRoleResponse>  findUserRole(String userName);

    /**
     * 角色用户
     * @param roleName
     * @return
     */
    public List<RoleUserResponse>  findRoleUser(String roleName);

}
