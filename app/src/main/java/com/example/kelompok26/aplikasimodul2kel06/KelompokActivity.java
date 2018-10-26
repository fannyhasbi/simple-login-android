package com.example.kelompok26.aplikasimodul2kel06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class KelompokActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelompok);
    }

    @Override
    public void onBackPressed() {
        Intent utama = new Intent(this, MainActivity.class);
        startActivity(utama);
        finish();
    }
}
