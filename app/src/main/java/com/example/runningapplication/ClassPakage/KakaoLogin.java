package com.example.runningapplication.ClassPakage;

import android.app.Application;

import com.kakao.sdk.common.KakaoSdk;

public class KakaoLogin extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        KakaoSdk.init(this, "7632f972df833e2495cc5b03128c171e");

    }
}
