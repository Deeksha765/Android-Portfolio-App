package com.example.myportfolio1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class DashboardActivity extends AppCompatActivity {

    private TextView tvWelcomeUser;
    private CardView cardAboutMe, cardSkills, cardProjects;
    private Button btnLogout;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize views
        tvWelcomeUser = findViewById(R.id.tvWelcomeUser);
        cardAboutMe = findViewById(R.id.cardAboutMe);
        cardSkills = findViewById(R.id.cardSkills);
        cardProjects = findViewById(R.id.cardProjects);
        btnLogout = findViewById(R.id.btnLogout);

        // Retrieve username from intent
        Intent intent = getIntent();
        username = intent.getStringExtra("USERNAME");

        // Display welcome message
        if (username != null && !username.isEmpty()) {
            tvWelcomeUser.setText("Welcome, " + username + "!");
        }

        // Set click listeners for navigation cards
        cardAboutMe.setOnClickListener(v -> navigateToAbout());
        cardSkills.setOnClickListener(v -> navigateToSkills());
        cardProjects.setOnClickListener(v -> navigateToProjects());

        // Logout button
        btnLogout.setOnClickListener(v -> logout());

        // Handle device back button - exit app from dashboard
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finishAffinity(); // Close the app
            }
        });
    }

    private void navigateToAbout() {
        // Create explicit intent to About Me Activity
        Intent intent = new Intent(DashboardActivity.this, AboutSkillsActivity.class);
        intent.putExtra("USERNAME", username);
        startActivity(intent);
    }

    private void navigateToSkills() {
        // Create explicit intent to Skills Activity
        Intent intent = new Intent(DashboardActivity.this, SkillsActivity.class);
        intent.putExtra("USERNAME", username);
        startActivity(intent);
    }

    private void navigateToProjects() {
        // Create explicit intent to Projects & Contact Activity
        Intent intent = new Intent(DashboardActivity.this, ProjectsContactActivity.class);
        intent.putExtra("USERNAME", username);
        startActivity(intent);
    }

    private void logout() {
        // Navigate back to Login screen
        Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
