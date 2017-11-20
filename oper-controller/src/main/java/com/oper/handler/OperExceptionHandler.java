package com.oper.handler;

import com.oper.bean.ApiResultBean;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yemingfeng
 */
@ControllerAdvice
public class OperExceptionHandler {

  @ExceptionHandler(Exception.class)
  @ResponseBody
  public ApiResultBean getApiResultBean(HttpServletRequest request, Exception e) {
    return ApiResultBean.failed(e.getMessage());
  }
}