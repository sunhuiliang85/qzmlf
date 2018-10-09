/**
 * 
 */
package com.uxz.uc.user.service.impl;

import java.security.MessageDigest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uxz.uc.user.dao.UserMapper;
import com.uxz.uc.user.domain.User;
import com.uxz.uc.user.service.IUserService;
import com.uxz.uc.vo.UserVO;

/**
 * @author shl
 *
 */
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	@Override
	public UserVO getUserById(String id) {
	    User user = userMapper.getUserById(id);
	    UserVO userVO = new UserVO();
	    BeanUtils.copyProperties(user, userVO);
		return userVO;
	}
	
	@Override
	public UserVO getUserByOpenId(String openid) {
	    User user = userMapper.getUserByOpenId(openid);
	    if (user != null) {
	    	UserVO userVO = new UserVO();
	 	    BeanUtils.copyProperties(user, userVO);
	 	    return userVO;
	    }
		return null;
		
	}
	
	//@Overriide
	public void saveUser(UserVO userVO) {
		User user = new User();
		//将md5加密后的密码,重新塞入密码字段
		userVO.setPassword(Get_MD5(userVO.getEncryptedData() + getSalt(6)));
		BeanUtils.copyProperties(userVO, user);
		userMapper.insert(user);
	}

	/**
	 * 随机获取盐值
	 * @param len
	 * @return
	 */
	private static String getSalt(int len) {
	    String salt = "";
	    for (int i=0;i<len;i++){
	           char c='a';
	           c=(char)(c+(int)(Math.random()*26));
	           salt +=c;
	    }
	    return salt;
	}
	private String Get_MD5(String str){
        String word=null;
        try {
            MessageDigest md5=MessageDigest.getInstance("MD5");
            md5.update(str.getBytes());
            byte[] data=md5.digest();
            StringBuffer sb=new StringBuffer(data.length*2);
            for(byte b:data){
                if ((b & 0xFF) < 0x10) sb.append("0");
                sb.append(Integer.toHexString(b & 0xFF));
            }
            word=sb.toString();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            word=null;
        }
        return word;
    }
}
