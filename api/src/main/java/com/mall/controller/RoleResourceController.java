package com.mall.controller;

import com.alibaba.fastjson.JSONObject;
import com.mall.common.CommonResult;
import com.mall.domain.RoleResourceResponse;
import com.mall.service.RoleResourceService;
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
@RestController
@RequestMapping("/role/resource")
@Api(tags ="RoleResourceController" ,description = "角色资源管理")
public class RoleResourceController {
    @Resource
    private RoleResourceService roleResourceService;
    @ApiOperation("角色新增资源")
    @RequestMapping(value = "/addRoleResource/{resourceId}/{roleId}",method = RequestMethod.GET)
    public CommonResult<String> addRoleResource(@PathVariable Long resourceId, @PathVariable Long roleId ){
        try{
            roleResourceService.addRoleResource(resourceId,roleId);
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
        return CommonResult.success("success");
    }
    @ApiOperation("角色删除资源")
    @RequestMapping(value = "/deleteRoleResource",method = RequestMethod.DELETE)
    public CommonResult<String> deleteRoleResource(HttpServletRequest request){
        String resourceIds=request.getParameter("resourceIds");
        List<Long> resourceId = JSONObject.parseArray(resourceIds, Long.class);
        try{
            roleResourceService.deleteRoleResource(resourceId);
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
        return CommonResult.success("success");
    }
    @ApiOperation("角色查找资源")
    @RequestMapping(value = "/findRoleResource",method = RequestMethod.POST)
    public CommonResult<List<RoleResourceResponse> > findRoleResource(HttpServletRequest request){
        List<RoleResourceResponse> roleResource;
        String roleName = request.getParameter("roleName");
        try{
            roleResource = roleResourceService.findRoleResource(roleName);
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
        return CommonResult.success(roleResource);
    }
}
