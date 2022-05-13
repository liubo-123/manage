package com.mall.service;


import com.mall.domain.ResourceRequest;
import com.mall.domain.ResourceResponse;

import java.util.List;

/**
 * @author lb
 * @date 2022/3/2
 */
public interface ResourceService {
    /**
     * 新增
     * @param request
     * @throws Exception
     */
    void addResource(ResourceRequest request) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     */
    void deleteResource(Long id);

    /**
     * 编辑
     * @param request
     * @return
     */
    void updateResource(ResourceRequest request);

    /**
     * 初始化资源
     */
    void initResource();

    /**
     * 获取资源
     * @return
     * @param request
     */
    List<ResourceResponse> getResource(ResourceRequest request);
}
