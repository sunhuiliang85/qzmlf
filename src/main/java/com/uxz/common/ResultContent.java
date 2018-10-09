package com.uxz.common;

import java.io.Serializable;

import lombok.Data;

/**
 * Result
 *
 * @author chuan.ma
 * @since 2018/1/24
 */
@Data
public class ResultContent<T> implements Serializable {

    private static long serialVersionUID = 5519805087926115419L;

    /**
     * 处理状态代码。状态码参见后面的详细定义
     */
    private int code;

    public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
     * 状态码对应的描述信息，当处理失败时客户端显示给用户
     */
    private String message;

    /**
     * 返回结果
     */
    private T data;

    public ResultContent(ResultEnum param) {
    }

    private ResultContent(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private ResultContent(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResultContent<T> resultPassOk() {
        return createResult(ResultEnum.SUCCESS);
    }

    public static <T> ResultContent<T> resultPassOk(T data) {
        ResultEnum resultEnum = ResultEnum.SUCCESS;
        return (ResultContent<T>) new ResultContent(resultEnum.getCode(), resultEnum.getMessage(), data);
    }

    public static <T> ResultContent<T> resultPassError() {
        return createResult(ResultEnum.ERROR);
    }

    public static <T> ResultContent<T> resultError(String msg) {
        return new ResultContent(ResultEnum.ERROR.getCode(), msg);
    }

    public static <T> ResultContent<T> resultParamError() {
        return createResult(ResultEnum.PARAM_ERROR);
    }

    public static <T> ResultContent<T> resultParamError(String msg) {
        return new ResultContent(ResultEnum.PARAM_ERROR.getCode(), msg);
    }

    public static <T> ResultContent<T> createResult(ResultEnum resultEnum) {
        return (ResultContent<T>) new ResultContent(resultEnum.getCode(), resultEnum.getMessage());
    }

    public static <T> ResultContent<T> createResult(ResultEnum resultEnum, T data) {
        return (ResultContent<T>) new ResultContent(resultEnum.getCode(), resultEnum.getMessage(), data);
    }

}
