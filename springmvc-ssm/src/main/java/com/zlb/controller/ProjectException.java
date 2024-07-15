package com.zlb.controller;

import com.zlb.exception.BusinessException;
import com.zlb.exception.SystemException;
import com.zlb.pojo.Code;
import com.zlb.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//创建项目总的异常类，并将异常以统一的数据格式Result返回至前端

@RestControllerAdvice
//@RestControllerAdvice可以集中处理所有controller层中抛出的异常
public class ProjectException {
    @ExceptionHandler(Exception.class)
    //@ExceptionHandler(Exception.class)处理除SystemException，BusinessException外的所有异常。
    public Result doException(Exception ex) {
        System.out.println("未知异常");
        return new Result(Code.SYSTEM_UNKNOW_ERR, null, "未知异常");
    }

    /**
     * @param ex 运行时报SystemException异常
     * @return 统一异常格式
     */
    @ExceptionHandler(SystemException.class)
    //@ExceptionHandler(SystemException.class)处理SystemException异常。
    public Result SystemException(SystemException ex) {
        System.out.println("系统异常");
        return new Result(ex.getCode(), null, ex.getMessage());
    }

    /**
     * @param ex 运行时报BusinessException异常
     * @return 统一异常格式
     */
    @ExceptionHandler(BusinessException.class)
    //@ExceptionHandler(BusinessException.class)处理BusinessException异常
    public Result BusinessException(BusinessException ex) {
        System.out.println("业务异常");
        return new Result(ex.getCode(), null, ex.getMessage());
    }
}
