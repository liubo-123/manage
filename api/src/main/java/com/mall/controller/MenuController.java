package com.mall.controller;

import com.mall.common.CommonResult;
import com.mall.domain.MenuRequest;
import com.mall.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/menu")
@Api(tags = "MenuController", description = "菜单管理")
public class MenuController {
    @Resource
    private MenuService menuService;
    @ApiOperation("新增菜单")
    @RequestMapping(value = "/addMenu",method = RequestMethod.POST)
    public CommonResult<String> addMenu(HttpServletRequest request){
        MenuRequest build = MenuRequest.builder()
                .parentId(Long.parseLong(request.getParameter("parentId")))
                .parentName(request.getParameter("parentName"))
                .name(request.getParameter("name"))
                .level(request.getParameter("level"))
                .build();
        try {
            menuService.addMenu(build);
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
        return CommonResult.success("success");
    }
    @ApiOperation("删除菜单")
    @RequestMapping(value = "/deleteMenu/{id}",method = RequestMethod.DELETE)
    public CommonResult<String> deleteMenu(@PathVariable Long id){
        try {
            menuService.deleteMenu(id);
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
        return CommonResult.success("success");
    }
    @ApiOperation("编辑菜单")
    @RequestMapping(value = "/updateMenu",method = RequestMethod.POST)
    public CommonResult<String> updateMenu(HttpServletRequest request){
        MenuRequest build = MenuRequest.builder()
                .parentId(Long.parseLong(request.getParameter("parentId")))
                .parentName(request.getParameter("parentName"))
                .name(request.getParameter("name"))
                .level(request.getParameter("level"))
                .build();
        try {
            menuService.updateMenu(build);
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
        return CommonResult.success("success");
    }
}
