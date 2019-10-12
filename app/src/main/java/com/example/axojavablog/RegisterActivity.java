package com.example.axojavablog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private DataBaseManager dbm;
    private EditText txtLogin, txtMotDePasse, txtConfMotDePasse, txtMailUser;
    private TextView txtViewRegister;
    private Button btnRegister, btnReset;
    private String chaine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dbm = new DataBaseManager(this);
        //fonction initialisation des bouttons
        initButton();
        //fonction ecoute des boutons
        initButtonListener();

    }

    public void initButton() {

        btnRegister = findViewById(R.id.btnRegister);
        btnReset = findViewById(R.id.btnReset);
        txtLogin = findViewById(R.id.txtLogin);
        txtMotDePasse = findViewById(R.id.txtMotDePasse);
        txtConfMotDePasse = findViewById(R.id.txtConfMotDePasse);
        txtViewRegister = findViewById(R.id.txtViewRegister);
        txtMailUser = findViewById(R.id.txtMailUser);
    }

    public void initButtonListener() {
        btnRegister.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        txtViewRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(txtViewRegister)) {
            Intent Main = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(Main);
        }
        if (view.equals(btnRegister)) {
            String userName = txtLogin.getText().toString().trim();
            String mailUser = txtMailUser.getText().toString().trim();
            String passUser = txtMotDePasse.getText().toString().trim();
            String conf_pass = txtConfMotDePasse.getText().toString().trim();

            if (passUser.equals(conf_pass)) {
                long val = dbm.addUser(mailUser, userName, passUser);
                if (val > 0) {
                    Toast.makeText(this, "Enregistrement confirmé", Toast.LENGTH_SHORT).show();
                    Intent moveToLogin = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(moveToLogin);
                } else {
                    Toast.makeText(this, "Erreur lors de l'enregistrement", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Les mots de passe sont différents", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "btn Register", Toast.LENGTH_SHORT).show();
        }
        if (view.equals(btnReset)) {
            chaine = "";
            txtLogin.setText(chaine);
            txtMailUser.setText(chaine);
            txtMotDePasse.setText(chaine);
            txtConfMotDePasse.setText(chaine);

            Toast.makeText(this, "btn reset", Toast.LENGTH_SHORT).show();
        }

    }


}


