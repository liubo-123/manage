package com.mall.controller;

import com.alibaba.fastjson.JSONObject;
import com.mall.common.CommonResult;
import com.mall.domain.RoleMenuResponse;
import com.mall.service.RoleMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
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
@Api(tags = "RoleMenuController", description = "角色菜单管理")
@RestController
@RequestMapping("/role/menu")
public class RoleMenuController {
    @Resource
    private RoleMenuService roleMenuService;
    @ApiOperation("角色添加菜单")
    @RequestMapping(value = "/addRoleMenu/{menuId}/{roleId}",method = RequestMethod.GET)
    public CommonResult<String> addRoleMenu(@PathVariable Long menuId,@PathVariable Long roleId ){
        try{
            roleMenuService.addRoleMenu(menuId,roleId);
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
        return CommonResult.success("success");
    }
    @ApiOperation("角色删除菜单")
    @RequestMapping(value = "/deleteRoleMenu" , method = RequestMethod.DELETE)
    public CommonResult<String> deleteRoleMenu(HttpServletRequest request){
        String menuIds=request.getParameter("menuIds");
        List<Long> menuId = JSONObject.parseArray(menuIds, Long.class);
        try{
            roleMenuService.deleteRoleMenu(menuId);
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
        return CommonResult.success("success");
    }
    @ApiOperation("角色查询菜单")
    @RequestMapping(value = "/findRoleMenu", method = RequestMethod.POST)
    public CommonResult<List<RoleMenuResponse> > findRoleMenu(HttpServletRequest request){
        List<RoleMenuResponse> roleMenu;
        String roleName = request.getParameter("roleName");
        try{
            roleMenu = roleMenuService.findRoleMenu(roleName);
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
        return CommonResult.success(roleMenu);
    }
}
