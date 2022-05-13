package com.mall.service.impl;

import com.mall.domain.User;
import com.mall.domain.UserRequest;
import com.mall.dto.*;
import com.mall.mapper.RoleInfoMapper;
import com.mall.mapper.UserInfoMapper;
import com.mall.mapper.UserRoleInfoMapper;
import com.mall.service.UserInfoService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


/**
 * @author lb
 * @date 2022/3/2
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private UserRoleInfoMapper userRoleInfoMapper;
    @Resource
    private RoleInfoMapper roleInfoMapper;

    private Map<String, List<String>> rolesMap;

    @Override
    public void addUser(UserRequest request) {
        UserInfo info  = new UserInfo();
        info.setCreateTime(new Date());
        info.setName(request.getName());
        info.setPwd(request.getPassword());
        info.setModifyTime(new Date());
        info.setSex(request.getSex());
        info.setStaus("1");
        userInfoMapper.insert(info);
    }

    @Override
    public void deleteUser(UserRequest request) {
        UserInfo info  = new UserInfo();
        info.setStaus(request.getStatus());
        UserInfoExample param = new UserInfoExample();
        param.createCriteria().andIdEqualTo(request.getId());
        userInfoMapper.updateByExample(info,param);
    }

    @Override
    public void updateUser(UserRequest request) {
        UserInfo info  = new UserInfo();
        info.setName(request.getName());
        info.setModifyTime(new Date());
        info.setSex(request.getSex());
        info.setMail(request.getMail());
        info.setMobile(request.getMobile());
        UserInfoExample param = new UserInfoExample();
        param.createCriteria().andIdEqualTo(request.getId());
        userInfoMapper.updateByExample(info,param);
    }

    @Override
    public List<User> findUser(String username) {
        //查询数据库
        UserInfoExample param = new UserInfoExample();
        param.createCriteria().andNameEqualTo(username);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(param);
        List<User> user=userInfos.stream().map(this::getRoles).collect(Collectors.toList());
        saveUserRole(user.get(0));
        return user;
    }
    private User getRoles(UserInfo userInfos){
        UserRoleInfoExample param = new UserRoleInfoExample();
        param.createCriteria().andIdEqualTo(userInfos.getId());
        List<UserRoleInfo> userRoleInfos = userRoleInfoMapper.selectByExample(param);
        List<String> roles = userRoleInfos.stream().map(this::getRoleName).collect(Collectors.toList());
        User user = new User();
        user.setId(userInfos.getId());
        user.setUsername(userInfos.getName());
        user.setPassword(userInfos.getPwd());
        user.setStatus(Integer.parseInt(userInfos.getStaus()));
        user.setRoles(roles);
        return user;
    }
    private String getRoleName(UserRoleInfo userRoleInfo){
        RoleInfoExample param = new RoleInfoExample();
        param.createCriteria().andIdEqualTo(userRoleInfo.getRoleId());
        List<RoleInfo> roleInfos = roleInfoMapper.selectByExample(param);
        List<String> roles = roleInfos.stream().map(ls -> ls.getName()).collect(Collectors.toList());
        return roles.get(0);
    }
    private void saveUserRole(User user){
        rolesMap = new TreeMap<>();
        rolesMap.put("user_role",user.getRoles());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.opsForHash().putAll("role",rolesMap);
    }
}
