package com.shop.common.result;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
	//http响应code
    SUCCESS(200),//成功
    FAIL(400),//失败
    
    NOT_FOUND(404),//接口不存在
    
    //自定义响应code
    MOBILE_OR_PSD_IS_NULL(50001),
    PASSWORD_IS_ERROR(50002),//密码错误
    PARAM_IS_NULL(50003),
    GETUSERINFO_FAIL(50004), //解密获取用户信息失败
    
    KAPTCHA_INVALID(50010),//验证码失效
    KAPTCHA_ERROR(500);//验证错误
    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}
