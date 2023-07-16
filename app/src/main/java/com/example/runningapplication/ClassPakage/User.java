package com.example.runningapplication.ClassPakage;

import com.example.runningapplication.RecyclerView.DetailRecord_ItemData;
import com.example.runningapplication.RecyclerView.ItemData;
import com.naver.maps.geometry.LatLng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User {

    public String password;




    public ArrayList<ItemData> items = new ArrayList<>(); //adapter용


    public ArrayList<ArrayList<DetailRecord_ItemData>> recordItemsList_List = new ArrayList<>(); //adapter용



//    public Map<Integer, ArrayList>  recordItemsList= new HashMap<>(); //adapter용. record의 아이템 position값을 키로 설정


    public Map<String, String> dailyLogList = new HashMap<>(); //해시맵 자료구조. 날짜(key) - 텍스트(value)


    //통계 액티비티
    public Map<String, Float[]>  totalRecordList = new HashMap<>();
    public Map<String, ArrayList<String>>  year_KeyList = new HashMap<>();
    public Map<String, ArrayList<String>>  year_month_KeyList = new HashMap<>();
    public Map<String, ArrayList<String>>  year_month_week_KeyList = new HashMap<>();
    public ArrayList<String> sameYearKeyList = new ArrayList<>(); //같은 연도에 해당하는 key값 저장. 해가 바뀌면 초기화
    public ArrayList<String> sameMonthKeyList = new ArrayList<>(); //같은 연도,월에 해당하는 key값 저장. 달이 바뀌면 초기화
    public ArrayList<String> sameWeekKeyList = new ArrayList<>(); //같은 연도,월,주에 해당하는 key값 저장. 주가 바뀌면 초기화


    public ArrayList<Float> totalRunningDistance = new ArrayList<>(); //총 거리 계산을 위한 달린 거리 데이터 저장 어레이



    public ArrayList<ArrayList<LatLng>> wholePathLatngList_List = new ArrayList<>(); //전체 경로 좌표 리스트를 담을 리스트. 전체 루트를 런닝이 끝날 때 마다 담는다.

    public ArrayList<ArrayList<ArrayList<LatLng>>> sectionPathLatngList_List = new ArrayList<>(); //부분 경로 좌표 리스트를 담을 리스트. 전체 루트를 런닝이 끝날 때 마다 담는다.


    public ArrayList<ArrayList<LatLng>> markerLatLngList_List = new ArrayList<>(); //마커 좌표의 리스트를 담을 리스트.

    public ArrayList<ArrayList<String>> infoList_List = new ArrayList<>(); //마커의 태그에 들어갈 내용을 담은 리스트를 담을 리스트





//----오류???? ->마커는 json으로 저장 못 함
//    public ArrayList<ArrayList<Marker>> markerList_List = new ArrayList<>(); //마커 리스트를 담을 리스트
//
//    public ArrayList<ArrayList<InfoWindow>> infoWindowList_List = new ArrayList<>(); //정보창 리스트를 담을 리스트




}
