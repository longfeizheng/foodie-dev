package com.niocoder.com.niocoder.common;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zhenglongfei 2019-12-09.
 *
 * @VERSION 1.0
 */
public class MD5Util {
    /**
     * 得到md5消息摘要字符串
     */
    public static String getMD5Str(String strValue) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return Base64.encodeBase64String(md5.digest(strValue.getBytes()));
    }
}