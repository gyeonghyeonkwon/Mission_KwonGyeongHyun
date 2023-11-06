package com.ll;

import java.sql.SQLOutput;
import java.util.*;

public class App {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==명언앱==");
        int wiseSayingNumber =0;
        List <Inventory> inventoryList = new ArrayList<>(); //리스트에 객체 저장 선언
        while (true) {
            System.out.print("명령 :");
            String sc = scanner.nextLine();

            if (sc.equals("종료")){
                break; //반복문 종료
            }
            else if (sc.equals("등록")) {
                System.out.print("명언 :");
                String wiseSaying = scanner.nextLine();

                System.out.print("작가 :");
                String another = scanner.nextLine();
                wiseSayingNumber++; // 정수 증가
                int id = wiseSayingNumber; // 증가한 값 id 변수에 저장
                System.out.printf("%d번 명언이 등록되었습니다.%n" ,id);
                Inventory inventory = new Inventory(id ,another , wiseSaying); // 객체 생성 선언
                inventoryList.add(inventory); // 리스트에 클래스 객체들을 저장 ( id ,another , wiseSaying)
            }
            else if (sc.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-".repeat(18));
                for (int i = inventoryList.size() -1 ; i >= 0; i--){ // 리스트 사이즈 -1 만큼 역순순회
                    Inventory inventory = inventoryList.get(i); // 리스트에 저장되어있는 값을 꺼내어 클래스의 객체에저장
                    System.out.printf("%d %s %s %n" , inventory.id , inventory.another , inventory.wiseSaying);
                }

            }
        }
    }
}
