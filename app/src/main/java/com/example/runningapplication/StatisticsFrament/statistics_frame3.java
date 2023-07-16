package com.example.runningapplication.StatisticsFrament;

import static com.example.runningapplication.Login.user;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.runningapplication.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class statistics_frame3 extends Fragment { //연간
    TextView tv_this_pace, tv_this_time, tv_this_distance,  tv_last_pace, tv_last_time, tv_last_distance;
    Button btn_week, btn_month, btn_year;
    View view;

    float year_distance = 0;
    float year_time = 0;

    int Seconds, Minutes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_statistics_frame3,container, false);

        tv_this_distance = view.findViewById(R.id.tv_this_distance);
        tv_this_time = view.findViewById(R.id.tv_this_time);
        tv_this_pace = view.findViewById(R.id.tv_this_pace);

        tv_last_pace = view.findViewById(R.id.tv_last_pace);
        tv_last_time = view.findViewById(R.id.tv_last_time);
        tv_last_distance = view.findViewById(R.id.tv_last_distance);

        btn_week = view.findViewById(R.id.btn_week);
        btn_month = view.findViewById(R.id.btn_month);
        btn_year = view.findViewById(R.id.btn_year);

        btn_week.setBackgroundColor(Color.parseColor("#498DF3"));
        btn_month.setBackgroundColor(Color.parseColor("#498DF3"));
        btn_year.setBackgroundColor(Color.parseColor("#0921BF"));






        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String today = new SimpleDateFormat("yyyyMMWddHHmmss").format(date);


        //올해
        if(user.year_KeyList.get(today.substring(0, 4)) != null){

            for (String key: user.year_KeyList.get(today.substring(0, 4))) { // year_month_week_KeyList의 key가 연,월,주 && value자체가 totalRecordList의 key리스트

                year_time += user.totalRecordList.get(key)[0]; //밀리초
                year_distance += user.totalRecordList.get(key)[1]; // km

            };

            Seconds = (int) (year_time / 1000); //밀리초를 초단위로
            Minutes = Seconds / 60;
            Seconds = Seconds % 60;
            String thisMonthDistance = String.format("%.2f", year_distance);


            //평군페이스 계산. 초단위
            int averagePace_Sec= (int)((year_time / 1000) / year_distance);

            int averagePace_Min = averagePace_Sec / 60;
            averagePace_Sec = averagePace_Sec % 60;

            //text
            tv_this_pace.setText(averagePace_Min + " : " + String.format("%02d", averagePace_Sec) + "(분/km)");
            tv_this_distance.setText(thisMonthDistance + "km");
            tv_this_time.setText("" + Minutes + ":"
                    + String.format("%02d", Seconds));

            year_distance = 0; //초기화
            year_time = 0;

        } else {


            tv_this_distance.setText("-");
            tv_this_time.setText("-");
            tv_this_pace.setText("-");

        }



        calendar.add(Calendar.YEAR, -1); //작년
        Date oneMonthAgoDate = calendar.getTime();

        String lastMonth = new SimpleDateFormat("yyyyMMWddHHmmss").format(oneMonthAgoDate);


        //지난 달의 데이터 구하는 코드
        if(user.year_KeyList.get(lastMonth.substring(0, 4)) != null){
            for (String key: user.year_KeyList.get(lastMonth.substring(0, 4))) { // year_month_week_KeyList의 key가 연,월,주 && value자체가 totalRecordList의 key리스트


                year_time += user.totalRecordList.get(key)[0]; //밀리초
                year_distance += user.totalRecordList.get(key)[1]; // km

            };

            Seconds = (int) (year_time / 1000); //밀리초를 초단위로
            Minutes = Seconds / 60;
            Seconds = Seconds % 60;
            String thisMonthDistance = String.format("%.2f", year_distance);


            //평군페이스 계산. 초단위
            int averagePace_Sec= (int)((year_time / 1000) / year_distance);

            int averagePace_Min = averagePace_Sec / 60;
            averagePace_Sec = averagePace_Sec % 60;


            //text
            tv_last_pace.setText(averagePace_Min + " : " + String.format("%02d", averagePace_Sec) + "(분/km)");
            tv_last_distance.setText(thisMonthDistance + "km");
            tv_last_time.setText("" + Minutes + ":"
                    + String.format("%02d", Seconds));

        } else {
            tv_last_distance.setText("-");
            tv_last_time.setText("-");
            tv_last_pace.setText("-");

        }






        btn_week.setOnClickListener(new View.OnClickListener() { //주간
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                statistics_frame1 fragment1 = new statistics_frame1();
                transaction.replace(R.id.statistics_frame, fragment1);
                transaction.commit();

            }
        });

        btn_month.setOnClickListener(new View.OnClickListener() { //월간
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                statistics_frame2 fragment2 = new statistics_frame2();
                transaction.replace(R.id.statistics_frame, fragment2);
                transaction.commit();

            }
        });

        btn_year.setOnClickListener(new View.OnClickListener() { //연간
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                statistics_frame3 fragment3 = new statistics_frame3();
                transaction.replace(R.id.statistics_frame, fragment3);
                transaction.commit();

            }
        });




        return view;
    }
}