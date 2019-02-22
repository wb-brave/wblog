package com.wubin.wblog.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wubin
 * @Description
 * @project sell
 * @package com.wubin.wblog.utils
 * @email wubin326@qq.com
 * @date 2019/02/18
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/02/18        wubin            0.0.1
 */
public class WBlogUtilsTest {

    @Test
    public void MD5encode() {
        String pw = "123456";
        String s = WBlogUtils.MD5encode(pw);
        System.out.println(s);
        String s1 = WBlogUtils.md5Decoder(s);
        System.out.println(s1);
    }
}