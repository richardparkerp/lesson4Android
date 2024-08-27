package com.example.lesson4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class

MainActivity extends AppCompatActivity {

    CheckBox M;
    CheckBox W;
    EditText login;
    EditText pass;
    ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        M = findViewById(R.id.checkBox);
        W = findViewById(R.id.checkBox2);
        login = findViewById(R.id.login);
        pass = findViewById(R.id.pass);
        pbar = findViewById(R.id.pbar);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void move(View view){
        Bundle bundle = new Bundle();
        bundle.putString("login", login.getText().toString());
        bundle.putString("pass", pass.getText().toString());

        if (M.isChecked() && !W.isChecked()) {
            bundle.putString("Gender", "Men");
        } else if (W.isChecked() && !M.isChecked()) {
            bundle.putString("Gender", "Women");
        } else {
            bundle.putString("Gender", "We don't know who you are!");
        }

        Intent intent = new Intent(MainActivity.this, Login.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}