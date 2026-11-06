package com.example.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    TextView txtThirdCounter;
    Button btnThirdToMain, btnThirdToHello;

    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        txtThirdCounter = findViewById(R.id.txtThirdCounter);
        btnThirdToMain = findViewById(R.id.btnThirdToMain);
        btnThirdToHello = findViewById(R.id.btnThirdToHello);

        counter = getIntent().getIntExtra("counter", 0);

        txtThirdCounter.setText(String.valueOf(counter));
        btnThirdToMain.setOnClickListener(v -> {
            Intent intent = new Intent(
                    ThirdActivity.this,
                    MainActivity.class
            );
            intent.putExtra("counter", counter);
            startActivity(intent);
            finish();
        });
        btnThirdToHello.setOnClickListener(v -> {
            Intent intent = new Intent(
                    ThirdActivity.this,
                    HelloActivity.class
            );
            intent.putExtra("counter", counter);
            startActivity(intent);
            finish();
        });
    }
}