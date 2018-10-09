/**
 * 
 */
package com.uxz.uc.user.service;

import com.uxz.uc.vo.UserVO;

/**
 * @author shl
 *
 */
public interface IUserService {
	
	/**
	 * 根据id获取用户信息。
	 */
	public UserVO getUserById(String id);
	
	/**
	 * 根据openid获取用户信息。
	 */
	public UserVO getUserByOpenId(String openid);
	
	/**
	 * 保存用户信息
	 * @param userVO
	 */
	public void saveUser(UserVO userVO);
}
