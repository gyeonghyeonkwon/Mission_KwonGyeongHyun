package com.ll;

public class Inventory {
    int  id; //번호
    String author; //작가
    String wiseSaying; //명언
    public Inventory(int id, String author, String wiseSaying) { //생성자 초기화

        this.id = id;
        this.author = author;
        this.wiseSaying =wiseSaying;
    }
}
