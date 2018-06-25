package com.shop.user.cloud.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.shop.common.annotation.LoginUser;
import com.shop.user.cloud.entity.ShopUser;
import com.shop.user.cloud.interceptor.AuthorizationInterceptor;
import com.shop.user.cloud.pojo.UserRequest;
import com.shop.user.cloud.service.UserService;


/**
 * 有@LoginUser注解的方法参数，注入当前登录用户
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-03-23 22:02
 */
@Component
public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
	@Autowired
	private UserService userService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(UserRequest.class) && parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
                                  NativeWebRequest request, WebDataBinderFactory factory) throws Exception {
        //获取用户ID
        Object object = request.getAttribute(AuthorizationInterceptor.LOGIN_USER_KEY, RequestAttributes.SCOPE_REQUEST);
        if (object == null) {
            return null;
        }

        //获取用户信息
        ShopUser shopUser = userService.queryObject((String)object);

        return shopUser;
    }
}
