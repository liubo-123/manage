package com.mall.service;

import com.mall.domain.MenuRequest;

/**
 * @author lb
 * @date 2022/3/2
 */
public interface MenuService {
    /**
     * 新增
     * @param request
     * @return
     */
    void addMenu(MenuRequest request);

    /**
     * 删除
     * @param id
     * @return
     */
    void deleteMenu(Long id);

    /**
     * 编辑
     * @param request
     * @return
     */
    void updateMenu(MenuRequest request);
}
