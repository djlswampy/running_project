//package com.example.runningapplication.ClassPakage;
//
//import static android.content.Context.MODE_PRIVATE;
//
//import android.content.Context;
//import android.content.SharedPreferences;
//
//import com.example.runningapplication.RecyclerView.DetailRecord_ItemData;
//import com.example.runningapplication.RecyclerView.ItemData;
//import com.naver.maps.geometry.LatLng;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.lang.reflect.Type;
//import java.security.Key;
//import java.util.ArrayList;
//
//public class preference_JSON {
//
////    static Context context;
////    static SharedPreferences preferences;
//
////    JSONObject jsonObject = new JSONObject();
//
//
//
//
//
////    public static String object_string(Context context, String ID){ //shared에서 string형태로 저장되어 있는 객체 반환 -> 굳이?
////        SharedPreferences prefs = context.getSharedPreferences("memberInfo", MODE_PRIVATE);
////        return prefs.getString(ID, "");
////    }
//
//
//    public static <T>void array_Json(Context context, String ID, String listName, ArrayList<T> arrayList){ // 어레이 json으로 shared에 저장
//        JSONObject jsonObject = new JSONObject();
//        SharedPreferences prefs = context.getSharedPreferences("memberInfo", MODE_PRIVATE );
//        SharedPreferences.Editor editor = prefs.edit();
//
//        try {
//
//            jsonObject.put(listName, arrayList);
//
//        } catch (JSONException e) {
//            throw new RuntimeException(e);
//        }
//
//        editor.putString(ID, jsonObject.toString()); //ID는 객체의 key값
//        editor.apply();
//    }
//
//
//
//
//    //1. 객체를 JSONObject화
//    //2. JSONObject를 String으로 파싱
//    //3. String으로 파싱된 객체를 shared에 저장
//    //------------------------------------------
//    //4. Shared에 저장된 String 형식의 데이터를 불러옴
//    //5. String 형식의 데이터를 JSONObject로 변환
//    //6. 객체를 생성하고 getString, getInt등의 메서드를 활용해 데이터 할당 (예시 : testobject.name = jsonObject.getString("name"); name은 key값)
//    //7. 객체의 필드값이 리스트라면 getString(key)를 사용해서 JASONObject에 String 타입으로 존재하는 리스트를 받아온다 (예시 : String testArrayString = jsonObject.getString("testArrayList");)
//    //8. 해당 값을 JSONArray로 변환
//    //9. JSONArray을 for문으로 순회하면서 각 항목 파싱.
//    //10. 파싱한 값들을 적절한 데이터 타입으로 변환하여 리스트에 추가.
//    //11. 리스트가 포함된 객체 완성
//
//
//    //그냥 객체만 파싱하면 String 구조의 데이터를 받게 되어서 사용할 수 없음
//    //{"name":"ㅇㅇ","testArrayList":"[[111111, 222222, 333333]]"} 이런 String 구조로 받게됨.
//
//    //먼저 객체를 통채로 String으로 파싱해서 받은 후 객체 안의 리스트들을 모두 JASONArray로 다시 변환한 다음
//    // 리스트 구성 데이터들을 모두 하나씩 파싱해서 String 구조가 아닌 리스트가 되도록 해줘야 함.
//    //[[111111, 222222, 333333]] 위 작업을 통해 리스트 형식을 갖춤
//
//
//    //1차원 어레이 파싱 메서드
//
//
//    public static ArrayList<ItemData> jsonObject_array_items(Context context, String key, String arrayName){ //key가 user의 ID
//        SharedPreferences preferences = context.getSharedPreferences("memberinfo", MODE_PRIVATE);
//        String objectString = preferences.getString(key, "");
//        ArrayList<ItemData> tempArray = new ArrayList<>();
//
//        try {
//            JSONObject jsonObject = new JSONObject(objectString);
//            String arrayString = jsonObject.getString(arrayName);
//
//            JSONArray jsonArray = new JSONArray(arrayString);
//
//            for (int i = 0; i < jsonArray.length(); i++) { //length는 요소의 개수 반환
//                JSONObject itemObject = jsonArray.getJSONObject(i);
//
//                String tv_distance = itemObject.getString("tv_distance");
//                String tv_time = itemObject.getString("tv_time");
//                String tv_date = itemObject.getString("tv_date");
//                String dialogText = itemObject.getString("dialogText");
//                ItemData itemData = new ItemData(tv_distance, tv_time, tv_date, dialogText);
//
//
//                tempArray.add(itemData);
//
//
//            }
//
//        } catch (JSONException e) {
//            throw new RuntimeException(e);
//        }
//
//        return tempArray;
//    }
//
//
//    public static ArrayList<Float> jsonObject_array_totalRunningDistance(Context context, String key, String arrayName){ //key가 user의 ID
//        SharedPreferences preferences = context.getSharedPreferences("memberinfo", MODE_PRIVATE);
//        String objectString = preferences.getString(key, "");
//        ArrayList<Float> tempArray = new ArrayList<>();
//
//        try {
//            JSONObject jsonObject = new JSONObject(objectString);
//            String arrayString = jsonObject.getString(arrayName);
//
//            JSONArray jsonArray = new JSONArray(arrayString);
//
//            for (int i = 0; i < jsonArray.length(); i++) { //length는 요소의 개수 반환
//                tempArray.add((Float) jsonArray.get(i));
//
//            }
//
//        } catch (JSONException e) {
//            throw new RuntimeException(e);
//        }
//
//        return tempArray;
//    }
//
////    public static <T> ArrayList<T> jsonObject_array(Context context, String key, String arrayName, Class<T> type){ //key가 user의 ID
////        SharedPreferences preferences = context.getSharedPreferences("memberinfo", MODE_PRIVATE);
////        String objectString = preferences.getString(key, "");
////        ArrayList<T> tempArray = new ArrayList<>();
////
////        try {
////            JSONObject jsonObject = new JSONObject(objectString);
////            String arrayString = jsonObject.getString(arrayName);
////
////            JSONArray jsonArray = new JSONArray(arrayString);
////
////            for (int i = 0; i < jsonArray.length(); i++) { //length는 요소의 개수 반환
////
////                tempArray.add(type.cast(jsonArray.get(i)));
////
////            }
////
////        } catch (JSONException e) {
////            throw new RuntimeException(e);
////        }
////
////        return tempArray;
////    }
//
//
//
//    //2차원 어레이 파싱 메서드
//    public static ArrayList<ArrayList<LatLng>> jsonObject_2dArray_LatLng(Context context, String key, String arrayName){
//
//        SharedPreferences preferences = context.getSharedPreferences("memberinfo", MODE_PRIVATE);
//        String objectString = preferences.getString(key, "");
//        ArrayList<ArrayList<LatLng>> tempArray_array = new ArrayList<>(); //임시 2차원 어레이(껍데기). 내부 어레이 하나씩 채워넣고 마지막에 user의 리스트 참조 변수에 넣기.
//        try {
//            //JASONarray -> 데이터 들어있음. temp ->비어있음. 임시 저장을 위한 리스트
//
//            JSONObject jsonObject = new JSONObject(objectString); //String -> json 객체화
//            String array_arrayString = jsonObject.getString(arrayName); //jsonObject 객체 안에 있는 리스트 String화
//            JSONArray jsonArray = new JSONArray(array_arrayString); //String화한 리스트 JSONarray 화
//
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONArray tempInnerJASONArray = jsonArray.getJSONArray(i); //JSONarray내부 어레이 차례로 선택해서 임시 어레이에 할당.
//                ArrayList<LatLng> tempInnerArray = new ArrayList<>(); //내부 임시 어레이. 값을 모두 할당하면 임시 2차원 어레이에 추가.
//
//                for (int j = 0; j < tempInnerJASONArray.length(); j++) {
////                    tempInnerJASONArray.getString(j);
////
////                    LatLng latLng = new LatLng();
//
//                    String jsonString = tempInnerJASONArray.getString(j); // JSON 형태의 문자열 가져오기
//
//                    // JSON 문자열을 파싱하여 위도(latitude)와 경도(longitude) 값을 추출
//                    JSONObject jsonLatLng = new JSONObject(jsonString);
//                    double latitude = jsonLatLng.getDouble("latitude");
//                    double longitude = jsonLatLng.getDouble("longitude");
//
//                    LatLng latLng = new LatLng(latitude, longitude);
//
//                    tempInnerArray.add(latLng); //get으로 꺼내기. 내부 어레이 채우기. getString 파라미터는 인덱스 의미
//                }
//                tempArray_array.add(tempInnerArray);  //채워진 내부 어레이 2차원 어레이에 배치.
//            }
//
//        } catch (
//                JSONException e) {
//            throw new RuntimeException(e);
//        }
//        return tempArray_array; //완성된 2차원 임시 어레이 user 객체에게 할당.
//
//    }
//
//
//    public static ArrayList<ArrayList<String>> jsonObject_2dArray_String(Context context, String key, String arrayName){
//
//        SharedPreferences preferences = context.getSharedPreferences("memberinfo", MODE_PRIVATE);
//        String objectString = preferences.getString(key, "");
//        ArrayList<ArrayList<String>> tempArray_array = new ArrayList<>(); //임시 2차원 어레이(껍데기). 내부 어레이 하나씩 채워넣고 마지막에 user의 리스트 참조 변수에 넣기.
//        try {
//            //JASONarray -> 데이터 들어있음. temp ->비어있음. 임시 저장을 위한 리스트
//
//            JSONObject jsonObject = new JSONObject(objectString); //String -> json 객체화
//            String array_arrayString = jsonObject.getString(arrayName); //jsonObject 객체 안에 있는 리스트 String화
//            JSONArray jsonArray = new JSONArray(array_arrayString); //String화한 리스트 JSONarray 화
//
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONArray tempInnerJASONArray = jsonArray.getJSONArray(i); //JSONarray내부 어레이 차례로 선택해서 임시 어레이에 할당.
//                ArrayList<String> tempInnerArray = new ArrayList<>(); //내부 임시 어레이. 값을 모두 할당하면 임시 2차원 어레이에 추가.
//
//                for (int j = 0; j < tempInnerJASONArray.length(); j++) {
//                    tempInnerArray.add(tempInnerJASONArray.getString(j)); //get으로 꺼내기. 내부 어레이 채우기. getString 파라미터는 인덱스 의미
//                }
//                tempArray_array.add(tempInnerArray);  //채워진 내부 어레이 2차원 어레이에 배치.
//            }
//
//        } catch (
//                JSONException e) {
//            throw new RuntimeException(e);
//        }
//        return tempArray_array; //완성된 2차원 임시 어레이 user 객체에게 할당.
//
//    }
//
//
//    public static ArrayList<ArrayList<DetailRecord_ItemData>> jsonObject_2dArray_DetailRecord_ItemData(Context context, String key, String arrayName){
//
//        SharedPreferences preferences = context.getSharedPreferences("memberinfo", MODE_PRIVATE);
//        String objectString = preferences.getString(key, "");
//        ArrayList<ArrayList<DetailRecord_ItemData>> tempArray_array = new ArrayList<>(); //임시 2차원 어레이(껍데기). 내부 어레이 하나씩 채워넣고 마지막에 user의 리스트 참조 변수에 넣기.
//        try {
//            //JASONarray -> 데이터 들어있음. temp ->비어있음. 임시 저장을 위한 리스트
//
//            JSONObject jsonObject = new JSONObject(objectString); //String -> json 객체화
//            String array_arrayString = jsonObject.getString(arrayName); //jsonObject 객체 안에 있는 리스트 String화
//            JSONArray jsonArray = new JSONArray(array_arrayString); //String화한 리스트 JSONarray 화
//
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONArray tempInnerJASONArray = jsonArray.getJSONArray(i); //JSONarray내부 어레이 차례로 선택해서 임시 어레이에 할당.
//                ArrayList<DetailRecord_ItemData> tempInnerArray = new ArrayList<>(); //내부 임시 어레이. 값을 모두 할당하면 임시 2차원 어레이에 추가.
//
//                for (int j = 0; j < tempInnerJASONArray.length(); j++) {
//                    JSONObject itemObject = tempInnerJASONArray.getJSONObject(j);
//
//                    String tv_sectionDistance = itemObject.getString("tv_sectionDistance");
//                    String tv_sectionTime = itemObject.getString("tv_sectionTime");
//                    String tv_sectionPace = itemObject.getString("tv_sectionPace");
//
//                    DetailRecord_ItemData itemData = new DetailRecord_ItemData(tv_sectionDistance, tv_sectionTime, tv_sectionPace);
//                    tempInnerArray.add(itemData);
//
//
//                    tempInnerArray.add((DetailRecord_ItemData)tempInnerJASONArray.get(j)); //get으로 꺼내기. 내부 어레이 채우기. getString 파라미터는 인덱스 의미
//                }
//                tempArray_array.add(tempInnerArray);  //채워진 내부 어레이 2차원 어레이에 배치.
//            }
//
//        } catch (
//                JSONException e) {
//            throw new RuntimeException(e);
//        }
//        return tempArray_array; //완성된 2차원 임시 어레이 user 객체에게 할당.
//
//    }
//
//
//
//    //3차원 어레이
//
//
//
//
//
//
//}
