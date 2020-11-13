package com.example.tp1gestioncontact;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;

public class Home extends AppCompatActivity implements View.OnClickListener {
    static ArrayList<Contact> contacts = new ArrayList<Contact>();

    private TextView tvuser_home;
    private Button btnadd_home, btndisp_home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvuser_home = findViewById(R.id.tvuser_home);
        btnadd_home = findViewById(R.id.btnadd_home);
        btndisp_home = findViewById(R.id.btndisp_home);


        Intent x = this.getIntent();
        Bundle b = x.getExtras();
        String username = b.getString("userName");

        tvuser_home.setText("Home of M. " + username);

        btnadd_home.setOnClickListener(this);
        btndisp_home.setOnClickListener(this);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED) {
            System.out.println(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            permissionWrite = true;
        } else {
            System.out.println(Manifest.permission.WRITE_EXTERNAL_STORAGE + "11");
            ActivityCompat.requestPermissions(Home.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    1);


        }

    }

    @Override
    public void onClick(View v) {
        if (v == btnadd_home) {
            Intent i = new Intent(Home.this, Ajout.class);
            startActivity(i);
        }
        if (v == btndisp_home) {
            Intent i = new Intent(Home.this, Affichage.class);
            startActivity(i);
        }
    }

    Boolean permissionWrite = false;

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "started", Toast.LENGTH_SHORT);

        String dir = Environment.getExternalStorageDirectory().getPath();
        File file = new File(dir, "fichier.txt");
        if (file.exists()) {
            try {
                contacts.clear();
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] t = line.split("#");
                    Contact c = new Contact(t[0], t[1], t[2]);
                    contacts.add(c);

                }
            } catch (IOException e) {
                e.printStackTrace();

            }
        }

    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "stop", Toast.LENGTH_SHORT);
        if (permissionWrite == false) {
            save_data();
        }
        super.onStop();

    }

    private void save_data() {
        String dir = Environment.getExternalStorageDirectory().getPath();
        File file = new File(dir, "fichier.txt");
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < contacts.size(); i++) {
                bufferedWriter.write(contacts.get(i).nom + "#" + contacts.get(i).nom + "#" + contacts.get(i).nom + "\n");

            }
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "destroy", Toast.LENGTH_SHORT);
        super.onDestroy();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            permissionWrite = true;
        } else {
            permissionWrite = false;

        }
    }
}
