package com.example.myapp;

import java.util.List;

public class ListUser {
    private List<User> maListe;

    public List<User> getMaListe() {
        return maListe;
    }

    public void setMaListe(List<User> maListe) {
        this.maListe = maListe;
    }

    public ListUser(){
        maListe.add(new User("Remi", 125));
    }

}
