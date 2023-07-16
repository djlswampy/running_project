package com.example.runningapplication;

import static com.example.runningapplication.Login.ID;
import static com.example.runningapplication.Login.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.runningapplication.ClassPakage.PreferenceManager;
import com.example.runningapplication.StatisticsFrament.statistics_frame1;
import com.example.runningapplication.StatisticsFrament.statistics_frame2;
import com.example.runningapplication.StatisticsFrament.statistics_frame3;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Statistics extends AppCompatActivity  {
    public TextView tv_total, tv_this_pace, tv_this_time, tv_this_distance;
    int Seconds, Minutes;

    float total = 0;

//    Button btn_week, btn_month, btn_year;

    float year_distance = 0;
    float year_time = 0;

    float year_month_distance = 0;
    float year_month_time = 0;

    float year_month_week_distance = 0;
    float year_month_week_time = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        tv_total = findViewById(R.id.tv_total);

//        btn_week = findViewById(R.id.btn_week);
//        btn_month = findViewById(R.id.btn_month);
//        btn_year = findViewById(R.id.btn_year);
//


//        user = PreferenceManager.getObject(Statistics.this, ID);

        for (int i = 0; i < user.totalRunningDistance.size(); i++) {
            total += user.totalRunningDistance.get(i);
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String num = decimalFormat.format(total);

        tv_total.setText(num);


        //주간, 월간, 연간 통계 데이터
        //yyyy(4)MM(6)w(7)dd(9)HH(11)mm(13)ss(15))

        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String today = new SimpleDateFormat("yyyyMMWddHHmmss").format(date);


//        System.out.println("test@@!!@!@!!!! 1 !! ! !! @! @!@ !@ !2 1@ !@ !@ !@ !@ 1");
//        System.out.println(user.year_month_week_KeyList.get(today.substring(0, 6)) );
//
//        System.out.println("test@@!!@!@!!!! 1 !! ! !! @! @!@ !@ !2 1@ !@ !@ !@ !@ 1");



//        for (String key: user.year_KeyList.get(today.substring(0, 3))) {// year_KeyList의 key가 연,월,주 && value자체가 totalRecordList의 key리스트
//            year_distance += user.totalRecordList.get(key)[0];
//            year_time += user.totalRecordList.get(key)[1];
//
//        };
//
//        for (String key: user.year_month_KeyList.get(today.substring(0, 5))) {// year_month_KeyListt의 key가 연,월,주 && value자체가 totalRecordList의 key리스트
//            year_month_distance += user.totalRecordList.get(key)[0];
//            year_month_time += user.totalRecordList.get(key)[1];
//
//        };



//        if(user.year_month_week_KeyList.get(today.substring(0, 6)) != null){
//            for (String key: user.year_month_week_KeyList.get(today.substring(0, 6))) { // year_month_week_KeyList의 key가 연,월,주 && value자체가 totalRecordList의 key리스트
//                year_month_week_distance += user.totalRecordList.get(key)[0];
//                year_month_week_time += user.totalRecordList.get(key)[1];
//
//                System.out.println("test@@!!@!@!!!! 1 !! ! !! @! @!@ !@ !2 1@ !@ !@ !@ !@ 1");
//                System.out.println(user.year_month_week_KeyList.get(today.substring(0, 6)) + "값이 존재한다 !!!!!!!!");
//
//                System.out.println("test@@!!@!@!!!! 1 !! ! !! @! @!@ !@ !2 1@ !@ !@ !@ !@ 1");
//            };
//
//        } else {
//
//            System.out.println("test@@!!@!@!!!! 1 !! ! !! @! @!@ !@ !2 1@ !@ !@ !@ !@ 1");
//            System.out.println(user.year_month_week_KeyList.get(today.substring(0, 6)) );
//
//            System.out.println("test@@!!@!@!!!! 1 !! ! !! @! @!@ !@ !2 1@ !@ !@ !@ !@ 1");
//        }




//        Seconds = (int) (UpdateTime / 1000);
//        Minutes = Seconds / 60;
//        Seconds = Seconds % 60;
//
//        // TextView에 UpdateTime을 갱신해준다
//        tv_time1.setText("" + Minutes + ":"
//                + String.format("%02d", Seconds));
//
//        String thisWeekDistance = String.format("%.2f", year_month_week_distance);

        //----------------------


        //액티비티 실헹 시 주간 fragment뜨게 함
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        statistics_frame1 fragment1 = new statistics_frame1();
        transaction.replace(R.id.statistics_frame, fragment1);
        transaction.commit();


//        btn_week.setBackgroundColor(Color.parseColor("#0921BF"));
//        btn_month.setBackgroundColor(Color.parseColor("#498DF3"));
//        btn_year.setBackgroundColor(Color.parseColor("#498DF3"));
//
//
//        btn_week.setOnClickListener(new View.OnClickListener() { //주간
//            @Override
//            public void onClick(View v) {
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                statistics_frame1 fragment1 = new statistics_frame1();
//                transaction.replace(R.id.statistics_frame, fragment1);
//                transaction.commit();
//
//                tv_this_distance = findViewById(R.id.tv_this_distance);
//                tv_this_time = findViewById(R.id.tv_this_time);
//                tv_this_pace = findViewById(R.id.tv_this_pace);
//
//
//                btn_week.setBackgroundColor(Color.parseColor("#0921BF"));
//                btn_month.setBackgroundColor(Color.parseColor("#498DF3"));
//                btn_year.setBackgroundColor(Color.parseColor("#498DF3"));
//
//
//                Seconds = (int) (year_month_week_time / 1000);
//                Minutes = Seconds / 60;
//                Seconds = Seconds % 60;
//
//                String thisWeekDistance = String.format("%.2f", year_month_week_distance);
//
//                tv_this_pace.setText(thisWeekDistance);
//                tv_this_time.setText("" + Minutes + ":"
//                        + String.format("%02d", Seconds));
//
//            }
//        });
//
//        btn_month.setOnClickListener(new View.OnClickListener() { //월간
//            @Override
//            public void onClick(View v) {
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                statistics_frame2 fragment2 = new statistics_frame2();
//                transaction.replace(R.id.statistics_frame, fragment2);
//                transaction.commit();
//
//                tv_this_distance = findViewById(R.id.tv_this_distance);
//                tv_this_time = findViewById(R.id.tv_this_time);
//                tv_this_pace = findViewById(R.id.tv_this_pace);
//
//                btn_week.setBackgroundColor(Color.parseColor("#498DF3"));
//                btn_month.setBackgroundColor(Color.parseColor("#0921BF"));
//                btn_year.setBackgroundColor(Color.parseColor("#498DF3"));
//            }
//        });
//
//        btn_year.setOnClickListener(new View.OnClickListener() { //연간
//            @Override
//            public void onClick(View v) {
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                statistics_frame3 fragment3 = new statistics_frame3();
//                transaction.replace(R.id.statistics_frame, fragment3);
//                transaction.commit();
//
//                tv_this_distance = findViewById(R.id.tv_this_distance);
//                tv_this_time = findViewById(R.id.tv_this_time);
//                tv_this_pace = findViewById(R.id.tv_this_pace);
//
//                btn_week.setBackgroundColor(Color.parseColor("#498DF3"));
//                btn_month.setBackgroundColor(Color.parseColor("#498DF3"));
//                btn_year.setBackgroundColor(Color.parseColor("#0921BF"));
//            }
//        });


    }
}