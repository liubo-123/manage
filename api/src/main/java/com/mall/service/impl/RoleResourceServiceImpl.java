package com.mall.service.impl;

import com.mall.domain.RoleResourceResponse;
import com.mall.dto.*;
import com.mall.mapper.ResourceInfoMapper;
import com.mall.mapper.RoleInfoMapper;
import com.mall.mapper.RoleResourceInfoMapper;
import com.mall.service.RoleResourceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lb
 * @date 2022/3/3
 */
@Service
public class RoleResourceServiceImpl implements RoleResourceService {
    private Map<String, List<String>> resourceRolesMap;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @Resource
    private RoleResourceInfoMapper roleResourceInfoMapper;
    @Resource
    private RoleInfoMapper roleInfoMapper;
    @Resource
    private ResourceInfoMapper resourceInfoMapper;
    @Override
    public void addRoleResource(Long resourceId, Long roleId) {
        RoleResourceInfo info = new RoleResourceInfo();
        info.setResourceId(resourceId);
        info.setRoleId(roleId);
        roleResourceInfoMapper.insert(info);
        initData();

    }

    @Override
    public void deleteRoleResource(List<Long> resourceId) {
        RoleResourceInfoExample param = new RoleResourceInfoExample();
        resourceId.stream().forEach(ids->{
            param.createCriteria().andResourceIdEqualTo(ids);
            roleResourceInfoMapper.deleteByExample(param);
        });
        initData();
    }

    @Override
    public List<RoleResourceResponse> findRoleResource(String roleName) {
        RoleInfoExample param = new RoleInfoExample();
        if(StringUtils.isNotBlank(roleName)){
            param.createCriteria().andNameLike(roleName);
        }
        List<RoleInfo> roleInfos = roleInfoMapper.selectByExample(param);
        List<RoleResourceResponse>  responses= roleInfos.stream().
                map(this::getRoleResourceResponse).
                collect(Collectors.toList());
        return responses;
    }
    private RoleResourceResponse getRoleResourceResponse(RoleInfo info){
        RoleResourceResponse response = new RoleResourceResponse();
        response.setRoleId(info.getId());
        response.setRoleName(info.getName());
        RoleResourceInfoExample param = new RoleResourceInfoExample();
        param.createCriteria().andIdEqualTo(info.getId());
        List<ResourceInfo> resource = roleResourceInfoMapper.selectByExample(param)
                .stream().map(this::getRoleResource).collect(Collectors.toList());
        response.setResource(resource);
        return response;

    }
    private ResourceInfo getRoleResource(RoleResourceInfo info){
        ResourceInfoExample param = new ResourceInfoExample();
        param.createCriteria().andIdEqualTo(info.getResourceId());
        ResourceInfo resourceInfo = resourceInfoMapper.selectByExample(param).get(0);
        return resourceInfo;

    }
    private void initData(){
        ResourceInfoExample param = new ResourceInfoExample();
        List<ResourceInfo> resourceInfos = resourceInfoMapper.selectByExample(param);
        List<Map<String, List<String>>> collect = resourceInfos.stream().map(this::getRoleIds).collect(Collectors.toList());
        collect.stream().forEach(ls->{
            resourceRolesMap=ls;
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.opsForHash().putAll("resource",resourceRolesMap);
        });
    }
    private Map<String, List<String>> getRoleIds(ResourceInfo info){
        RoleResourceInfoExample param = new RoleResourceInfoExample();
        param.createCriteria().andResourceIdEqualTo(info.getId());
        List<RoleResourceInfo> roleResourceInfos = roleResourceInfoMapper.selectByExample(param);
        List<String> roles=roleResourceInfos.stream().map(this::getRoles).collect(Collectors.toList());
        resourceRolesMap.put(info.getUrl(),roles);
        return resourceRolesMap;

    }
    private String getRoles(RoleResourceInfo info){
        RoleInfoExample param = new RoleInfoExample();
        param.createCriteria().andIdEqualTo(info.getRoleId());
        RoleInfo roleInfos = roleInfoMapper.selectByExample(param).get(0);
        String name = roleInfos.getName();
        return name;
    }
}
