package com.ll;

import java.sql.SQLOutput;
import java.util.*;

public class App {
    Scanner scanner = new Scanner(System.in);
    List<Inventory> inventoryList = new ArrayList<>(); //리스트에 객체 저장 선언
    int wiseSayingNumber = 0;

    public void run() {
        System.out.println("==명언앱==");
        Rq rq = new Rq();
        while (true) {
            System.out.print("명령 :");
            String sc = scanner.nextLine();

            if (sc.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");

                return; //반복문 종료

            } else if (sc.equals("등록")) {

                register();

            } else if (sc.equals("목록")) {

                list();

            } else if (sc.startsWith("삭제?")) {

                listRemove(sc);

            }
            else if (sc.startsWith("수정?")) {

                listModify(sc);

            }
        }
    }

    void register() {

        System.out.print("명언 :");
        String wiseSaying = scanner.nextLine();

        System.out.print("작가 :");
        String author = scanner.nextLine();
        wiseSayingNumber++; // 정수 증가
        int id = wiseSayingNumber; // 증가한 값 id 변수에 저장
        System.out.printf("%d번 명언이 등록되었습니다.%n", id);
        Inventory inventory = new Inventory(id, author, wiseSaying); // 객체 생성 선언 , 생성자 매개 변수 전달
        inventoryList.add(inventory); // 리스트에 클래스 객체들을 저장 ( id ,another , wiseSaying)

    }

    void list() {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(18));
        for (int i = inventoryList.size() - 1; i >= 0; i--) { // 리스트 사이즈 -1 만큼 역순순회
            Inventory inventory = inventoryList.get(i); // 리스트에 저장되어있는 값을 꺼내어 클래스의 객체에저장
            System.out.printf("%d %s %s %n", inventory.id, inventory.author, inventory.wiseSaying);
        }

    }

    void listRemove(String sc) {

        int id= getParamAsInt (sc , "id" ,0); //입력된 "id" 문자열 이 나 값이 오입력 이면 0을 반환.

        if (id ==0) { // id 값이 false 면 실행
            System.out.println("삭제할 id 를 찾을 수 없습니다.");
            return; //함수를 끝낸다.
        }

    }

    void listModify(String sc) {

        int id= getParamAsInt (sc , "id" ,0); //입력된 "id" 문자열 이 나 값이 오입력 이면 0을 반환.

        if (id ==0) { // id 값이 false 면 실행
            System.out.println("수정할 id 를 찾을 수 없습니다.");
            return; //함수를 끝낸다.
        }

        }

        int getParamAsInt (String sc , String findParamName , int defultValue){

            String[] scBit = sc.split("\\?", 2); // ? 기준 으로 양 옆으로 나눈다 .삭제?id=2 를 입력 하면 "삭제" , "2" 로 나눈다.
           // String scAction = scBit[0];
            String queryString = scBit[1]; // "id=2" 저장
            String[] queryStringBit = queryString.split("&"); //["id=2"]
            for (int i = 0; i < queryStringBit.length; i++) {  // queyStringBit 길이만큼 순회
                String queryStringStr = queryStringBit[i]; // "id = 2"
                String[] queryStringParam = queryStringStr.split("=", 2); //  "id" , "2"
                String ParamName = queryStringParam[0]; // "id" 저장
                String ParamValue = queryStringParam[1]; // "2" 저장

                try {
                if (ParamName.equals(findParamName))  // "id" 문자열이 일치한다고하면 실행
                    return Integer.parseInt(ParamValue);
                }
                catch (NumberFormatException e){ //정수 값이 아닌 문자열 값 입력 시 예외
                    return defultValue;
                }
            }
                return defultValue;
        }
}
