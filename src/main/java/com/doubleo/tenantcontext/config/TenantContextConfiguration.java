package com.doubleo.tenantcontext.config;

import com.doubleo.tenantcontext.context.TenantContextFilter;
import com.doubleo.tenantcontext.context.TenantContextWebFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TenantContextConfiguration {

    @Bean
    @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
    public TenantContextFilter tenantContextFilter() {
        return new TenantContextFilter();
    }

    @Bean
    @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)
    public TenantContextWebFilter tenantContextWebFilter() {
        return new TenantContextWebFilter();
    }
}
