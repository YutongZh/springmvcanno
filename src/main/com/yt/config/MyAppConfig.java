package com.yt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

//对controller层进行bean注入 他是一个单独的容器
@ComponentScan(value = "com.yt", includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = {Controller.class}),useDefaultFilters = false)
@EnableWebMvc
public class MyAppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // 想用jsp解析器，指定路径访问
        registry.jsp("/WEB-INF/pages/", ".jsp");
    }

    //静态资源的访问  定制的话 如果访问必须able 否则访问不了
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }
}
