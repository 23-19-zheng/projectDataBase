package edu.xaufe.springcloud.filter;

import cn.hutool.http.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zc
 * @Date: 2021/05/16/14:52
 * @Description:
 */
@Component
@Slf4j
public class MyLogGetWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("********进入到全局过滤*********");
        String uname = exchange.getRequest().getQueryParams().getFirst("username");
        if(uname == null) {
            log.info("用户名为null，暂不支持进入");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);//设置状态码，不接受
            return exchange.getResponse().setComplete();//返回
        }
        return chain.filter(exchange);//传递下去，继续过滤
    }

    @Override
    public int getOrder() {//执行过滤链，过滤方法的顺序
        return 0;
    }
}
