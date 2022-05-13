package com.mall.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author lb
 * @date 2022/3/2
 */
@Data
@Builder
public class RoleRequest {
    /**
     * id
     */
    private Long id;
    /**
     * 用户名（唯一）
     */
    private String name;

    /**
     * 状态
     */
    private String status;
}
