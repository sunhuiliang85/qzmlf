package com.uxz.uc.vo;

import java.io.Serializable;
import java.util.Date;

public class UserVO implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uc_user.userid
     *
     * @mbggenerated
     */
    private String userid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uc_user.username
     *
     * @mbggenerated
     */
    private String username;
    
    /**
     * 密码
     */
    private String password;

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uc_user.usercode
     *
     * @mbggenerated
     */
    private String usercode;
    
    /**
     * 盐值
     */
    private String salt;

    public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uc_user.tel
     *
     * @mbggenerated
     */
    private String tel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uc_user.email
     *
     * @mbggenerated
     */
    private String email;
    
    private String encryptedData;
    
    private String iv;

    public String getIv() {
		return iv;
	}

	public void setIv(String iv) {
		this.iv = iv;
	}

	/**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uc_user.unionid
     *
     * @mbggenerated
     */
    private String unionid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uc_user.openid
     *
     * @mbggenerated
     */
    private String openid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uc_user.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uc_user.ts
     *
     * @mbggenerated
     */
    private Date ts;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uc_user.userid
     *
     * @return the value of uc_user.userid
     *
     * @mbggenerated
     */
    public String getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uc_user.userid
     *
     * @param userid the value for uc_user.userid
     *
     * @mbggenerated
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uc_user.username
     *
     * @return the value of uc_user.username
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uc_user.username
     *
     * @param username the value for uc_user.username
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uc_user.usercode
     *
     * @return the value of uc_user.usercode
     *
     * @mbggenerated
     */
    public String getUsercode() {
        return usercode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uc_user.usercode
     *
     * @param usercode the value for uc_user.usercode
     *
     * @mbggenerated
     */
    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uc_user.tel
     *
     * @return the value of uc_user.tel
     *
     * @mbggenerated
     */
    public String getTel() {
        return tel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uc_user.tel
     *
     * @param tel the value for uc_user.tel
     *
     * @mbggenerated
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uc_user.email
     *
     * @return the value of uc_user.email
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uc_user.email
     *
     * @param email the value for uc_user.email
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uc_user.unionid
     *
     * @return the value of uc_user.unionid
     *
     * @mbggenerated
     */
    public String getUnionid() {
        return unionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uc_user.unionid
     *
     * @param unionid the value for uc_user.unionid
     *
     * @mbggenerated
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uc_user.openid
     *
     * @return the value of uc_user.openid
     *
     * @mbggenerated
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uc_user.openid
     *
     * @param openid the value for uc_user.openid
     *
     * @mbggenerated
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uc_user.create_time
     *
     * @return the value of uc_user.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uc_user.create_time
     *
     * @param createTime the value for uc_user.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uc_user.ts
     *
     * @return the value of uc_user.ts
     *
     * @mbggenerated
     */
    public Date getTs() {
        return ts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uc_user.ts
     *
     * @param ts the value for uc_user.ts
     *
     * @mbggenerated
     */
    public void setTs(Date ts) {
        this.ts = ts;
    }
    
	public String getEncryptedData() {
		return encryptedData;
	}
	public void setEncryptedData(String encryptedData) {
		this.encryptedData = encryptedData;
	}
}