package com.mall.service.impl;

import com.mall.domain.RoleRequest;
import com.mall.dto.RoleInfo;
import com.mall.dto.RoleInfoExample;
import com.mall.mapper.RoleInfoMapper;
import com.mall.service.RoleInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author lb
 * @date 2022/3/2
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService {
    @Resource
    private RoleInfoMapper roleInfoMapper;
    @Override
    public void addRole(RoleRequest request) {
        RoleInfo info = new RoleInfo();
        info.setCreateTime(new Date());
        info.setModifyTime(new Date());
        info.setName(request.getName());
        info.setStaus("1");
        roleInfoMapper.insert(info);
    }

    @Override
    public void deleteRole(Long id) {
        roleInfoMapper.deleteByPrimaryKey(id);

    }

    @Override
    public void updateRole(RoleRequest request) {
        RoleInfo info = new RoleInfo();
        info.setModifyTime(new Date());
        info.setName(request.getName());
        RoleInfoExample param = new RoleInfoExample();
        param.createCriteria().andIdEqualTo(request.getId());
        roleInfoMapper.updateByExample(info,param);

    }
}
