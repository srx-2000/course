package com.srx.myapplication.File;

/**
 * @author srx
 * @description
 * @create 2020-09-14 20:12:16
 */
public class Phone {
    private String phoneName;
    private String phoneNumber;

    public Phone(String phoneName, String phoneNumber) {
        this.phoneName = phoneName;
        this.phoneNumber = phoneNumber;
    }

    public Phone() {
    }

    public String getPhoneName() {
        return phoneName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
