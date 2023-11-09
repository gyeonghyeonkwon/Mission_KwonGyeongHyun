package com.ll;

public class Inventory {
    public int  id; //번호
    public String author; //작가
    public String wiseSaying; //명언
    public Inventory(int id, String author, String wiseSaying) { //생성자 초기화

        this.id = id;
        this.author = author;
        this.wiseSaying =wiseSaying;
    }
}
