package com.mall.service.impl;

import com.mall.domain.MenuRequest;
import com.mall.dto.MenuInfo;
import com.mall.dto.MenuInfoExample;
import com.mall.mapper.MenuInfoMapper;
import com.mall.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author lb
 * @date 2022/3/2
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuInfoMapper menuInfoMapper;
    @Override
    public void addMenu(MenuRequest request) {
        MenuInfo info = new MenuInfo();
        info.setCreateTime(new Date());
        info.setModifyTime(new Date());
        info.setName(request.getName());
        info.setParentId(request.getParentId().toString());
        info.setParentName(request.getParentName());
        info.setLevel(request.getLevel());
        info.setStaus("1");
        menuInfoMapper.insert(info);
    }

    @Override
    public void deleteMenu(Long id) {
        menuInfoMapper.deleteByPrimaryKey(id);

    }

    @Override
    public void updateMenu(MenuRequest request) {
        MenuInfo info = new MenuInfo();
        info.setModifyTime(new Date());
        info.setName(request.getName());
        info.setLevel(request.getLevel());
        info.setParentId(request.getParentId().toString());
        info.setParentName(request.getParentName());
        MenuInfoExample param = new MenuInfoExample();
        param.createCriteria().andIdEqualTo(request.getId());
        menuInfoMapper.updateByExample(info,param);

    }
}
