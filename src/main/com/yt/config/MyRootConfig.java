package com.yt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

//对非controller层进行bean注入
@ComponentScan(value = "com.yt", excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = {Controller.class}),useDefaultFilters = false)
public class MyRootConfig {
}
