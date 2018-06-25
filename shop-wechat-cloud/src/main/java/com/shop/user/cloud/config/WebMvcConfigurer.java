package com.shop.user.cloud.config;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.shop.user.cloud.interceptor.AuthorizationInterceptor;
import com.shop.user.cloud.resolver.LoginUserHandlerMethodArgumentResolver;



/**
 * Spring MVC 配置
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

	@Autowired
    private LoginUserHandlerMethodArgumentResolver loginUserHandlerMethodArgumentResolver;
	 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/.well-known/pki-validation/**")
                .addResourceLocations("classpath:/.well-known/pki-validation/");
    }
    
    //解决跨域问题
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //registry.addMapping("/**");
    }

    @Override
	public void addInterceptors(InterceptorRegistry registry) {
		// //拦截规则：除了授权，其他都拦截判断
    	InterceptorRegistration in = registry.addInterceptor(authenticationInterceptor());
		in.addPathPatterns("/**");
//		in.excludePathPatterns("/getUserInfo");
		super.addInterceptors(registry);
	}
    
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(loginUserHandlerMethodArgumentResolver);
    }
    
    @Bean
    public AuthorizationInterceptor authenticationInterceptor() {
        return new AuthorizationInterceptor();
    }
}
