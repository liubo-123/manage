package com.mall.service;

import cn.hutool.core.collection.CollUtil;
import com.mall.common.CommonResult;
import com.mall.domain.SecurityUser;
import com.mall.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lb
 * @date 2022/1/18
 */
@Service
@Slf4j
public class UserService implements UserDetailsService {

    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private UserInfoService userInfoService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        //查询数据库
        CommonResult<List<User>> result = userInfoService.findUser(username);
        if (CollUtil.isNotEmpty( result.getData())) {
        User user = result.getData().get(0);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
            SecurityUser securityUser = new SecurityUser(user);
            return securityUser;
        }else{
            throw new UsernameNotFoundException("用户名密码错误");
        }
    }

}
