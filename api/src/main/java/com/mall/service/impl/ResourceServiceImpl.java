package com.mall.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mall.domain.ResourceRequest;
import com.mall.domain.ResourceResponse;
import com.mall.dto.ResourceInfo;
import com.mall.dto.ResourceInfoExample;
import com.mall.enums.ResourceEnum;
import com.mall.mapper.ResourceInfoMapper;
import com.mall.service.ResourceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lb
 * @date 2022/3/2
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Value("${env.url}")
    private String url;
    @Resource
    private ResourceInfoMapper resourceInfoMapper;
    @Override
    public void addResource(ResourceRequest request) throws Exception{
        ResourceInfoExample param = new ResourceInfoExample();
        param.createCriteria().andUrlEqualTo(request.getUrl());
        List<ResourceInfo> resourceInfos = resourceInfoMapper.selectByExample(param);
        if(resourceInfos.size()>0){
            throw new Exception("该资源已存在");
        }
        ResourceInfo info = new ResourceInfo();
        info.setCreateTime(new Date());
        info.setModifyTime(new Date());
        info.setName(request.getName());
        info.setUrl(request.getUrl());
        info.setDescription(request.getDescription());
        resourceInfoMapper.insert(info);
    }

    @Override
    public void deleteResource(Long id) {
        resourceInfoMapper.deleteByPrimaryKey(id);

    }

    @Override
    public void updateResource(ResourceRequest request) {
        ResourceInfo info = new ResourceInfo();
        info.setModifyTime(new Date());
        info.setName(request.getName());
        info.setUrl(request.getUrl());
        info.setDescription(request.getDescription());
        ResourceInfoExample param = new ResourceInfoExample();
        param.createCriteria().andIdEqualTo(request.getId());
        resourceInfoMapper.updateByExample(info,param);

    }

    @Override
    public void initResource() {
        //
        String msg = HttpUtil.get(url + "/v2/api-docs");
        JSONObject data = JSONObject.parseObject(msg);
        JSONObject arr = data.getJSONObject("paths");
        Map<String, Object> innerMap = arr.getInnerMap();
        List<ResourceResponse> list = new ArrayList();
        List<ResourceInfo> records = new ArrayList();
        innerMap.keySet().stream().map(
                ls->{
                    JSONObject o = (JSONObject)innerMap.get(ls);
                    ResourceInfo record= new ResourceInfo();
                    record.setDescription(ResourceEnum.descOf(getSummary(o).get("tags")));
                    record.setUrl(ls);
                    record.setName(getSummary(o).get("summary"));
                    record.setModifyTime(new Date());
                    record.setCreateTime(new Date());
                    records.add(record);
                    return null;
                }
        ).collect(Collectors.toList());
        //批量查询
        resourceInfoMapper.batchInsert(records);
    }

    @Override
    public List<ResourceResponse> getResource(ResourceRequest request) {
        ResourceInfoExample param = new ResourceInfoExample();
        ResourceInfoExample.Criteria criteria = param.createCriteria();
        if(StringUtils.isNotBlank(request.getDescription())){
            criteria.andDescriptionEqualTo(request.getDescription());
        }
        if(StringUtils.isNotBlank(request.getUrl())){
            criteria.andUrlEqualTo(request.getUrl());
        }
        if(StringUtils.isNotBlank(request.getName())){
            criteria.andNameEqualTo(request.getName());
        }
        List<ResourceInfo> resourceInfos = resourceInfoMapper.selectByExample(param);
        List<ResourceResponse> responses = resourceInfos.stream().map(this::buildResourceResponse).collect(Collectors.toList());

        return responses;
    }
    private ResourceResponse buildResourceResponse(ResourceInfo info){
        ResourceResponse response =ResourceResponse.builder()
                .description(info.getDescription())
                .id(info.getId())
                .name(info.getName())
                .url(info.getUrl()).build();
        return response;

    }

    private Map<String,String> getSummary(JSONObject o){
        Map<String,String> map = new HashMap();
        String summary = "";
        String tags = "";
        if(o.getJSONObject("post")!=null){
            summary=o.getJSONObject("post").getString("summary");
            tags=o.getJSONObject("post").getJSONArray("tags").getString(0);
        }else if(o.getJSONObject("get")!=null){
            summary=o.getJSONObject("get").getString("summary");
            tags=o.getJSONObject("get").getJSONArray("tags").getString(0);
        }else if(o.getJSONObject("delete")!=null){
            summary=o.getJSONObject("delete").getString("summary");
            tags=o.getJSONObject("delete").getJSONArray("tags").getString(0);
        }else if(o.getJSONObject("update")!=null){
            summary=o.getJSONObject("update").getString("summary");
            tags=o.getJSONObject("update").getJSONArray("tags").getString(0);
        }
        map.put("summary",summary);
        map.put("tags",tags);
        return map;
    }
}
