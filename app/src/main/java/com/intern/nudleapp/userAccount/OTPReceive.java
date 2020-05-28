package com.intern.nudleapp.userAccount;

public interface OTPReceive {

    void onOtpReceived(String otp);
    void onOtpTimeout();

}
