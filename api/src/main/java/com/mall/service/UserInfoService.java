package com.mall.service;


import com.mall.domain.User;
import com.mall.domain.UserRequest;

import java.util.List;

/**
 * @author lb
 * @date 2022/3/2
 */
public interface UserInfoService {
    /**
     * 新增
     * @param request
     * @return
     */
    void addUser(UserRequest request);

    /**
     * status =0 启用 禁用
     * @param request
     * @return
     */
    void deleteUser(UserRequest request);

    /**
     * 编辑
     * @param request
     * @return
     */
    void updateUser(UserRequest request);

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    List<User> findUser(String username);
}
