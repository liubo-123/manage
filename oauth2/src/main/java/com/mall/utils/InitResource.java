//package com.mall.utils;
//
//import com.mall.common.CommonResult;
//import com.mall.dto.*;
//import com.mall.mapper.ResourceInfoMapper;
//import com.mall.mapper.RoleInfoMapper;
//import com.mall.mapper.RoleResourceInfoMapper;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;
//import java.util.stream.Collectors;
//
///**
// * @author lb
// * @date 2022/3/4
// */
//@RestController
//@RequestMapping("/redis")
//public class InitResource {
//    private Map<String, List<String>> resourceRolesMap = new TreeMap<>();
//    @Resource
//    private RedisTemplate<String,Object> redisTemplate;
//    @Resource
//    private RoleResourceInfoMapper roleResourceInfoMapper;
//    @Resource
//    private RoleInfoMapper roleInfoMapper;
//    @Resource
//    private ResourceInfoMapper resourceInfoMapper;
//    @RequestMapping(value = "/init",method = RequestMethod.GET)
//    public CommonResult<String> init(){
//        try {
//            initData();
//            Object resource = redisTemplate.opsForHash().get("resource", "/api/user/currentUser");
//        }catch (Exception e){
//            return CommonResult.failed("fail");
//        }
//        return CommonResult.success("success");
//    }
//    private void initData(){
//        ResourceInfoExample param = new ResourceInfoExample();
//        List<ResourceInfo> resourceInfos = resourceInfoMapper.selectByExample(param);
//        List<Map<String, List<String>>> collect = resourceInfos.stream().map(this::getRoleIds).collect(Collectors.toList());
//        collect.stream().forEach(ls->{
//            resourceRolesMap=ls;
//            redisTemplate.opsForHash().putAll("resource",resourceRolesMap);
//        });
//    }
//    private Map<String, List<String>> getRoleIds(ResourceInfo info){
//        RoleResourceInfoExample param = new RoleResourceInfoExample();
//        param.createCriteria().andResourceIdEqualTo(info.getId());
//        List<RoleResourceInfo> roleResourceInfos = roleResourceInfoMapper.selectByExample(param);
//        List<String> roles=roleResourceInfos.stream().map(this::getRoles).collect(Collectors.toList());
//        resourceRolesMap.put(info.getUrl(),roles);
//        return resourceRolesMap;
//
//    }
//    private String getRoles(RoleResourceInfo info){
//        RoleInfoExample param = new RoleInfoExample();
//        param.createCriteria().andIdEqualTo(info.getRoleId());
//        RoleInfo roleInfos = roleInfoMapper.selectByExample(param).get(0);
//        String name = roleInfos.getName();
//        return name;
//    }
//
//}
