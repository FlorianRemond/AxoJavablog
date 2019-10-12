package com.example.axojavablog;

public class Article {
    Category category;
    private int idArticle;
    private String titreArticle;
    private String contentArticle;
    private String imageArticle;

    public Article() {
        category = new Category();
    }

    public Article(int idArticle) {
        this.idArticle = idArticle;
    }

    public Article(String titreArticle, String contentArticle, String imageArticle) {
        this.titreArticle = titreArticle;
        this.contentArticle = contentArticle;
        this.imageArticle = imageArticle;
    }

    public Article(int idArticle, String titreArticle) {
        this.idArticle = idArticle;
        this.titreArticle = titreArticle;
    }

    public Article(int idArticle, String titreArticle, String contentArticle, String imageArticle) {
        this.idArticle = idArticle;
        this.titreArticle = titreArticle;
        this.contentArticle = contentArticle;
        this.imageArticle = imageArticle;
    }

    public Article(Category category) {
        this.category = category;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getTitreArticle() {
        return titreArticle;
    }

    public void setTitreArticle(String titreArticle) {
        this.titreArticle = titreArticle;
    }

    public String getContentArticle() {
        return contentArticle;
    }

    public void setContentArticle(String contentArticle) {
        this.contentArticle = contentArticle;
    }

    public String getImageArticle() {
        return imageArticle;
    }

    public void setImageArticle(String imageArticle) {
        this.imageArticle = imageArticle;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Article{" +
                "idArticle=" + idArticle +
                ", titreArticle='" + titreArticle + '\'' +
                ", contentArticle='" + contentArticle + '\'' +
                ", imageArticle='" + imageArticle + '\'' +
                ", category=" + category +
                '}';
    }
}



