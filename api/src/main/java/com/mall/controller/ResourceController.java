package com.mall.controller;

import com.mall.common.CommonResult;
import com.mall.domain.ResourceRequest;
import com.mall.domain.ResourceResponse;
import com.mall.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lb
 * @date 2022/3/2
 */
@RestController
@RequestMapping("/resource")
@Api(tags = "ResourceController", description = "资源管理")
public class ResourceController {
    @Resource
    private ResourceService resourceService;
    @ApiOperation("新增资源")
    @RequestMapping(value = "/addResource",method = RequestMethod.POST)
    public CommonResult<String> addResource(HttpServletRequest request){
        ResourceRequest build = ResourceRequest.builder()
                .name(request.getParameter("name"))
                .url(request.getParameter("url"))
                .description(request.getParameter("description"))
                .build();
        try {
            resourceService.addResource(build);
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
        return CommonResult.success("success");
    }
    @ApiOperation("删除资源")
    @RequestMapping(value = "/deleteResource/{id}",method = RequestMethod.DELETE)
    public CommonResult<String> deleteResource(@PathVariable Long id){
        try {
            resourceService.deleteResource(id);
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
        return CommonResult.success("success");
    }
    @ApiOperation("编辑资源")
    @RequestMapping(value = "/updateResource",method = RequestMethod.POST)
    public CommonResult<String> updateResource(HttpServletRequest request){
        ResourceRequest build = ResourceRequest.builder()
                .name(request.getParameter("name"))
                .url(request.getParameter("url"))
                .description(request.getParameter("description"))
                .build();
        try {
            resourceService.updateResource(build);
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
        return CommonResult.success("success");
    }
    @ApiOperation("初始化资源")
    @RequestMapping(value = "/initResource",method = RequestMethod.GET)
    public CommonResult<String> initResource(){
        try {
            resourceService.initResource();
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
        return CommonResult.success("success");
    }
    @ApiOperation("获取资源")
    @RequestMapping(value = "/getResource",method = RequestMethod.POST)
    public CommonResult<List<ResourceResponse>> getResource(@RequestBody ResourceRequest request){
        List<ResourceResponse> data;
        try {
            data =resourceService.getResource(request);
        }catch (Exception e){
            return CommonResult.failed("fail");
        }
        return CommonResult.success(data);
    }
}
