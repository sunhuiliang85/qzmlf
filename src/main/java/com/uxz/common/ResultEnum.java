package com.uxz.common;


/**
 * 返回参数
 *
 * @author chuan.ma
 * @since 2018/1/24
 */
public interface ResultEnum {

    int success_code = 1;
    int error_code = -1;
    int param_error = -2;

    ResultEnum SUCCESS = new ResultEnum() {
        public String getMessage() {
            return "SUCCESS";
        }

        public int getCode() {
            return success_code;
        }
    };
    ResultEnum ERROR = new ResultEnum() {
        public String getMessage() {
            return "ERROR";
        }

        public int getCode() {
            return error_code;
        }
    };

    ResultEnum PARAM_ERROR = new ResultEnum() {
        public String getMessage() {
            return "ERROR_PARAM";
        }

        public int getCode() {
            return param_error;
        }
    };

    int getCode();

    String getMessage();
}
