package com.mall.service;

import com.mall.domain.RoleRequest;

/**
 * @author lb
 * @date 2022/3/2
 */
public interface RoleInfoService {
    /**
     * 新增
     * @param request
     * @return
     */
    void addRole(RoleRequest request);

    /**
     * 删除
     * @param id
     * @return
     */
    void deleteRole(Long id);

    /**
     * 编辑
     * @param request
     * @return
     */
    void updateRole(RoleRequest request);
}
