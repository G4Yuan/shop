package com.shop.user.cloud.service;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.user.cloud.dao.ShopUserDao;
import com.shop.user.cloud.entity.ShopUser;
import com.shop.user.cloud.pojo.UserResponse;

import java.util.List;
import java.util.Map;


@Service
public class UserService {
    @Autowired
    private ShopUserDao userDao;
//    @Autowired
//    private ApiUserLevelMapper userLevelDao;

    public ShopUser queryObject(String userId) {
        return userDao.queryObject(userId);
    }

    public ShopUser queryByOpenId(String openId) {
        return userDao.queryByOpenId(openId);
    }

    public List<ShopUser> queryList(Map<String, Object> map) {
        return userDao.queryList(map);
    }

    public int queryTotal(Map<String, Object> map) {
        return userDao.queryTotal(map);
    }

    public void save(ShopUser user) {
        userDao.save(user);
    }

    public void update(ShopUser user) {
        userDao.update(user);
    }

    public void delete(String userId) {
        userDao.delete(userId);
    }

    public void deleteBatch(String[] userIds) {
        userDao.deleteBatch(userIds);
    }

    public ShopUser queryByMobile(String mobile) {
        return userDao.queryByMobile(mobile);
    }

    public UserResponse login(String mobile, String password) {
        ShopUser user = queryByMobile(mobile);

        //密码错误
        if (!user.getPassword().equals(DigestUtils.md5Hex(password))) {
            return null;
        }else {
        	UserResponse response = UserResponse.fromBean(user);
        	return response;
		}

    }
//
//    public SmsLogVo querySmsCodeByUserId(Long user_id) {
//        return userDao.querySmsCodeByUserId(user_id);
//    }
//
//
//    public int saveSmsCodeLog(SmsLogVo smsLogVo) {
//        return userDao.saveSmsCodeLog(smsLogVo);
//    }
//
//    public String getUserLevel(UserVo loginUser) {
//        String result = "普通用户";
//        UserLevelVo userLevelVo = userLevelDao.queryObject(loginUser.getUser_level_id());
//        if (null != userLevelVo) {
//            result = userLevelVo.getName();
//        }
//        return result;
//    }
}
