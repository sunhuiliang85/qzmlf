/**
 * 
 */
package com.uxz.login.controller.form;

/**
 * 微信登录参数表单
 * @author shl
 *
 */
public class WxLoginForm {
    private String code;
    private String encryptedData;
    private String iv;
    private String rawdata;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEncryptedData() {
		return encryptedData;
	}
	public void setEncryptedData(String encryptedData) {
		this.encryptedData = encryptedData;
	}
	public String getIv() {
		return iv;
	}
	public void setIv(String iv) {
		this.iv = iv;
	}
	public String getRawdata() {
		return rawdata;
	}
	public void setRawdata(String rawdata) {
		this.rawdata = rawdata;
	}
}
