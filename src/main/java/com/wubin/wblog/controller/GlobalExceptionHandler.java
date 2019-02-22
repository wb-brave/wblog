package com.wubin.wblog.controller;

import com.wubin.wblog.exception.WblogException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author wubin
 * @Description
 * @project sell
 * @package com.wubin.wblog.controller
 * @email wubin326@qq.com
 * @date 2019/02/18
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/02/18        wubin            0.0.1
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = WblogException.class)
    public String tipException(Exception e) {
        LOGGER.error("find exception:e={}",e.getMessage());
        e.printStackTrace();
        return "common/500";
    }


    @ExceptionHandler(value = Exception.class)
    public String exception(Exception e){
        LOGGER.error("find exception:e={}",e.getMessage());
        e.printStackTrace();
        return "common/404";
    }
}

