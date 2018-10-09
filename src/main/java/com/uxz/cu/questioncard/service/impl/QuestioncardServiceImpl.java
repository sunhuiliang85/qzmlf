/**
 * 
 */
package com.uxz.cu.questioncard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uxz.cu.questioncard.dao.QuestioncardMapper;
import com.uxz.cu.questioncard.domain.Questioncard;
import com.uxz.cu.questioncard.service.IQuestioncardService;
import com.uxz.cu.questioncard.vo.QuestioncardVO;

/**
 * 答题卡服务实现类
 * @author shl
 *
 */
@Service
public class QuestioncardServiceImpl implements IQuestioncardService {
	@Autowired
    private QuestioncardMapper questioncardWrapper;

	public QuestioncardMapper getQuestioncardWrapper() {
		return questioncardWrapper;
	}

	public void setQuestioncardWrapper(QuestioncardMapper questioncardWrapper) {
		this.questioncardWrapper = questioncardWrapper;
	}
	/**
	 * 询课程下的答题卡列表
	 * @param course_id
	 * @return
	 */
	public List<QuestioncardVO> queryQuestioncardList(String course_id) {
		List<Questioncard> questioncardlist = getQuestioncardWrapper().queryQuestioncardList(course_id);
		List<QuestioncardVO> questioncardVOlist = new ArrayList<QuestioncardVO>();
		BeanUtils.copyProperties(questioncardlist, questioncardVOlist);
		for (Questioncard questioncard: questioncardlist) {
			QuestioncardVO questioncardVO = new QuestioncardVO();
			BeanUtils.copyProperties(questioncard, questioncardVO);
			questioncardVOlist.add(questioncardVO);
		}		
		return questioncardVOlist;
	}
}
