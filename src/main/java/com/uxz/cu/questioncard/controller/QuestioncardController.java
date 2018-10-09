/**
 * 
 */
package com.uxz.cu.questioncard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uxz.common.APIConst;
import com.uxz.common.ResultContent;
import com.uxz.cu.questioncard.service.IQuestioncardService;
import com.uxz.cu.questioncard.vo.QuestioncardVO;

/**
 * 答题卡Controller
 * @author shl
 *
 */
@RestController
@RequestMapping(APIConst.RESTAPI_V1 + "/questioncard")
public class QuestioncardController {
	/**
	 * 答题卡查询服务
	 */
	@Autowired
	private IQuestioncardService questioncardService;
	
	/**
	 * 询课程下的答题卡列表
	 * @return
	 */
	@RequestMapping("/queryQuestioncards")
	@ResponseBody
	public ResultContent<List<QuestioncardVO>>  queryQuestioncards(String courseid) {
		List<QuestioncardVO> questionlist = getQuestioncardService().queryQuestioncardList(courseid);
		return ResultContent.resultPassOk(questionlist);
	}

	public IQuestioncardService getQuestioncardService() {
		return questioncardService;
	}

	public void setQuestioncardService(IQuestioncardService questioncardService) {
		this.questioncardService = questioncardService;
	}
	
}
