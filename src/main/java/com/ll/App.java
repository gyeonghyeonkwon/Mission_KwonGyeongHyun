package com.ll;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.SimpleTimeZone;
import java.util.SortedMap;

public class App {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==명언앱==");
        int wiseSayingNumber =0;
        while (true) {
            System.out.print("명령 :");
            String sc = scanner.nextLine();

            if (sc.equals("종료")){
                break;
            }
            else if (sc.equals("등록")) {
                System.out.print("명언 :");
                String wiseSaying = scanner.nextLine();

                System.out.print("작가 :");
                String another = scanner.nextLine();
                wiseSayingNumber++;
                int id = wiseSayingNumber;
                System.out.printf("%d번 명언이 등록되었습니다.%n" ,id);
            }

        }
    }
}
