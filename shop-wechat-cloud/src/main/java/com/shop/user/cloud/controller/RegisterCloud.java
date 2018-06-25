//package com.shop.user.cloud.controller;
//
//import java.util.Date;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.commons.codec.digest.DigestUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.shop.common.annotation.IgnoreAuth;
//import com.shop.common.result.Result;
//import com.shop.common.result.ResultCode;
//import com.shop.common.result.ResultGenerator;
//import com.shop.common.utils.CommonUtil;
//import com.shop.wechat.api.RegisterApi;
//import com.shop.user.cloud.config.WeChatConfig;
//import com.shop.user.cloud.cons.SmsConstant;
//import com.shop.user.cloud.cons.UserConstant;
//import com.shop.user.cloud.entity.ShopUser;
//import com.shop.user.cloud.pojo.UserInfoResponse;
//import com.shop.user.cloud.pojo.UserResponse;
//import com.shop.user.cloud.service.UserService;
//import com.shop.user.cloud.utils.EmojiUtil;
//import com.shop.user.cloud.utils.RedisUtil;
//import com.shop.user.cloud.utils.UserInfoUtil;
//
//@RestController
//public class RegisterCloud implements RegisterApi{
//	@Autowired
//	private WeChatConfig weChatConfig;
//    @Autowired
//    private UserService userService;
//
//    @IgnoreAuth
//    @Override
//    public Result register(String mobile, String password, HttpServletRequest request) {
//    	
//    	if (StringUtils.isNotBlank(mobile) && StringUtils.isNotBlank(password)) {
//    		
//    		//获取IP
//    		String addressIP = CommonUtil.getIpAddress(request);
//    		
//    		ShopUser user = new ShopUser();
//        	user.setId(CommonUtil.genUUID());
//            user.setMobile(mobile);
//            user.setUsername(mobile);
//            user.setPassword(DigestUtils.md5Hex(password));
//            user.setRegisterIp(addressIP);
//            user.setRegisterTime(new Date());
//            
//			// 用户账号密码注册
//    		userService.save(user);
//    		
//    		//获取用户
//    		UserResponse response = UserResponse.fromBean(user);
//			return ResultGenerator.genSuccessResult("密码注册成功", response);
//		}
//    	return ResultGenerator.genFailResult(ResultCode.MOBILE_OR_PSD_IS_NULL.code, "手机或密码为空!");
//    }
//
//    @Override
//	public Result validateSMSCode(String mobile, String code) {
//		boolean result = RedisUtil.hasKey(SmsConstant.VALIDATE_SMS_PREFIX + mobile);
//		if (result) {
//			//获取缓存中的验证码
//			String redisCode = RedisUtil.get(SmsConstant.VALIDATE_SMS_PREFIX + mobile);
//			//判断输入的code是否正确
//			if (redisCode.equals(DigestUtils.md5Hex(mobile + code))) {
//				ShopUser user = userService.queryByMobile(mobile);
//				if (user != null) {
//					//获取用户
//		    		UserResponse response = UserResponse.fromBean(user);
//					return ResultGenerator.genSuccessResult("短信登入成功", response);
//				}
//				return ResultGenerator.genSuccessResult("短信验证成功");
//			}
//			return ResultGenerator.genFailResult(ResultCode.KAPTCHA_ERROR.code, "验证码错误!");
//		}
//		return ResultGenerator.genFailResult(ResultCode.KAPTCHA_INVALID.code, "验证码已失效!");
//	}
//    
//	@Override
//	public Result registerByWeChat(String encryptedData, String code, String iv, HttpServletRequest request) {
//		
//		if (StringUtils.isEmpty(encryptedData) || StringUtils.isEmpty(code) || StringUtils.isEmpty(iv)) {
//			return ResultGenerator.genFailResult(ResultCode.PARAM_IS_NULL.code, "参数不全或参数为空");
//		}
//		//获取用户IP
//		String ipAddress = CommonUtil.getIpAddress(request);
//		UserInfoResponse response = UserInfoUtil.getUserInfo(encryptedData, code, iv, weChatConfig.getAppid(), weChatConfig.getSercet());
//		if (response != null) {
//			//查看是否拥有
//			ShopUser shopUser = userService.queryByOpenId(response.getOpenId());
//			if (shopUser != null) {
//				
//				shopUser.setLastLoginIp(ipAddress);
//				shopUser.setLastLoginTime(new Date());
//				userService.update(shopUser);
//				
//				UserResponse userResponse = UserResponse.fromBean(shopUser);
//				return ResultGenerator.genSuccessResult("返回用户信息成功", userResponse);
//			}else {
//				//微信授权注册
//				shopUser = new ShopUser();
//				shopUser = copyFromUserInfo(response, ipAddress);
//				shopUser.setUserType(UserConstant.TYPE_WX);
//				userService.save(shopUser);
//				
//				UserResponse userResponse = UserResponse.fromBean(shopUser);
//				return ResultGenerator.genSuccessResult("用户授权成功,返回用户信息成功", userResponse);
//			}
//			
//		}else {
//			return ResultGenerator.genFailResult(ResultCode.GETUSERINFO_FAIL.code, "解密获取用户信息失败");
//		}
//	}
//	
//	
//	private static ShopUser copyFromUserInfo(UserInfoResponse response, String addressIp) {
//		ShopUser shopUser = new ShopUser();
//		shopUser.setId(CommonUtil.genUUID());
//		shopUser.setOpenid(response.getOpenId());
//		shopUser.setNickname(EmojiUtil.emojiConvert(response.getNickName()));
//		shopUser.setGender(response.getGender());
//		shopUser.setProvince(response.getProvince());
//		shopUser.setCity(response.getCity());
//		shopUser.setCountry(response.getCountry());
//		shopUser.setAvatarurl(response.getAvatarUrl());
//		shopUser.setRegisterIp(addressIp);
//		shopUser.setRegisterTime(new Date());
//		return shopUser;
//	}
//
//}
