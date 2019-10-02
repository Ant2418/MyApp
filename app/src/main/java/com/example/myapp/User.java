package com.example.myapp;

public class User {
    private String userName;
    private Integer scoreUser;

    /**
     * Constructeur de la classe USER
     * @param userName string
     * @param scoreUser int
     */
    public User(String userName, Integer scoreUser) {
        this.userName = userName;
        this.scoreUser = scoreUser;
    }

    public User(String userName) {
        this.userName = userName;
    }

    /**
     * Getter du nom de l'utilisateur
     * @return nom de l'utilisateur
     */
    public String getUserName() {
        return userName;
    }

    /**
     * setter du nom de l'utilisateur
     * @param userName string
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * getter du score de l'utilisateur
     * @return score de l'utilisateur (int)
     */
    public Integer getScoreUser() {
        return scoreUser;
    }

    /**
     * Setter du score de l'utilisateur
     * @param scoreUser
     */
    public void setScoreUser(Integer scoreUser) {
        this.scoreUser = scoreUser;
    }
}
