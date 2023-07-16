package com.example.runningapplication;


import static android.content.ContentValues.TAG;

import static com.example.runningapplication.ClassPakage.MailCheck.emailChek;
import static com.example.runningapplication.Login.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.runningapplication.ClassPakage.PreferenceManager;
import com.example.runningapplication.ClassPakage.User;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.user.UserApiClient;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class Login extends AppCompatActivity {

    private Button btn_login, btn_signUp, btn_reset;

    private EditText et_ID, et_PW;

    private ImageView kakaoLogin;

    public static User user;
    public static String ID;

    String PW;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_ID = findViewById(R.id.et_ID);
        et_PW = findViewById(R.id.et_PW);
        kakaoLogin = findViewById(R.id.kakaoLogin);

        // 카카오가 설치되어 있는지 확인 하는 메서드또한 카카오에서 제공 콜백 객체를 이용함
        Function2<OAuthToken, Throwable, Unit> callback = new  Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                // 이때 토큰이 전달이 되면 로그인이 성공한 것이고 토큰이 전달되지 않았다면 로그인 실패
                if(oAuthToken != null) {

                }
                if (throwable != null) {

                }
                updateKakaoLoginUi();
                return null;
            }
        };


        et_ID.addTextChangedListener(new TextWatcher() { //텍스트 입력 이벤트를 받는 콜백. 이메일 형식 일치 여부에 따라 텍스트 색 변경
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { //텍스트 변경 전 호출
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { //텍스트 변경 중 호출
                if(emailChek(et_ID.getText().toString()) == false) {
                    et_ID.setTextColor(Color.RED);
                    et_ID.setError("이메일을 올바르게 입력해 주세요");
                } else {
                    et_ID.setTextColor(Color.BLACK);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { //텍스트 변경 후 호출되는 메서드


            }
        });


        btn_login = findViewById(R.id.btn_login);  //로그인 버튼
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ID = et_ID.getText().toString();
                PW = et_PW.getText().toString();

//                SharedPreferences sharedPreferences = getSharedPreferences("meberInfo", MODE_PRIVATE);
//                String value = sharedPreferences.getString(ID, "");
                user = PreferenceManager.getObject(Login.this, ID);

                if(user != null && user.password.equals(PW)) {

                    Toast.makeText(Login.this, "로그인 완료", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Login.this, RunningStart.class);
                    startActivity(intent);


                } else {
                    Toast.makeText(Login.this, "아이디와 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();

                }

//                Intent intent = new Intent(Login.this, RunningStart.class);
//                startActivity(intent);
            }
        });


        btn_signUp = findViewById(R.id.btn_signUp); //회원가입 버튼
        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });


//        btn_reset = findViewById(R.id.btn_reset); //SharedPreferences 리셋버튼
//        btn_reset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                PreferenceManager.clear(Login.this);
//
//
//            }
//        });


        kakaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(UserApiClient.getInstance().isKakaoTalkLoginAvailable(Login.this)) {
                    UserApiClient.getInstance().loginWithKakaoTalk(Login.this, callback);
                }else {
                    UserApiClient.getInstance().loginWithKakaoAccount(Login.this, callback);
                }
            }
        });
    }

    private  void updateKakaoLoginUi(){
        UserApiClient.getInstance().me(new Function2<com.kakao.sdk.user.model.User, Throwable, Unit>() {
            @Override
            public Unit invoke(com.kakao.sdk.user.model.User user1, Throwable throwable) {
                // 로그인이 되어있으면
                if (user1!=null){

//                    // 유저의 아이디
//                    Log.d(TAG,"invoke: id" + user1.getId());
                    // 유저의 어카운트정보에 이메일

                    Log.d(TAG,"invoke: nickname" + user1.getKakaoAccount().getEmail());

//                    // 유저의 어카운트 파일의 성별
//                    Log.d(TAG,"invoke: gerder" + user1.getKakaoAccount().getGender());
//                    // 유저의 어카운트 정보에 나이
//                    Log.d(TAG,"invoke: age" + user1.getKakaoAccount().getAgeRange());

//                    char[] alphabetChar = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
//
//                    String  pw = "";
//                    for (int i = 0; i < 15; i++) {
//                        pw += alphabetChar[(int)(Math.random()*36)];
//                    }
//                    PW = pw;


                    ID = user1.getKakaoAccount().getEmail(); //이메일 받아오기


                    if(PreferenceManager.getObject(Login.this, ID) == null){
                        user = new User();



                        PreferenceManager.setObject(Login.this, ID, user);
                        user = PreferenceManager.getObject(Login.this, ID);

                    } else {
                        user = PreferenceManager.getObject(Login.this, ID);
                        Intent intent = new Intent(Login.this, RunningStart.class);
                        startActivity(intent);
                        finish();
                    }

                }else {
                    // 로그인이 되어 있지 않다면 위와 반대로
                    Log.d(TAG,"로그인 안됨");
                }
                return null;
            }
        });
    }


}