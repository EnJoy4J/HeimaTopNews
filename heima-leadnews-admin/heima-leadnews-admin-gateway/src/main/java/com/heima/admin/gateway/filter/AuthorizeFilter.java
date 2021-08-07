package com.heima.admin.gateway.filter;

import com.fasterxml.jackson.databind.ser.impl.StringArraySerializer;
import com.heima.utils.common.AppJwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Component
@Log4j2
public class AuthorizeFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //拿到请求与响应的对象
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        //判断是否为登录请求，加入是的话，就放行
        boolean isLoginIn = request.getURI().getPath().contains("/login/in");
        if (isLoginIn) {
            return chain.filter(exchange);
        }

        //获取token信息

        String token = request.getHeaders().getFirst("token");
        //校验token
        if (StringUtils.isEmpty(token)) {
            //如果token内容为空，则返回
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            //todo 这个setComplete（）怎么解释
            return response.setComplete();
        }

        try {
            //令牌存在的话，就要校验令牌
            Claims claims = AppJwtUtil.getClaimsBody(token);//todo ?payLoadBody信息
            int tokenStatus = AppJwtUtil.verifyToken(claims);//校验token是否过期
            if (tokenStatus == 0 || tokenStatus == -1) {
                //token合法，向header中重新设置userId
                Integer id = (Integer) claims.get("id");
                log.info("find userid:{} from uri:{}", id, request.getURI());//todo 日志输出不会
                //todo 令牌合法，为什么要重新设置令牌中的属性
                //重新设置token到header中
                ServerHttpRequest serverHttpRequest = request.mutate().headers(httpHeaders -> {
                    httpHeaders.add("userId", id + "");
                }).build();
                exchange.mutate().request(serverHttpRequest).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        return chain.filter(exchange);
    }

    /**
     * 设置优先级
     * 数字越小，优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
