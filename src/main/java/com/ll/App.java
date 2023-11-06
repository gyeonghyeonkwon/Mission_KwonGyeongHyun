package com.ll;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.SimpleTimeZone;
import java.util.SortedMap;

public class App {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==명언앱==");
        while (true) {
            System.out.print("명령 :");
            String sc = scanner.nextLine();

            if (sc.equals("종료")){
                break;
            }
        }
    }
}
