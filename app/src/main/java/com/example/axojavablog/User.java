package com.example.axojavablog;

public class User {
    private int idUser;
    private String mailUser;
    private String nameUser;
    private String passUser;

    public User() {
    }

    public User(int idUser) {
        this.idUser = idUser;
    }

    public User(int idUser, String mailUser, String nameUser, String passUser) {
        this.idUser = idUser;
        this.mailUser = mailUser;
        this.nameUser = nameUser;
        this.passUser = passUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getMailUser() {
        return mailUser;
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", mailUser='" + mailUser + '\'' +
                ", nameUser='" + nameUser + '\'' +
                ", passUser=" + passUser +
                '}';
    }
}
