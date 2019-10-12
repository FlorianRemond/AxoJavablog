package com.example.axojavablog;

public class Category {
    private int idCat;
    private String titleCat;
    private String descriptionCat;
    //rticle article ;

    public Category() {
        // this.article =  new Article();
    }

    public Category(int idCat) {
        this.idCat = idCat;
        // this.article =  new Article();
    }

    public Category(int idCat, String titleCat, String descriptionCat, Article article) {
        this.idCat = idCat;
        this.titleCat = titleCat;
        this.descriptionCat = descriptionCat;
        // this.article = article;
    }

    public Category(int idCat, String titleCat, String descriptionCat) {
        this.idCat = idCat;
        this.titleCat = titleCat;
        this.descriptionCat = descriptionCat;
        // this.article =  new Article();
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getTitleCat() {
        return titleCat;
    }

    public void setTitleCat(String titleCat) {
        this.titleCat = titleCat;
    }

    public String getDescriptionCat() {
        return descriptionCat;
    }

    public void setDescriptionCat(String descriptionCat) {
        this.descriptionCat = descriptionCat;
    }


    @Override
    public String toString() {
        return "Category{" +
                "idCat=" + idCat +
                ", titleCat='" + titleCat + '\'' +
                ", descriptionCat='" + descriptionCat + '\'' +
                '}';
    }
}
