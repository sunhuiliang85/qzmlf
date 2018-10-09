package com.uxz.uc.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uxz.common.ResultContent;
import com.uxz.common.ResultEnum;
import com.uxz.uc.user.controller.form.UserRegistForm;
import com.uxz.uc.user.service.IUserService;
import com.uxz.uc.vo.UserVO;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
    @Autowired
	private IUserService userService;
    
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
    @ApiOperation(value = "根据用户id查询用户信息",
            notes = "返回code说明：1,成功;-1,系统错误;-2,参数错误;\n",
            httpMethod = "POST",
            produces = "application/json"
    )
	@RequestMapping("getUserById")
	@ResponseBody
	public ResultContent<UserVO> getUser(String id) {
		UserVO userVO = userService.getUserById(id);
		return ResultContent.resultPassOk(userVO);
		
	}
//	@ResponseBody
//	public UserVO getUser(String id) {
//		UserVO userVO = userService.getUserById(id);
//		return userVO;
//		
//	}
	@PostMapping(value="/register")
	@ResponseBody
	public ResultContent<UserVO> register(@RequestParam UserRegistForm userRegistForm) {
		UserVO userVO = new UserVO();
		userVO.setTel(userRegistForm.getTel());
		userVO.setEncryptedData(userRegistForm.getEncryptedData());
		//生成用户
		getUserService().saveUser(userVO);
		return ResultContent.createResult(ResultEnum.SUCCESS, userVO);
	}
}
