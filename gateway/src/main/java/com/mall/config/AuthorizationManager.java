package com.mall.config;

import cn.hutool.core.convert.Convert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.net.URI;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 鉴权管理器，用于判断是否有资源的访问权限
 * @author lb
 * @date 2022/1/18
 */
@Slf4j
@Component
public class AuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        //从redis中获取当前路径可访问角色列表
        String role = "admin";
        List<String> authorities = new ArrayList<>();
        authorities = (List<String>) redisTemplate.opsForHash().get("role","user_role");
        if(authorities==null || !role.equals(authorities.get(0))) {
            URI uri = authorizationContext.getExchange().getRequest().getURI();
            String url = uri.getPath();
            Object resource = redisTemplate.opsForHash().get("resource", url);
            authorities = Convert.toList(String.class, resource);

        }
        authorities = authorities.stream().map(i -> i = "role_" + i).collect(Collectors.toList());
        //认证通过且角色匹配的用户可访问当前路径
        return mono
                .filter(Authentication::isAuthenticated)
                .flatMapIterable(Authentication::getAuthorities)
                .map(GrantedAuthority::getAuthority)
                .any(authorities::contains)
                .map(AuthorizationDecision::new)
                .defaultIfEmpty(new AuthorizationDecision(false));
    }
}