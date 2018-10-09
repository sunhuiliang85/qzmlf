/**
 * 
 */
package com.uxz.cu.questioncard.service;

import java.util.List;

import com.uxz.cu.questioncard.vo.QuestioncardVO;

/**
 * 答题卡服务接口
 * @author shl
 *
 */
public interface IQuestioncardService {
	
	/**
	 * 询课程下的答题卡列表
	 * @param course_id
	 * @return
	 */
	List<QuestioncardVO> queryQuestioncardList(String course_id);
}
