package com.example.myportfolio1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

public class AboutSkillsActivity extends AppCompatActivity {

    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        // Enable back button in action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("About Me");
        }

        // Initialize back button
        btnBack = findViewById(R.id.btnBack);

        // Set click listener to navigate back to Dashboard
        btnBack.setOnClickListener(v -> navigateBackToDashboard());

        // Handle device back button using OnBackPressedDispatcher (modern approach)
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                navigateBackToDashboard();
            }
        });
    }

    private void navigateBackToDashboard() {
        // Navigate back to Dashboard using explicit intent
        Intent intent = new Intent(AboutSkillsActivity.this, DashboardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Handle action bar back button
        navigateBackToDashboard();
        return true;
    }
}