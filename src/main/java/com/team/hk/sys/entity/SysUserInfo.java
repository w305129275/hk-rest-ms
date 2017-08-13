package com.team.hk.sys.entity;

import com.team.hk.common.CommonEntity;

/**
 * Created by lidongliang on 2017/7/18.
 * 系统用户实体
 */
public class SysUserInfo extends CommonEntity {

    private static final long serialVersionUID = 1L;

    private Long userId;            // 用户ID
    private String userName;        // 用户名称
    private String userPassword;    // 用户密码
    private Long userPhone;         // 用户电话
    private int userSex;            // 用户性别
    private String userAddress;     // 用户地址
    private String userRole;        // 用户角色
    private String userType;        // 用户类型
    private Long parentId;          // 父亲ID

    private Long storeId;           // 门店ID

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public SysUserInfo() {
    }

    @Override
    public String toString() {
        return "SysUserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhone=" + userPhone +
                ", userSex=" + userSex +
                ", userAddress='" + userAddress + '\'' +
                ", userRole='" + userRole + '\'' +
                ", userType='" + userType + '\'' +
                ", parentId=" + parentId +
                ", storeId=" + storeId +
                '}';
    }
}
