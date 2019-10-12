package com.example.axojavablog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DataBaseManager extends SQLiteOpenHelper {
    /*  Création de la base de données qui aura le nom de Axobdd*/
    private static final String DATABASE_NAME = "Axobdd";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_NAME = "user";
    private static final String TABLE_NAME2 = "admin";

    private static final String COL_1 = "idUser";
    private static final String COL_2 = "mailUser";
    private static final String COL_3 = "nameUser";
    private static final String COL_4 = "passUser";

    private static final String COL_5 = "idAdmin";
    private static final String COL_6 = "nameAdmin";
    private static final String COL_7 = "passAdmin";


    String mailUser, nameUser, passUser;
    String titreArticle, contentArticle, imageArticle;
    String titleCat, descriptionCat;

    /*  */
    public DataBaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String requeteArticle = "create table article(idArticle integer primary key autoincrement, titreArticle text not null, contentArticle text not null, imageArticle text not null)";
        String requeteCategory = "create table category (idCat integer primary key autoincrement, titleCat text not null, descriptionCat text not null)";
        String requeteUser = "create table user (idUser integer primary key autoincrement, mailUser text not null, nameUser text not null, passUser text not null)";
        String requeteAdmin = "create table admin (idAdmin integer primary key autoincrement, nameAdmin text not null, passAdmin text not null)";

        db.execSQL(requeteArticle);
        db.execSQL(requeteCategory);
        db.execSQL(requeteUser);
        db.execSQL(requeteAdmin);
        Log.i("DB", "Création Ok");
    }

    //mise  a jour du schema de la BDD
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.onCreate(db);
        Log.i("DB", "OnUpgrade");
    }

    //ajout d'une catégorie
    public void insertCategory(String titleCat, String descriptionCat) {
        String req = "INSERT INTO category(titleCat,descriptionCat) values('" + titleCat + "','" + descriptionCat + "')";
        this.getReadableDatabase().execSQL(req);
        Log.i("DB", "Insert Category Ok");
    }

    //ajout d'un admin dans la base
    public void insertAdmin(String nameAdmin, String passAdmin) {
        String req = "INSERT INTO admin (nameAdmin,passAdmin) values ('" + nameAdmin + "', '" + passAdmin + "')";
        this.getReadableDatabase().execSQL(req);
        Log.i("DB", "Insert Admin Ok");
    }

    //ajout d'un article dans la base
    public void insertArticle(String titreArticle, String contentArticle, String imageArticle) {
        // String contentArticle1 = contentArticle.replace("' "," '' ");
        String req = "INSERT INTO article(titreArticle,contentArticle,imageArticle)  values('" + titreArticle + "','" + contentArticle + "' , '" + imageArticle + "')";
        this.getReadableDatabase().execSQL(req);
        Log.i("DB", "Insert Article Ok");
    }

    //ajout d'un User dans la base
    public void insertUser(String mailUser, String nameUser, String passUser) {
        String req = "INSERT INTO user (mailUser,nameUser,passUser) values('" + mailUser + "','" + nameUser + "','" + passUser + "')";
        this.getReadableDatabase().execSQL(req);
        Log.i("DB", "Insert User Ok");


    }

    public long addUser(String mailUser, String nameUser, String passUser) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("mailUser", mailUser);
        contentValues.put("nameUser", nameUser);
        contentValues.put("passUser", passUser);
        long res = db.insert("user", null, contentValues);
        Log.i("DB", "Insert2  User Ok");
        db.close();
        return res;

    }

    //vérification d'un user existant
    public boolean checkUser(String nameUser, String passUser) {
        String[] columns = {COL_1};
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_3 + "=?" + " and " + COL_4 + "=?";
        String[] selectionArgs = {nameUser, passUser};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        cursor.moveToFirst();
        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count > 0;
    }

    //vérification d'un admin existant
    public boolean checkAdmin(String nameAdmin, String passAdmin) {
        String[] columns = {COL_5};
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_6 + "=?" + " and " + COL_7 + "=?";
        String[] selectionArgs = {nameAdmin, passAdmin};
        Cursor cursor = db.query(TABLE_NAME2, columns, selection, selectionArgs, null, null, null);
        cursor.moveToFirst();
        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count > 0;
    }

    //suppression d'une catégorie
    public void deleteCategory(int idCat) {
        String req = "DELETE FROM category  WHERE idCat= '" + idCat + "'";
        Log.i("DB", "Delete catégorie  Ok");
    }

    //suppression d'un article
    public void deleteArticle(int idArticle) {
        String req = "DELETE FROM article  WHERE idArticle= '" + idArticle + "'";
        this.getReadableDatabase().execSQL(req);
        Log.i("DB", "Delete Article Ok");
    }

    //suppression d'un User
    public void deleteUser(int idUser) {
        String req = "DELETE FROM user  WHERE idUser= '" + idUser + "'";
        this.getReadableDatabase().execSQL(req);
        Log.i("DB", "Delete User Ok");
    }

    //récupérer un user
    public User getOneUser(int idUser) {
        SQLiteDatabase db = this.getReadableDatabase();
        User user = null;
        Cursor c = db.rawQuery("SELECT * FROM user WHERE idUser = '" + idUser + "'", null);
        if (c.moveToFirst()) {
            do {
                // Passing values
                // int idUser = c.getInt(0);
                mailUser = c.getString(1);
                nameUser = c.getString(2);
                passUser = c.getString(3);
                user = new User(c.getInt(0), mailUser, nameUser, passUser);
                // Do something Here with values
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return user;
    }

    //récupérer un article
    public Article getOneArticle(int idArticle) {
        SQLiteDatabase db = this.getReadableDatabase();
        Article article = null;
        Cursor c = db.rawQuery("SELECT * FROM article WHERE idArticle = '" + idArticle + "'", null);
        if (c.moveToFirst()) {
            do {
                // Passing values
                // int idArticle = c.getInt(0);
                titreArticle = c.getString(1);
                contentArticle = c.getString(2);
                imageArticle = c.getString(3);
                article = new Article(c.getInt(0), titreArticle, contentArticle, imageArticle);
                // Do something Here with values
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return article;
    }

    //récupérer une catégorie
    public Category getOneCategory(int idCat) {
        SQLiteDatabase db = this.getReadableDatabase();
        Category category = null;
        Cursor c = db.rawQuery("SELECT * FROM category WHERE idCat = '" + idCat + "'", null);
        if (c.moveToFirst()) {
            do {
                // Passing values
                // int idCat = c.getInt(0);
                titleCat = c.getString(1);
                descriptionCat = c.getString(2);
                category = new Category(c.getInt(0), titleCat, descriptionCat);
                // Do something Here with values
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return category;
    }

    // récupérer toutes les catégories dans la base
    public List<Category> getAllCategory() {
        List<Category> listeCat = new ArrayList<>();
        String req = "SELECT * FROM category";
        Cursor cursor = this.getReadableDatabase().rawQuery(req, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Category cat = new Category(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            listeCat.add(cat);
            Log.i("DB", "Getall Categorie Ok" + cat);
            cursor.moveToNext();
            Log.i("DB", "Getall Categorie Ok");

        }
        cursor.close();
        return listeCat;

    }

    // récupérer toutes les articles dans la base
    public List<Article> getAllArticle() {
        List<Article> listeArt = new ArrayList<>();
        String req = "SELECT * FROM article";
        Cursor cursor = this.getReadableDatabase().rawQuery(req, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Article art = new Article(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            listeArt.add(art);
            cursor.moveToNext();
            Log.i("DB", "Getall Articles Ok");
        }
        cursor.close();
        return listeArt;
    }

    // récupérer toutes les users dans la base
    public List<User> getAllUser() {
        List<User> listeUser = new ArrayList<>();
        String req = "SELECT * FROM user";
        Cursor cursor = this.getReadableDatabase().rawQuery(req, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            User user = new User(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            listeUser.add(user);
            cursor.moveToNext();
            Log.i("DB", "Getall User Ok");
        }
        cursor.close();
        return listeUser;
    }

    public void updateCategory(int idCat, String titleCat, String descriptionCat) {
        String req = " UPDATE category SET titleCat='" + titleCat + "', descriptionCat='" + descriptionCat + "' WHERE idCat='" + idCat + "'";
        this.getReadableDatabase().execSQL(req);
        Log.i("DB", "Update Categorie Ok");
    }

    public void updateArticle(int idArticle, String titreArticle, String contentArticle) {
        String req = " UPDATE article SET titreArticle='" + titreArticle + "', contentArticle='" + contentArticle + "' WHERE idArticle= '" + idArticle + "'";
        this.getReadableDatabase().execSQL(req);
        Log.i("DB", "Update Article Ok");
    }

    public void updateUser(int idUser, String mailUser, String nameUser, String passUser) {
        String req = " UPDATE user SET mailUser='" + mailUser + "', nameUser='" + nameUser + "', passUser='" + passUser + "'" +
                " WHERE idUser='" + idUser + "'";
        this.getReadableDatabase().execSQL(req);
        Log.i("DB", "update User Ok");
    }

}
