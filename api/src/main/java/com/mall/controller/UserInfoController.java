package com.mall.controller;

import com.mall.common.CommonResult;
import com.mall.domain.User;
import com.mall.domain.UserRequest;
import com.mall.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lb
 * @date 2022/3/2
 */
@RestController
@RequestMapping("/user")
@Api(tags = "UserInfoController",description = "用户管理")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;
    @ApiOperation("新增用户")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public CommonResult<String> addUser(HttpServletRequest request){
        UserRequest build = UserRequest.builder()
                .mail(request.getParameter("mail"))
                .mobile(request.getParameter("mobile"))
                .name(request.getParameter("name"))
                .password(request.getParameter("password"))
                .sex(request.getParameter("sex"))
                .build();
        try {
            userInfoService.addUser(build);
            return CommonResult.success("success");
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
    }
    @ApiOperation("用户启用禁用")
    @RequestMapping(value = "/disableUser",method = RequestMethod.POST)
    public CommonResult<String> disableUser(HttpServletRequest request){
        UserRequest build = UserRequest.builder()
                .status(request.getParameter("status"))
                .build();
        try {
            userInfoService.deleteUser(build);
            return CommonResult.success("success");
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
    }
    @ApiOperation("编辑用户")
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public CommonResult<String> updateUser(HttpServletRequest request){
        UserRequest build = UserRequest.builder()
                .sex(request.getParameter("sex"))
                .name(request.getParameter("name"))
                .mobile(request.getParameter("mobile"))
                .mail(request.getParameter("mail"))
                .build();
        try {
            userInfoService.updateUser(build);
            return CommonResult.success("success");
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
    }
    @ApiOperation("获取用户信息")
    @RequestMapping(value = "/findUser",method = RequestMethod.GET)
    public CommonResult<List<User>> findUser(@RequestParam String username){
        List<User> u;
        try {
            u = userInfoService.findUser(username);
            return CommonResult.success(u);
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
    }
}
