package com.shop.user.cloud.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.shop.common.utils.Base64;
import com.shop.common.utils.HttpClient;
import com.shop.user.cloud.cons.WeChatConstant;
import com.shop.user.cloud.pojo.UserInfoResponse;
import com.shop.user.cloud.pojo.Watermark;


public class UserInfoUtil {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(UserInfoUtil.class);
    /**
     * 获取微信小程序 session_key 和 openid
     * @param code
     * @return
     */
    public static String getSessionKey(String code, String appId, String secret){
    	
    	String url = String.format(WeChatConstant.AUTH, appId, secret, code);
    	HttpClient client;
		try {
			client = new HttpClient(url);
			String retStr = client.get();
			
			JSONObject jsonObject = JSONObject.parseObject(retStr);
            return jsonObject.getString("session_key");
		} catch (IOException e) {
			e.printStackTrace();
		}
        return null;
    }
    
    /**
     * 解密用户敏感数据获取用户信息
     * @param sessionKey 数据进行加密签名的密钥
     * @param encryptedData 包括敏感数据在内的完整用户信息的加密数据
     * @param iv 加密算法的初始向量
     * @return
     */
    public static UserInfoResponse getUserInfo(String encryptedData,String code,String iv, String appid, String secret){
    	
    	String sessionKey = getSessionKey(code, appid, secret);
        // 被加密的数据
        byte[] dataByte = Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decode(sessionKey);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);

        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                JSONObject json = JSONObject.parseObject(result);
                return returnResponse(json);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidParameterSpecException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
    
    private static UserInfoResponse returnResponse(JSONObject jObject) {
    	UserInfoResponse response = new UserInfoResponse();
    	response.setOpenId(jObject.getString("openId"));
    	response.setAvatarUrl(jObject.getString("avatarUrl"));
    	response.setCity(jObject.getString("city"));
    	response.setProvince(jObject.getString("province"));
    	response.setCountry(jObject.getString("country"));
    	response.setNickName(jObject.getString("nickName"));
    	response.setGender(jObject.getInteger("gender"));
    	response.setUnionId(jObject.getString("unionId"));
    	Watermark mark = new Watermark();
    	JSONObject json = jObject.getJSONObject("watermark");
    	mark.setAppid(json.getString("appid"));
    	mark.setTimestamp(json.getLongValue("timestamp"));
    	response.setWatermark(mark);
    	return response;
    }
    
}
