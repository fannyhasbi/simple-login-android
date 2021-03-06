package com.example.kelompok26.aplikasimodul2kel06;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private DatabaseHandler databaseHandler;
    private User usermodel;
    private TextView tvNameMain;
    private Button btnLogoutMain, btnAbout, btnKelompok, btnEmail;
    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initPreference();
        logout();
        about();
        kelompok();
        email();
    }

    @Override
    public void onBackPressed() {
        showAlertDialog();
    }

    private void initView() {
        tvNameMain = findViewById(R.id.tvNameMain);
        btnLogoutMain = findViewById(R.id.btnLogoutMain);
        btnAbout = findViewById(R.id.btnAbout);
        btnKelompok = findViewById(R.id.btnKelompok);
        btnEmail = findViewById(R.id.btnEmail);
        exit = findViewById(R.id.btnLogoutMain);
    }


    private void initPreference() {
        SharedPreferences preferences = getSharedPreferences("LoginPreference", MODE_PRIVATE);
        String username = preferences.getString("username", "");

        tvNameMain.setText(username);
    }

    private void deletePreference(){
        SharedPreferences preferences = getSharedPreferences("LoginPreference", MODE_PRIVATE);
        preferences.edit().remove("username").commit();
        preferences.edit().remove("password").commit();
    }

    private void logout() {
        exit.setOnClickListener(view -> showAlertDialog());
    }

    private void about(){
        btnAbout.setOnClickListener(V -> {
            Intent abt = new Intent(this, About.class);
            startActivity(abt);
            finish();}
        );
    }

    private void kelompok(){
        btnKelompok.setOnClickListener(V -> {
            Intent kel = new Intent(this, KelompokActivity.class);
            startActivity(kel);
            finish();}
        );
    }

    private void email(){
        btnEmail.setOnClickListener(V -> {
            Intent yoyoy = new Intent(this, EmailActivity.class);
            startActivity(yoyoy);
            finish();}
        );
    }

    public void showAlertDialog() {
        new AlertDialog.Builder(this)
                .setMessage("Apa kalian ingin Logout?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        deletePreference();
                        Intent login = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(login);
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

}