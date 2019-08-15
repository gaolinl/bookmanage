package com.example.demo.config;/**
 * Created by gaolin on 2019/7/28.
 */

import com.example.demo.filter.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author gaolin
 * @create 2019-07-28 11:21
 **/
@Configuration
public class FilterConfig  implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Filter()).addPathPatterns("/book/**")
                .excludePathPatterns("/book/user/login","/book/user/add","/book/user/getCode","/book/user/reOut");
    }
}
