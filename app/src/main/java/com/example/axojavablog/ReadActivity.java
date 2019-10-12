package com.example.axojavablog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ReadActivity extends AppCompatActivity implements View.OnClickListener {
    private DataBaseManager dbm;
    private Button btnPrecedent, btnSuivant;
    private TextView txtCategory, txtTitreArticle, txtArticle;
    private ImageView imgArticle;
    private List<Article> listeArt;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        this.index = 0;


        //fonction initialisation des bouttons
        initButtonTxt();
        //fonction ecoute des boutons
        initButtonListener();
        //fonction d'affchage de l'article
        dbm = new DataBaseManager(this);
        this.listeArt = dbm.getAllArticle();
        displayArticle(index);
    }


    @Override
    public void onClick(View view) {
        if (view.equals(btnPrecedent)) {
            if (index >= 0 && index < listeArt.size()) {
                if (index > 0) {
                    index--;
                }
                this.displayArticle(index);
            } else {
                Toast.makeText(this, "---->", Toast.LENGTH_SHORT).show();
            }
        }
        if (view.equals(btnSuivant)) {
            if (index >= 0 && index < listeArt.size()) {
                if (index < listeArt.size() - 1) {
                    index++;
                } else {
                    Toast.makeText(this, "<----", Toast.LENGTH_SHORT).show();
                }
                this.displayArticle(index);
            }
        }


    }

    public void initButtonTxt() {
        btnPrecedent = findViewById(R.id.btnPrecedent);
        btnSuivant = findViewById(R.id.btnSuivant);
        txtTitreArticle = findViewById(R.id.txtTitreArticle);
        txtArticle = findViewById(R.id.txtArticle);
        txtCategory = findViewById(R.id.txtCategory);
        imgArticle = findViewById(R.id.imgArticle);
    }

    public void initButtonListener() {
        btnPrecedent.setOnClickListener(this);
        btnSuivant.setOnClickListener(this);
    }

    public void displayArticle(int idArticle) {
        Article article = this.listeArt.get(idArticle);
        txtTitreArticle.setText(article.getTitreArticle());
        txtArticle.setText(article.getContentArticle());
        imgArticle.setImageResource(Integer.parseInt(article.getImageArticle()));
        //int img1 = R.drawable.imagetest;
        // Log.i("DB", "Article Ok" + img1);


    }


}
