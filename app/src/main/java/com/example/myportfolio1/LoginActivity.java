package com.example.myportfolio1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText etUsername;
    private TextInputEditText etPassword;
    private Button btnLogin;

    // Demo credentials
    private static final String DEMO_USERNAME = "student";
    private static final String DEMO_PASSWORD = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // Set click listener for login button
        btnLogin.setOnClickListener(v -> validateAndLogin());

        // Handle device back button - exit app from login screen
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finishAffinity(); // Close the app
            }
        });
    }

    private void validateAndLogin() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // Input validation
        if (username.isEmpty()) {
            etUsername.setError("Username is required");
            etUsername.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            etPassword.requestFocus();
            return;
        }

        // Validate credentials
        if (username.equals(DEMO_USERNAME) && password.equals(DEMO_PASSWORD)) {
            // Successful login
            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();

            // Create explicit intent and pass username to Dashboard
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            intent.putExtra("USERNAME", username);
            startActivity(intent);
            finish(); // Prevent going back to login
        } else {
            // Failed login
            Toast.makeText(this, "Invalid credentials. Try student/portfolio123",
                    Toast.LENGTH_LONG).show();
            etPassword.setText(""); // Clear password field
        }
    }
}