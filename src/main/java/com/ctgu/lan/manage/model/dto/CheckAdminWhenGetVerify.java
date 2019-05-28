package com.ctgu.lan.manage.model.dto;

/**
 * @Description TODO
 * @auther lan_wh
 * @create 2019-05-28 12:12
 * @ClassName CheckAdminWhenGetVerify
 * @Version 1.0.0
 */
public class CheckAdminWhenGetVerify {
    private String phoneNumber;
    private String email;
    private String verify;

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "CheckAdminWhenGetVerify{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", verify='" + verify + '\'' +
                '}';
    }
}
