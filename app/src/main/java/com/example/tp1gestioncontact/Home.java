package com.example.tp1gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    private TextView tvuser_home;
    private Button btnadd_home,btndisp_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvuser_home=findViewById(R.id.tvuser_home);
        btnadd_home=findViewById(R.id.btnadd_home);
        btndisp_home=findViewById(R.id.btndisp_home);


        Intent x = this.getIntent();
        Bundle b = x.getExtras();
        String username= b.getString("userName");

        tvuser_home.setText("Home of M. "+username);

    }
}
