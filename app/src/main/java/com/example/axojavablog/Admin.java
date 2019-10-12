package com.example.axojavablog;

public class Admin {
    private int idAdmin;
    private String nameAdmin;
    private String passAdmin;

    public Admin() {
    }

    public Admin(int idAdmin, String nameAdmin, String passAdmin) {
        this.idAdmin = idAdmin;
        this.nameAdmin = nameAdmin;
        this.passAdmin = passAdmin;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNameAdmin() {
        return nameAdmin;
    }

    public void setNameAdmin(String nameAdmin) {
        this.nameAdmin = nameAdmin;
    }

    public String getPassAdmin() {
        return passAdmin;
    }

    public void setPassAdmin(String passAdmin) {
        this.passAdmin = passAdmin;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "idAdmin=" + idAdmin +
                ", nameAdmin='" + nameAdmin + '\'' +
                ", passAdmin='" + passAdmin + '\'' +
                '}';
    }
}
