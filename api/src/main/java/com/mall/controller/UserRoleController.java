package com.mall.controller;

import com.alibaba.fastjson.JSONObject;
import com.mall.common.CommonResult;
import com.mall.domain.UserRoleResponse;
import com.mall.service.UserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lb
 * @date 2022/3/2
 */
@RestController
@RequestMapping("/user/role")
@Api(tags = "UserRoleController",description = "用户角色管理")
public class UserRoleController {
    @Resource
    private UserRoleService userRoleService;
    @ApiOperation(value = "新增用户角色")
    @RequestMapping(value = "/addUserRole",method = RequestMethod.POST)
    public CommonResult<String> addUserRole(HttpServletRequest request){
        Long userId = Long.parseLong(request.getParameter("userId"));
        Long roleId = Long.parseLong(request.getParameter("roleId"));
        try {
            userRoleService.addUserRole(userId, roleId);
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
        return CommonResult.success("success");
    }
    @ApiOperation("用户删除角色")
    @RequestMapping(value = "/deleteUserRole",method = RequestMethod.POST)
    public CommonResult<String> deleteUserRole(HttpServletRequest request){
        String roleIds=request.getParameter("roleIds");
        List<Long> list=JSONObject.parseArray(roleIds,Long.class);
        try {
            userRoleService.deleteUserRole(list);
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
        return CommonResult.success("success");
    }
    @ApiOperation("角色删除用户")
    @RequestMapping(value = "/deleteRoleUser",method = RequestMethod.POST)
    public CommonResult<String> deleteRoleUser(HttpServletRequest request){
        String userIds=request.getParameter("userIds");
        List<Long> list=JSONObject.parseArray(userIds,Long.class);
        try {
            userRoleService.deleteRoleUser(list);
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
        return CommonResult.success("success");
    }
    @ApiOperation("用户角色")
    @RequestMapping(value = "/findUserRole",method = RequestMethod.POST)
    public CommonResult<List<UserRoleResponse>> findUserRole(HttpServletRequest request){
        String username=request.getParameter("username");
        List<UserRoleResponse> userRole;
        try {
            userRole = userRoleService.findUserRole(username);
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
        return CommonResult.success(userRole);
    }
    @ApiOperation("角色用户")
    @RequestMapping(value = "/findRoleUser",method = RequestMethod.POST)
    public CommonResult<String> findRoleUser(HttpServletRequest request){
        String roleName=request.getParameter("roleName");
        try {
            userRoleService.findRoleUser(roleName);
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
        return CommonResult.success("success");
    }

}
