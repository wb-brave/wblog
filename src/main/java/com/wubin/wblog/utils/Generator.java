package com.wubin.wblog.utils;

/**
 * @author wubin
 * @Description
 *
 * 生成器（一般只定义一个方法）
 * 该方法用来产生新的对象
 * @project Learn-develop
 * @package util
 * @email wubin326@qq.com
 * @date 2018/10/25
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/25        wubin            0.0.1
 */
public interface Generator<T> {
    T next();
}
