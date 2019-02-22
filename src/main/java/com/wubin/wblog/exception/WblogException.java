package com.wubin.wblog.exception;

import lombok.NoArgsConstructor;

/**
 * @author wubin
 * @Description 系统运行时异常
 * @project sell
 * @package com.wubin.wblog.exception
 * @email wubin326@qq.com
 * @date 2019/02/15
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/02/15        wubin            0.0.1
 */
@NoArgsConstructor
public class WblogException extends RuntimeException {
    public WblogException(String msg) {
        super(msg);
    }

    public WblogException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public WblogException(Throwable cause) {
        super(cause);
    }
}
