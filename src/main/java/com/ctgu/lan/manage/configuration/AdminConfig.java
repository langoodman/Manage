package com.ctgu.lan.manage.configuration;

import com.ctgu.lan.manage.aop.AdminInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-05-29 17:23
 * @ClassName AdminConfig
 * @Version 1.0.0
 */
@Configuration
public class AdminConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/findPassword","/","/admin/loginInfo",
                        "/admin/logout","/admin/getVerify","/static/**");
//            super.addInterceptors(registry);
    }
}
