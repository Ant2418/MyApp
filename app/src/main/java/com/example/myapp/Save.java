package com.example.myapp;

public class Save {
    private String userName;
    private String scoreUser;
    private String difficulty;

    /**
     * Constructeur de la classe USER
     * @param userName string
     * @param scoreUser int
     * @param difficulty string
     */
    public Save(String userName, String scoreUser, String difficulty) {
        this.userName = userName;
        this.scoreUser = scoreUser;
        this.difficulty = difficulty;
    }

    public Save(String userName) {
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
     * @return score de l'utilisateur (string)
     */
    public String getScoreUser() {
        return scoreUser;
    }

    /**
     * Setter du score de l'utilisateur
     * @param scoreUser
     */
    public void setScoreUser(String scoreUser) {
        this.scoreUser = scoreUser;
    }

    /**
     * Getter de la difficulté du jeu
     * @return la difficulté du jeu
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * Setter de la difficulté
     * @param difficulty
     */
    public void setUserDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}