package com.example.fitnessTracker.activities.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.fitnessTracker.R;


public class MainActivity extends AppCompatActivity {
    public static final String USER_INPUT_EXTRA_TAG = "userInput";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView settingsButton = (ImageView) findViewById(R.id.MainActivitySettingsImg);
        settingsButton.setOnClickListener(v -> {
//            String userInput = ((EditText)findViewById(R.id.)).getText().toString();
            Intent goToUserSettingsIntent = new Intent(this, UserSettingsActivity.class);
//            goToUserSettingsIntent.putExtra(, userInput);
            startActivity(goToUserSettingsIntent);
        });

        Button userProfileButton = (Button) findViewById(R.id.MainActivityUserProfileBtn);
        userProfileButton.setOnClickListener(v -> {
            Intent goToAddTaskFromIntent = new Intent(this, UserProfileActivity.class);
            startActivity(goToAddTaskFromIntent);
        });
    }
}