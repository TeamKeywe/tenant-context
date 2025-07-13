package com.doubleo.tenantcontext.context;

import com.doubleo.tenantcontext.TenantContextHolder;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class TenantContextWebFilter implements WebFilter {

    private static final String TENANT_HEADER = "X-Tenant-Id";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String tenantId = request.getHeaders().getFirst(TENANT_HEADER);

        if (tenantId != null) {
            TenantContextHolder.setTenantId(tenantId);
        }

        return chain.filter(exchange).doFinally(signalType -> TenantContextHolder.clear());
    }
}
