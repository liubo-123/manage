package com.mall.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author lb
 * @date 2022/3/2
 */
@Data
@Builder
public class ResourceResponse {
    /**
     * id
     */
    private Long id;
    /**
     *  资源名称
     */
    private String name;
    /**
     *  url
     */
    private String url;
    /**
     *  描述
     */
    private String description;


}
