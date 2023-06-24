package com.example.common.intercepter;

import com.example.common.entity.GlobalException;
import com.example.common.entity.R;
import com.example.common.entity.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * com.example.commonutils.exceptionhandler
 *
 * @author zhouke
 * 2022/1/27
 * 14:14
 * Steps：
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    //加上这个注解表示用于处理exception异常类
    @ExceptionHandler(Exception.class)
    @ResponseBody //指定返回json数据
    public R error(Exception e) {
        e.printStackTrace();
        return R.error(ResultCode.ERROR, "服务器内部错误");
    }

    @ExceptionHandler(GlobalException.class)
    @ResponseBody
    public R error(GlobalException e) {
        e.printStackTrace();
        return R.error(e.getCode(), e.getMsg());
    }
}