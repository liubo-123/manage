package com.mall.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author lb
 * @date 2022/3/2
 */
@Data
@Builder
public class MenuRequest {
    /**
     * id
     */
    private Long id;
    /**
     *  菜单名称
     */
    private String name;
    /**
     *  父级id
     */
    private Long parentId;
    /**
     *  父级名称
     */
    private String parentName;
    /**
     * 级别
     */
    private String level;


}
