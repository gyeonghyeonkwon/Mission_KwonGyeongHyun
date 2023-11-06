package com.ll;

import java.sql.SQLOutput;
import java.util.*;

public class App {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==명언앱==");
        int wiseSayingNumber = 0;
        List<Inventory> inventoryList = new ArrayList<>(); //리스트에 객체 저장 선언
        while (true) {
            System.out.print("명령 :");
            String sc = scanner.nextLine();

            if (sc.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break; //반복문 종료
            } else if (sc.equals("등록")) {
                System.out.print("명언 :");
                String wiseSaying = scanner.nextLine();

                System.out.print("작가 :");
                String author = scanner.nextLine();
                wiseSayingNumber++; // 정수 증가
                int id = wiseSayingNumber; // 증가한 값 id 변수에 저장
                System.out.printf("%d번 명언이 등록되었습니다.%n", id);
                Inventory inventory = new Inventory(id, author, wiseSaying); // 객체 생성 선언 , 생성자 매개 변수전달
                inventoryList.add(inventory); // 리스트에 클래스 객체들을 저장 ( id ,another , wiseSaying)
            } else if (sc.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-".repeat(18));
                for (int i = inventoryList.size() - 1; i >= 0; i--) { // 리스트 사이즈 -1 만큼 역순순회
                    Inventory inventory = inventoryList.get(i); // 리스트에 저장되어있는 값을 꺼내어 클래스의 객체에저장
                    System.out.printf("%d %s %s %n", inventory.id, inventory.author, inventory.wiseSaying);
                }
            } else if (sc.startsWith("삭제?")) {
                String[] scBit = sc.split("\\?", 2);
                String scAction = scBit[0];
                String queryString = scBit[1];
                String[] queryStringBit = queryString.split("&"); //["id=2"]
                int id = 0;
                for (int i = 0; i < queryStringBit.length; i++) {  // queyStringBit 길이만큼 순회
                    String queryStringStr = queryStringBit[i]; // "id = 2"
                    String[] queryStringParam = queryStringStr.split("=", 2); //  "id" , "2"
                    String ParamName = queryStringParam[0]; // "id" 저장
                    String ParamValue = queryStringParam[1]; // "2" 저장

                    if (ParamName.equals("id")) {
                        id = Integer.parseInt(ParamValue);
                    }
                }

                if (inventoryList.isEmpty()) {  // 목록에 저장된값이 없을때 동작
                    System.out.println("현재 목록에 명언이 없습니다");
                }

                for (int i = 0; i < inventoryList.size(); i++) { // 객체가 저장되어있는 리스트에 사이즈만큼 순회한다
                    Inventory inventory = inventoryList.get(i); // 리스트에 저장되어있는 값을 꺼내어 클래스의 객체에저장.
                    if (inventory.id == id) { // 현재 목록에 저장 되어 있는 id 와 현재 입력된 id 값이 같다고 한다면
                        inventoryList.remove(i); // 삭제한다.
                        System.out.printf("%d 번 명언이 삭제되었습니다%n", id);

                    }
                     if (inventory.id != id) { //목록에 저장된 값이 존재 하되 id값이 다르게 입력할때 동작.
                        System.out.printf("%d번 명언을 찾을수없습니다",id);
                         break;
                    }
                }

            }
        }
    }
}