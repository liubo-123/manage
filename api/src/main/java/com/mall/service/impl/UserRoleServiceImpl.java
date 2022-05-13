package com.mall.service.impl;

import com.mall.domain.RoleUserResponse;
import com.mall.domain.UserRoleResponse;
import com.mall.dto.*;
import com.mall.mapper.RoleInfoMapper;
import com.mall.mapper.UserInfoMapper;
import com.mall.mapper.UserRoleInfoMapper;
import com.mall.service.UserRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lb
 * @date 2022/3/3
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    private UserRoleInfoMapper userRoleInfoMapper;
    @Resource
    private RoleInfoMapper roleInfoMapper;
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public void addUserRole(Long userId, Long roleId) {
        UserRoleInfo info = new UserRoleInfo();
        info.setRoleId(roleId);
        info.setUserId(userId);
        userRoleInfoMapper.insert(info);
    }

    @Override
    public void deleteUserRole(List<Long> roleId) {
        UserRoleInfoExample param = new UserRoleInfoExample();
        roleId.stream().forEach(i -> {
            param.createCriteria().andRoleIdEqualTo(i);
            userRoleInfoMapper.deleteByExample(param);
        });
    }

    @Override
    public void deleteRoleUser(List<Long> userId) {
        UserRoleInfoExample param = new UserRoleInfoExample();
        userId.stream().forEach(i -> {
            param.createCriteria().andUserIdEqualTo(i);
            userRoleInfoMapper.deleteByExample(param);
        });
    }

    @Override
    public List<UserRoleResponse> findUserRole(String username) {
        UserInfoExample userParam = new UserInfoExample();
        if (StringUtils.isNotBlank(username)) {
            userParam.createCriteria().andNameLike(username);
        }
        List<UserInfo> userInfos = userInfoMapper.selectByExample(userParam);
        List<UserRoleResponse> userRoleResponses=userInfos.
                stream().map(this::getUserRoleResponse).collect(Collectors.toList());
        return userRoleResponses;
    }

    @Override
    public List<RoleUserResponse> findRoleUser(String roleName) {
        RoleInfoExample roleParam = new RoleInfoExample();
        if (StringUtils.isNotBlank(roleName)) {
            roleParam.createCriteria().andNameLike(roleName);
        }
        List<RoleInfo> roleInfos = roleInfoMapper.selectByExample(roleParam);
        List<RoleUserResponse> roleUserResponses=roleInfos.
                stream().map(this::getRoleUserResponse).collect(Collectors.toList());
        return roleUserResponses;
    }

    private UserRoleResponse getUserRoleResponse(UserInfo userInfo){
        UserRoleResponse response = new UserRoleResponse();
        response.setUserId(userInfo.getId());
        response.setUserName(userInfo.getName());
        UserRoleInfoExample param = new UserRoleInfoExample();
        param.createCriteria().andUserIdEqualTo(userInfo.getId());
        List<Long> roleIds = userRoleInfoMapper.selectByExample(param).
                stream().map(ls->ls.getRoleId()).collect(Collectors.toList());
        List<RoleInfo> roles = roleIds.stream().map(this::getUserRole).collect(Collectors.toList());
        response.setRole(roles);
        return response;
    }
    private RoleUserResponse getRoleUserResponse(RoleInfo roleInfo){
        RoleUserResponse response = new RoleUserResponse();
        response.setRoleId(roleInfo.getId());
        response.setRoleName(roleInfo.getName());
        UserRoleInfoExample param = new UserRoleInfoExample();
        param.createCriteria().andRoleIdEqualTo(roleInfo.getId());
        List<Long> userIds = userRoleInfoMapper.selectByExample(param).
                stream().map(ls->ls.getUserId()).collect(Collectors.toList());
        List<UserInfo> users = userIds.stream().map(this::getRoleUser).collect(Collectors.toList());
        response.setUser(users);
        return response;
    }

    private RoleInfo getUserRole(Long id) {
        RoleInfoExample param = new RoleInfoExample();
        param.createCriteria().andIdEqualTo(id);
        RoleInfo roleInfo = roleInfoMapper.selectByExample(param).get(0);
        return roleInfo;

    }
    private UserInfo getRoleUser(Long id) {
        UserInfoExample param = new UserInfoExample();
        param.createCriteria().andIdEqualTo(id);
        UserInfo info = userInfoMapper.selectByExample(param).get(0);
        return info;

    }

}
