package com.doubleo.tenantcontext.annotation;

import com.doubleo.tenantcontext.config.TenantContextConfiguration;
import java.lang.annotation.*;
import org.springframework.context.annotation.Import;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(TenantContextConfiguration.class)
public @interface EnableTenantContext {}
