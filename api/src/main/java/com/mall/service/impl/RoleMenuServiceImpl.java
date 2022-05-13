package com.mall.service.impl;

import com.mall.domain.RoleMenuResponse;
import com.mall.dto.*;
import com.mall.mapper.MenuInfoMapper;
import com.mall.mapper.RoleInfoMapper;
import com.mall.mapper.RoleMenuInfoMapper;
import com.mall.service.RoleMenuService;
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
public class RoleMenuServiceImpl implements RoleMenuService {
    @Resource
    private RoleMenuInfoMapper roleMenuInfoMapper;
    @Resource
    private RoleInfoMapper roleInfoMapper;
    @Resource
    private MenuInfoMapper menuInfoMapper;
    @Override
    public void addRoleMenu(Long menuId, Long roleId) {
        RoleMenuInfo info = new RoleMenuInfo();
        info.setMemuId(menuId);
        info.setRoleId(roleId);
        roleMenuInfoMapper.insert(info);

    }

    @Override
    public void deleteRoleMenu(List<Long> menuId) {
        RoleMenuInfoExample param = new RoleMenuInfoExample();
        menuId.stream().forEach(ids->{
            param.createCriteria().andMemuIdEqualTo(ids);
            roleMenuInfoMapper.deleteByExample(param);
        });
    }

    @Override
    public List<RoleMenuResponse> findRoleMenu(String roleName) {
        RoleInfoExample param = new RoleInfoExample();
        if(StringUtils.isNotBlank(roleName)){
            param.createCriteria().andNameLike(roleName);
        }
        List<RoleInfo> roleInfos = roleInfoMapper.selectByExample(param);
        List<RoleMenuResponse>  responses= roleInfos.stream().
                map(this::getRoleMenuResponse).
                collect(Collectors.toList());
        return responses;
    }
    private RoleMenuResponse getRoleMenuResponse(RoleInfo info){
        RoleMenuResponse response = new RoleMenuResponse();
        response.setRoleId(info.getId());
        response.setRoleName(info.getName());
        RoleMenuInfoExample param = new RoleMenuInfoExample();
        param.createCriteria().andIdEqualTo(info.getId());
        List<MenuInfo> menus = roleMenuInfoMapper.selectByExample(param)
                .stream().map(this::getRoleMenu).collect(Collectors.toList());
        response.setMenu(menus);
        return response;

    }
    private MenuInfo getRoleMenu(RoleMenuInfo info){
        MenuInfoExample param = new MenuInfoExample();
        param.createCriteria().andIdEqualTo(info.getMemuId());
        MenuInfo menuInfo = menuInfoMapper.selectByExample(param).get(0);
        return menuInfo;

    }
}
