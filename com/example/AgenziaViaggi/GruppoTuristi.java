package com.example;

public class GruppoTuristi {
    private String nationality;
    private int number;

    public GruppoTuristi(String nationality, int number) {
        this.nationality = nationality;
        this.number = number;
    }

    public String getNationality() {
        return nationality;
    }

    public int getNumber() {
        return number;
    }
}
