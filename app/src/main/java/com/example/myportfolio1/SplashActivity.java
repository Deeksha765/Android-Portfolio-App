package com.example.myportfolio1;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 6000; // 3 seconds
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Button btnContinue = findViewById(R.id.btnContinue);

        // Auto-navigate after delay
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                navigateToLogin();
            }
        };
        handler.postDelayed(runnable, SPLASH_DURATION);

        // Manual navigation on button click
        btnContinue.setOnClickListener(v -> {
            handler.removeCallbacks(runnable); // Cancel auto-navigation
            navigateToLogin();
        });
    }

    private void navigateToLogin() {
        // Create explicit intent to navigate to LoginActivity
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        finish(); // Prevent going back to splash screen
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Clean up handler to prevent memory leaks
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }
}