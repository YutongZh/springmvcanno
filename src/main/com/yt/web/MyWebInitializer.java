package com.yt.web;

import com.yt.config.MyAppConfig;
import com.yt.config.MyRootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//web容器启动的时候创建的对象：调用方法来初始化容器以前的一个控制器
public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //根容器
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{MyRootConfig.class};
    }

    //子容器
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{MyAppConfig.class};
    }

    //获取dispatcherServlet的映射信息
    //拦截所有请求（静态资源，js,css,png） 但是不包括*.jsp(jsp 的解析是tomcat的jsp引擎解析)
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
