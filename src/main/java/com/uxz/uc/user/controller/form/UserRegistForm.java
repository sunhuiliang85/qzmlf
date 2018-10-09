package com.uxz.uc.user.controller.form;

public class UserRegistForm {
    private String tel;
    private String EncryptedData;
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEncryptedData() {
		return EncryptedData;
	}
	public void setEncryptedData(String encryptedData) {
		EncryptedData = encryptedData;
	}
}
