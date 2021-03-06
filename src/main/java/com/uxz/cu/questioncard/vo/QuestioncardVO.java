package com.uxz.cu.questioncard.vo;

import java.util.Date;

public class QuestioncardVO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cu_questioncard.qcard_id
     *
     * @mbggenerated
     */
    private String qcardId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cu_questioncard.qcard_name
     *
     * @mbggenerated
     */
    private String qcardName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cu_questioncard.difficult_level
     *
     * @mbggenerated
     */
    private Integer difficultLevel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cu_questioncard.memo
     *
     * @mbggenerated
     */
    private String memo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cu_questioncard.course_id
     *
     * @mbggenerated
     */
    private String courseId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cu_questioncard.creationtime
     *
     * @mbggenerated
     */
    private Date creationtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cu_questioncard.ts
     *
     * @mbggenerated
     */
    private Date ts;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cu_questioncard.qcard_id
     *
     * @return the value of cu_questioncard.qcard_id
     *
     * @mbggenerated
     */
    public String getQcardId() {
        return qcardId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cu_questioncard.qcard_id
     *
     * @param qcardId the value for cu_questioncard.qcard_id
     *
     * @mbggenerated
     */
    public void setQcardId(String qcardId) {
        this.qcardId = qcardId == null ? null : qcardId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cu_questioncard.qcard_name
     *
     * @return the value of cu_questioncard.qcard_name
     *
     * @mbggenerated
     */
    public String getQcardName() {
        return qcardName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cu_questioncard.qcard_name
     *
     * @param qcardName the value for cu_questioncard.qcard_name
     *
     * @mbggenerated
     */
    public void setQcardName(String qcardName) {
        this.qcardName = qcardName == null ? null : qcardName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cu_questioncard.difficult_level
     *
     * @return the value of cu_questioncard.difficult_level
     *
     * @mbggenerated
     */
    public Integer getDifficultLevel() {
        return difficultLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cu_questioncard.difficult_level
     *
     * @param difficultLevel the value for cu_questioncard.difficult_level
     *
     * @mbggenerated
     */
    public void setDifficultLevel(Integer difficultLevel) {
        this.difficultLevel = difficultLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cu_questioncard.memo
     *
     * @return the value of cu_questioncard.memo
     *
     * @mbggenerated
     */
    public String getMemo() {
        return memo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cu_questioncard.memo
     *
     * @param memo the value for cu_questioncard.memo
     *
     * @mbggenerated
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cu_questioncard.course_id
     *
     * @return the value of cu_questioncard.course_id
     *
     * @mbggenerated
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cu_questioncard.course_id
     *
     * @param courseId the value for cu_questioncard.course_id
     *
     * @mbggenerated
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cu_questioncard.creationtime
     *
     * @return the value of cu_questioncard.creationtime
     *
     * @mbggenerated
     */
    public Date getCreationtime() {
        return creationtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cu_questioncard.creationtime
     *
     * @param creationtime the value for cu_questioncard.creationtime
     *
     * @mbggenerated
     */
    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cu_questioncard.ts
     *
     * @return the value of cu_questioncard.ts
     *
     * @mbggenerated
     */
    public Date getTs() {
        return ts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cu_questioncard.ts
     *
     * @param ts the value for cu_questioncard.ts
     *
     * @mbggenerated
     */
    public void setTs(Date ts) {
        this.ts = ts;
    }
}