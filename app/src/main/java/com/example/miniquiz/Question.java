package com.example.miniquiz;

public class Question {

    String pytanie;
    String a;
    String b;
    String c;
    String poprawna;

    public Question(String pytanie, String a, String b, String c, String poprawna) {
        this.pytanie = pytanie;
        this.a = a;
        this.b = b;
        this.c = c;
        this.poprawna = poprawna;
    }
}