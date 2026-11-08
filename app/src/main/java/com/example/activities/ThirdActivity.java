package com.example.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    private TextView txtThirdCounter;
    private Button btnThirdToMain, btnThirdToHello;
    private int counter;
    private OnSwipeTouchListener swipeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        txtThirdCounter = findViewById(R.id.txtThirdCounter);
        btnThirdToMain = findViewById(R.id.btnThirdToMain);
        btnThirdToHello = findViewById(R.id.btnThirdToHello);
        View rootLayout = findViewById(R.id.layoutThird);

        counter = getIntent().getIntExtra("counter", 0);
        txtThirdCounter.setText(String.valueOf(counter));

        // Prehod s klikom na gumb
        btnThirdToMain.setOnClickListener(v -> goToMainActivity());
        btnThirdToHello.setOnClickListener(v -> goToHelloActivity());

        // Potezna navigacija (Swipe)
        // poteg proti levi -> MainActivity
        // poteg proti desni -> HelloActivity
        swipeListener = new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeLeft() {
                goToMainActivity();
            }

            @Override
            public void onSwipeRight() {
                goToHelloActivity();
            }
        };

        if (rootLayout != null) {
            rootLayout.setOnTouchListener(swipeListener);
        }
        txtThirdCounter.setOnTouchListener(swipeListener);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (swipeListener != null) {
            swipeListener.onTouch(null, ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    private void goToMainActivity() {
        Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
        intent.putExtra("counter", counter);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();
    }

    private void goToHelloActivity() {
        Intent intent = new Intent(ThirdActivity.this, HelloActivity.class);
        intent.putExtra("counter", counter);
        startActivity(intent);
        finish();
    }
}
