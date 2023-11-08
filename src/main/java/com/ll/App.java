package com.ll;

import java.sql.SQLOutput;
import java.util.*;

public class App {
    Scanner scanner = new Scanner(System.in);
    List<Inventory> inventoryList = new ArrayList<>(); //리스트에 객체 저장 선언
    int wiseSayingNumber = 0;

    public void run() {
        System.out.println("==명언앱==");



        while (true) {

            System.out.print("명령 :");
            String sc = scanner.nextLine();

            Rq rq = new Rq(sc);

            switch (rq.getAction()) { //rq scAction 으로 부터 반환 받은 문자열 으로 해당 문자열 을 찾음

                case "종료" :

                    System.out.println("프로그램을 종료합니다.");
                    return;
                case "등록" :
                    register();
                    break;
                case "목록" :
                    list();
                    break;
                case "삭제" :
                    listRemove(rq);
                    break;
                case "수정" :
                    listModify(rq);
                    break;
                default:
                    System.out.println("다시 입력 해주세요.");
            }
        }
    }

    private void register() {

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

    private void list() {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(18));
        for (int i = inventoryList.size() - 1; i >= 0; i--) { // 리스트 사이즈 -1 만큼 역순순회
            Inventory inventory = inventoryList.get(i); // 리스트에 저장되어있는 값을 꺼내어 클래스의 객체에저장
            System.out.printf("%d %s %s %n", inventory.id, inventory.author, inventory.wiseSaying);
        }
        if (inventoryList.isEmpty()){ //목록이 비어 있을경우 inventory id 를 초기화 한다
            wiseSayingNumber = 0;
            System.out.println("목록이 비어 있습니다.");
        }

    }

    private void listRemove(Rq rq) {

        int id= rq.getParamAsInt ("id" ,0); //입력된 "id" 문자열 이 나 값이 오입력 이면 0을 반환.

        if (id == 0) { // id 값이 0 이면 실행
            System.out.println("삭제할 id 를 찾을 수 없습니다.");
            return; //함수를 끝낸다.
        }
        int index = getIndexSearchId(id); //결과 값을 반환 받음

        if (index == -1) { // 아이디값을 찾을수 없을 경우 에 실행
            System.out.printf("%d번 명언을 찾을수없습니다.%n",id);
            return;
        }

        inventoryList.remove(index); //명언을 삭제 한다.



        System.out.printf("%d번 명언을 삭제 합니다.%n",id);
    }

    private int getIndexSearchId(int id) {   // 목록에 저장되어있는 만큼 순회 하면서 아이디 값을찾아 삭제한다
        for (int i=0; i < inventoryList.size(); i++) {
            Inventory inventory = inventoryList.get(i);

            if (inventory.id == id) { //목록에 저장 되어있는 아이디값 과 sc 에 입력한 아이디 값과 같을 경우 실행
                return i;
            }
        }
        return -1; //목록에 아이디 값을 찾을 수 없을 경우
    }

    private void listModify(Rq rq) {

        int id= rq.getParamAsInt ("id" ,0); //입력된 "id" 문자열 이 나 값이 오입력 이면 0을 반환.

        if (id ==0) { // id 값이 0이 면 실행
            System.out.println("수정할 id 를 찾을 수 없습니다.");
            return; //함수를 끝낸다.
        }
        int index = getIndexSearchId(id); //결과 값을 반환 받음

        if (index == -1) { // 아이디값을 찾을수 없을 경우 에 실행
            System.out.printf("%d번 명언을 찾을수없습니다.%n",id);
            return;
        }
        Inventory inventory = inventoryList.get(index);
        System.out.printf("명언 (기존): %s %n", inventory.wiseSaying);
        System.out.printf("명언 : ");
        String wiseSaying = scanner.nextLine();

        System.out.printf("작가 (기존): %s %n", inventory.author);
        System.out.print("작가 :");
        String author = scanner.nextLine();

        inventory.wiseSaying = wiseSaying;
        inventory.author = author;

        System.out.printf("%d번 명언이 수정 되었습니다.%n",id);
        }


}
