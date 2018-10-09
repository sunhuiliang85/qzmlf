/**
 * 
 */
package com.uxz.login.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.spec.InvalidParameterSpecException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.StringUtils;
import com.uxz.common.HttpUtils;
import com.uxz.common.ResultContent;
import com.uxz.login.controller.form.WxLoginForm;
import com.uxz.uc.user.service.IUserService;
import com.uxz.uc.vo.UserVO;

/**
 * 登录
 * 
 * @author shl
 *
 */
@RestController
@RequestMapping("/api/v1/login")
public class LoginContrlloer {
	@Autowired
	private RedisTemplate redisTemplate;
	
	public RedisTemplate getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Autowired
	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}
    
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@PostMapping(value="/wxlogin")
	@ResponseBody
    public ResultContent  wxlogin(@RequestBody WxLoginForm wxLoginForm) {
		
    	JSONObject sessionKeyOpenid = getSessionKeyOrOpenId(wxLoginForm.getCode());
    	String openid = sessionKeyOpenid.getString("openid");
    	String sesssion_key = sessionKeyOpenid.getString("session_key");
        UserVO userVO = getUserService().getUserByOpenId(openid);  	
        //如果当前用户不存在，创建用户.
        if (userVO == null) {
        	JSONObject userjson = JSONObject.parseObject(wxLoginForm.getRawdata());
        	UserVO newUser = new UserVO();
        	newUser.setUserid(UUID.randomUUID().toString());
        	newUser.setUsername(userjson.getString("nickName"));
        	newUser.setEmail(userjson.getString("email"));
        	newUser.setOpenid(openid);
        	newUser.setTel(userjson.getString("tel"));
        	newUser.setUsercode(userjson.getString("usercode"));
        	newUser.setCreateTime(new Date());
        	newUser.setTs(new Date());
            getUserService().saveUser(newUser);
        } else {
        	
        }
        String skey = (String)getRedisTemplate().opsForValue().get(openid);
        if (!StringUtils.isNullOrEmpty(skey)) {
        	getRedisTemplate().delete(skey);
        }
        JSONObject seesionObj = new JSONObject();
        seesionObj.put("openid", openid);
        seesionObj.put("sessionkey", sesssion_key);
        getRedisTemplate().opsForValue().set(sesssion_key, seesionObj.toJSONString());
        getRedisTemplate().opsForValue().set(openid, skey);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("skey", sesssion_key);
        JSONObject userInfo = getUserInfo( wxLoginForm.getEncryptedData()
        		, sesssion_key, wxLoginForm.getIv() );
        System.out.println("根据解密算法获取的userInfo="+userInfo);
        //userInfo.put( "balance",user.getUbalance() );
        resultMap.put( "userInfo",userInfo );

        return ResultContent.resultPassOk(resultMap);
        
    }

	private JSONObject getSessionKeyOrOpenId(String code) {
		String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
		Map<String, String> requestUrlParam = new HashMap<String, String>();
		requestUrlParam.put("appid", "wxaa69e10b94cb1a68");// 小程序appId
		requestUrlParam.put("secret", "415c928443298e105946a530c05cc9b7");
		requestUrlParam.put("js_code", code);// 小程序端返回的code
		requestUrlParam.put("grant_type", "authorization_code");// 默认参数
		try {
			JSONObject jsonObject = JSON.parseObject(HttpUtils.sendPost(requestUrl, requestUrlParam));
			return jsonObject;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
//	 public static JSONObject getUserInfo(String sessionId, String enCreypetUserInfo, String iv){
//	        System.out.println(sessionId+"-----"+enCreypetUserInfo+"---"+iv);
//
//	        //解密
//	        //根据sessionid可以获取到之前存储的openid和session_key
////	        if(!"123".equals(sessionId)){
////	            return null;
////	        }
////	        String sessionkey = "+eUbUbjtv1iGsos1fAIahA==";
////	        String stoageOpenid = "o65UP0YxnhcwJE79SHjkaTP1IKY4";
//	        Base64 base64 = new Base64();
//	        String userInfo = null;
//	        try {
//
//	            userInfo = new String(AES.decrypt(base64.decode(enCreypetUserInfo),base64.decode(sessionId) , base64.decode(iv) ),"UTF-8");
//	        }  catch (UnsupportedEncodingException e) {
//	            e.printStackTrace();
//	        }
//	        if(null==userInfo){
//	            return null;
//	        }
//	       // Map<String,String> map = JacksonUtil.JsonToMap(userInfo);
//	        return JSON.parseObject(userInfo);
////	        JsonDto jsonDto = new JsonDto();
////	        jsonDto.setData(map);
////	        return jsonDto;
//	    }
	public static JSONObject getUserInfo(String encryptedData,String sessionKey,String iv){
	    // 被加密的数据
	    byte[] dataByte = Base64.decodeBase64(encryptedData);
	    // 加密秘钥
	    byte[] keyByte = Base64.decodeBase64(sessionKey);
	    // 偏移量
	    byte[] ivByte = Base64.decodeBase64(iv);
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
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
	        //Cipher cipher = Cipher.getInstance("AES/ECB/ZeroBytePadding"); 
	        SecretKeySpec spec = new SecretKeySpec(getRawKey(keyByte), "AES");
	        AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
	        parameters.init(new IvParameterSpec(ivByte));
        	System.out.println("Key Length: " + spec.getEncoded().length);
        	System.out.println("Key Algorithm: "+ spec.getAlgorithm());
        	System.out.println("Key Format: "+ spec.getFormat());
	        cipher.init( Cipher.DECRYPT_MODE, spec, parameters);// 初始化
	        byte[] resultByte = cipher.doFinal(dataByte);
	        if (null != resultByte && resultByte.length > 0) {
	            String result = new String(resultByte, "UTF-8");
	            return JSON.parseObject(result);
	        }
	    } catch (NoSuchAlgorithmException e) {
	    	   System.out.println("a");
		       e.printStackTrace();
	    } catch (NoSuchPaddingException e) {
//	        log.error(e.getMessage(), e);
	    } catch (InvalidParameterSpecException e) {
//	        log.error(e.getMessage(), e);
	    } catch (IllegalBlockSizeException e) {
//	        log.error(e.getMessage(), e);
	    } catch (BadPaddingException e) {
	       System.out.println("a");
	       e.printStackTrace();
	    } catch (UnsupportedEncodingException e) {
	    	 System.out.println("b");
		       e.printStackTrace();
	    } catch (InvalidKeyException e) {
	    	 System.out.println("c");
		       e.printStackTrace();
	    } catch (InvalidAlgorithmParameterException e) {
	    	 System.out.println("d");
		       e.printStackTrace();
	    } catch (Exception e) {
	    	System.out.println("e");
			e.printStackTrace();
		}
//	    } catch (NoSuchProviderException e) {
////	        log.error(e.getMessage(), e);
//	    }
	    return null;
	}
//	private static byte[] getRawKey(byte[] seed) throws Exception { 
//		KeyGenerator kgen = KeyGenerator.getInstance("AES"); 
//		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", new CryptoProvider());
//		sr.setSeed(seed); 
//		kgen.init(128, sr); // 192 and 256 bits may not be available 
//		SecretKey skey = kgen.generateKey(); 
//		byte[] raw = skey.getEncoded(); 
//		return raw; 
//		}
	private static byte[] getRawKey(byte[] keyBytes) throws Exception { 
		// 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
		  int base = 16;
		  if (keyBytes.length % base != 0) {
		   int groups = keyBytes.length / base + (keyBytes.length % base != 0 ? 1 : 0);
		   byte[] temp = new byte[groups * base];
		   Arrays.fill(temp, (byte) 0);
		   System.arraycopy(keyBytes, 0, temp, 0, keyBytes.length);
		   keyBytes = temp;
		  }
		return keyBytes; 
	}	
	static final class CryptoProvider extends Provider {
        /**
         * Creates a Provider and puts parameters
         */
        public CryptoProvider() {
            super("Crypto", 1.0, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
            put("SecureRandom.SHA1PRNG",
                    "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
            put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
        }
    }


}
