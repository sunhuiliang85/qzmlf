package com.uxz.uc.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.uxz.uc.user.domain.User;
import com.uxz.uc.user.domain.UserExample;
@Mapper
public interface UserMapper {
	
	@Select("select * from uc_user u where u.userid = #{id}")
	User getUserById(String id);
	
	@Select("select * from uc_user u where u.openid = #{openid}")
	User getUserByOpenId(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table uc_user
	 *
	 * @mbggenerated
	 */
	int countByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table uc_user
	 *
	 * @mbggenerated
	 */
	int deleteByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table uc_user
	 *
	 * @mbggenerated
	 */
	int insert(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table uc_user
	 *
	 * @mbggenerated
	 */
	int insertSelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table uc_user
	 *
	 * @mbggenerated
	 */
	List<User> selectByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table uc_user
	 *
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table uc_user
	 *
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}