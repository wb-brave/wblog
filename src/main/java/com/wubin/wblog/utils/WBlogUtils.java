package com.wubin.wblog.utils;

import com.wubin.wblog.constant.WblogConst;
import com.wubin.wblog.constant.WebConst;
import com.wubin.wblog.entity.Users;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class WBlogUtils {

    /**
     * 匹配邮箱正则
     */
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    /**
     * 判断是否是邮箱
     *
     * @param emailStr
     * @return
     */
    public static boolean isEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    /**
     * 返回当前登录用户
     *
     * @return
     */
    public static Users getLoginUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (null == session) {
            return null;
        }
        return (Users) session.getAttribute(WebConst.LOGIN_SESSION_KEY);
    }

    /**
     * 设置记住密码cookie
     *
     * @param response
     * @param uid
     */
    public static void setCookie(HttpServletResponse response, Integer uid) {
        try {
            String val = Tools.enAes(uid.toString(), WebConst.AES_SALT);
            boolean isSSL = false;
            Cookie cookie = new Cookie(WebConst.USER_IN_COOKIE, val);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 30);
            cookie.setSecure(isSSL);
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * md5加密
     *
     * @param source 数据源
     * @return 加密字符串
     */
    public static String MD5encode(String source) {
        if (StringUtils.isBlank(source)) {
            return null;
        }
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ignored) {
        }
        byte[] encode = messageDigest.digest(source.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte anEncode : encode) {
            String hex = Integer.toHexString(0xff & anEncode);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static String md5Decoder(String ciper) {
        if (Objects.isNull(ciper)) {
            return null;
        }
        StringBuilder hexString = new StringBuilder();
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = messageDigest.digest(ciper.getBytes());
            //解密失败
            // for (byte b : bytes
            //         ) {
            //     String hex = Integer.toHexString(0xff & b);
            //     if (hex.length() == 1) {
            //         hexString.append('0');
            //     }
            //     hexString.append(hex);
            // }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hexString.toString();
    }

    public static boolean checkParams(String... params) {
        boolean flag = Boolean.TRUE;
        for (String param : params) {
            if (StringUtils.isEmpty(param)) {
                String tempparam = getLocalCache().get(WblogConst.VALID_PARAM);
                if (StringUtils.isEmpty(tempparam)){
                    getLocalCache().set(WblogConst.VALID_PARAM, param);
                }else{
                    getLocalCache().set(WblogConst.VALID_PARAM, tempparam +" "+ param);
                }
                flag = false;
            }
        }
        return flag;
    }

    public static LocalCache getLocalCache() {
        return LocalCache.single();
    }
}
