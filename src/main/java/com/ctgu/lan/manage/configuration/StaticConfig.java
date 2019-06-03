package com.ctgu.lan.manage.configuration;

import com.ctgu.lan.manage.aop.AdminInterceptor;
import com.ctgu.lan.manage.aop.StaticInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-05-28 16:56
 * @ClassName StaticConfig
 * @Version 1.0.0
 */
@Configuration
public class StaticConfig implements WebMvcConfigurer {
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new StaticInterceptor())
                    .addPathPatterns("/**")
                    .excludePathPatterns("/static/**");
//            super.addInterceptors(registry);
        }
}
