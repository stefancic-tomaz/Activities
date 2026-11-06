package com.example.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int counter = 0;

    TextView txtCounter;
    Button btnCount, btnActivity2, btnActivity3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCounter = findViewById(R.id.txtCounter);
        btnCount = findViewById(R.id.btnCount);
        btnActivity2 = findViewById(R.id.btnActivity2);
        btnActivity3 = findViewById(R.id.btnActivity3);
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("counter", 0);
        } else {
            counter = getIntent().getIntExtra("counter", 0);
        }

        txtCounter.setText(String.valueOf(counter));
        btnCount.setOnClickListener(v -> {
            counter++;
            txtCounter.setText(String.valueOf(counter));
        });
        btnActivity2.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    HelloActivity.class
            );

            intent.putExtra("counter", counter);
            startActivity(intent);
        });
        btnActivity3.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    ThirdActivity.class
            );

            intent.putExtra("counter", counter);
            startActivity(intent);
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
    }
}