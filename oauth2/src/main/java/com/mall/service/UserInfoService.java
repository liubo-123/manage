package com.mall.service;

import com.mall.common.CommonResult;
import com.mall.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * @author lb
 * @date 2022/3/4
 */
@FeignClient(value = "api")
public interface UserInfoService {
    @RequestMapping(value = "/user/findUser",method = RequestMethod.GET)
    /**
     * 获取用户信息
     * @param username
     * @return
     */
    CommonResult<List<User>> findUser(@RequestParam String username);
}
