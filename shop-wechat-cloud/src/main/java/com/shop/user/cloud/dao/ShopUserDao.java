package com.shop.user.cloud.dao;


import org.apache.ibatis.annotations.Param;

import com.shop.user.cloud.entity.ShopUser;


/**
 * 
 * 用户
 * @author Yuan Wei
 * @email ywdeveloper@aliyun.com
 * @date 2018-06-14 16:05:53
 */
public interface ShopUserDao extends BaseDao<ShopUser> {
	
	/**
	 * 根据opneid查询用户
	 * @param openId
	 * @return
	 */
	ShopUser queryByOpenId(@Param("openId") String openId);
	
	/**
	 * 根据手机号查询用户
	 * @param mobile
	 * @return
	 */
	ShopUser queryByMobile(@Param("mobile") String mobile);
}
