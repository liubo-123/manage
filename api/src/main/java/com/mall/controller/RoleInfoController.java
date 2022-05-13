package com.mall.controller;

import com.mall.common.CommonResult;
import com.mall.domain.RoleRequest;
import com.mall.service.RoleInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author lb
 * @date 2022/3/2
 */
@RestController
@RequestMapping("/role")
@Api(tags = "RoleInfoController", description = "角色管理")
public class RoleInfoController {
    @Resource
    private RoleInfoService roleInfoService;
    @ApiOperation("新增角色")
    @RequestMapping(value = "/addRole",method = RequestMethod.POST)
    public CommonResult<String> addUser(HttpServletRequest request){
        RoleRequest build = RoleRequest.builder()
                .name(request.getParameter("name"))
                .build();
        try {
            roleInfoService.addRole(build);
            return CommonResult.success("success");
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
    }
    @ApiOperation("删除角色")
    @RequestMapping(value = "/disableUser",method = RequestMethod.GET)
    public CommonResult<String> disableUser(HttpServletRequest request){
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            roleInfoService.deleteRole(id);
            return CommonResult.success("success");
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
    }
    @ApiOperation("编辑角色")
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public CommonResult<String> updateUser(HttpServletRequest request){
        RoleRequest build = RoleRequest.builder()
                .name(request.getParameter("name"))
                .id(Long.parseLong(request.getParameter("id")))
                .build();
        try {
            roleInfoService.updateRole(build);
            return CommonResult.success("success");
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
    }
}
