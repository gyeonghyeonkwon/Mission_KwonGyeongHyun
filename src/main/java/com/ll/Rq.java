package com.ll;

import java.util.HashMap;
import java.util.Map;

public class Rq {

   public String sc;
    private String scAction;
    private String queryString;

    private Map<String , String > paramMap;
    public Rq(String sc) {

        this.sc = sc;

        paramMap = new HashMap<>();

        String[] scBit = sc.split("\\?", 2); // ? 기준 으로 양 옆으로 나눈다 .삭제?id=2 를 입력 하면 "삭제" , "2" 로 나눈다.

       scAction = scBit[0]; // "sc에 입력한 첫번째 문자열 저장"

        if (scBit.length == 1 ) {  //sc에 입력한 문자열 배열이 1개이면  호출 된 곳으로 반환
                return;
        }


        String queryString = scBit[1]; // "id= " 저장

        String[] queryStringBit = queryString.split("&"); //["id= "]

        for (int i = 0; i < queryStringBit.length; i++) {  // queyStringBit 길이만큼 순회

            String queryStringStr = queryStringBit[i]; // "id = "

            String[] queryStringParam = queryStringStr.split("=", 2); //  "id" , " 정수"

            String ParamName = queryStringParam[0]; // "id" 저장

            String ParamValue = queryStringParam[1]; // "정수" 저장

            paramMap.put(ParamName, ParamValue); // 분할된 문자열과 정수 맵으로 저장
        }
    }
        public String getAction () {
            return scAction; // scBit[0] 에 저장한 문자열 반환
        }

    public int getParamAsInt(String findParamName, int defultValue) { // ex 삭제 ? id = 2

        String findParamValue = paramMap.get(findParamName); //map 에서 값을 가져온다.

        if (findParamName != null) { // 입력한 문자열 및 값이 오 입력 되었는지 검사
            try {
                return Integer.parseInt(findParamValue); // 문자열 정수를 정수로 변환
            } catch (NumberFormatException e) {   //예외처리
                return defultValue; // 정수 반환
            }
        }
        return defultValue;

    }
}
