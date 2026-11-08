package com.example.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HelloActivity extends AppCompatActivity {
    private TextView txtHelloCounter;
    private Button btnBackMain;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        txtHelloCounter = findViewById(R.id.txtHelloCounter);
        btnBackMain = findViewById(R.id.btnBackMain);

        counter = getIntent().getIntExtra("counter", 0);
        txtHelloCounter.setText(String.valueOf(counter));

        btnBackMain.setOnClickListener(v -> {
            Intent intent = new Intent(
                    HelloActivity.this,
                    MainActivity.class
            );
            intent.putExtra("counter", counter);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });
    }
}
