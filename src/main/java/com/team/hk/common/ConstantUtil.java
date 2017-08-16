package com.team.hk.common;

/**
 * Created by lidongliang on 2017/8/8.
 * 常量类
 */
public class ConstantUtil {

    //用户类型
    public static final String USER_TYPE_ADMIN = "0";
    public static final String USER_TYPE_BOSS = "1";
    public static final String USER_TYPE_STORE = "2";

    // 用户角色
    public static final String ROLE_BOSS = "boss";
    public static final String ROLE_USER = "user";
    public static final String ROLE_ADMIN = "admin";

    // Redis
    public static final String KEY0 = "seid";
    public static final String KEY1 = "userId";
    public static final String KEY2 = "userName";
    public static final String KEY3 = "userRole";

    // 桌子二维码路径
    public final static String ROOT_QRC_PATH = "table/QRCode/";

    // 压缩包
    public final static String BASEDIR = "QRCodeImg/";
    public final static String ZIP_NAME = "/QRCodeImg.zip";
}
