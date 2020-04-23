package cn.noahcode.yww.utils;

import java.io.UnsupportedEncodingException;

/**
 * @author NoahCode
 * @date 2020/4/22
 * @description
 */
public class UrlUtil {
    private final static String ENCODE = "UTF-8";

    /**
     * @return java.lang.String
     * @description url解码
     * @author NoahCode
     * @date 2020/4/22
     * @param str 需要解码的文本
     */
    public static String getURLDecoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLDecoder.decode(str, ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @return java.lang.String
     * @description url编码
     * @author NoahCode
     * @date 2020/4/22
     * @param str 需要编码的文本
     */
    public static String getURLEncoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLEncoder.encode(str, ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
