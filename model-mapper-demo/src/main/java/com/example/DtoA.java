package com.example;

/**
 * @author wyue
 */
public class DtoA {
    Integer userNo;
    String userName;
    String userPassword;

    /**
     * 用于ModelMapper
     */
    public DtoA() {
    }

    public DtoA(Integer userNo, String userName, String userPassword) {
        this.userNo = userNo;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
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

    @Override
    public String toString() {
        return "com.example.DtoA [userNo=" + userNo + ", userName=" + userName + ", userPassword=" + userPassword + "]";
    }
}
