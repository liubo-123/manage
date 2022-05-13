package com.mall.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author lb
 * @date 2022/3/2
 */
@Data
@Builder
public class UserRequest {
    /**
     * id
     */
    private Long id;
    /**
     * 用户名（唯一）
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别
     */
    private String sex;
    /**
     *
     */
    private String mobile;
    /**
     *
     */
    private String mail;
    /**
     * 状态
     */
    private String status;
}
