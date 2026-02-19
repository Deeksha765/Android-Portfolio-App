package com.example.myportfolio1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

public class ProjectsContactActivity extends AppCompatActivity {

    private Button btnBackToDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects_contact);

        // Enable back button in action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Projects & Contact");
        }

        // Initialize back button
        btnBackToDashboard = findViewById(R.id.btnBackToDashboard);

        // Set click listener to navigate back to Dashboard
        btnBackToDashboard.setOnClickListener(v -> navigateBackToDashboard());

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
        Intent intent = new Intent(ProjectsContactActivity.this, DashboardActivity.class);
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