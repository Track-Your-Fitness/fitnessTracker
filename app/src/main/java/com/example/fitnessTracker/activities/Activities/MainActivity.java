package com.example.fitnessTracker.activities.Activities;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fitnessTracker.R;


public class MainActivity extends AppCompatActivity {

    public static final String USER_INPUT_EXTRA_TAG = "userInput";
    public static final String USER_USERNAME_TAG = "userName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentButtons();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String userName = preferences.getString(USER_USERNAME_TAG, "no username");
        ((TextView)findViewById(R.id.MainUsernameDisplay)).setText(userName);
    }

public void intentButtons() {
    Button userProfileButton = (Button) findViewById(R.id.MainActivityUserProfileBtn);
    userProfileButton.setOnClickListener(v -> {
        Intent goToUserProfileIntent = new Intent(this, UserProfileActivity.class);
        startActivity(goToUserProfileIntent);
    });
    ImageView userSettingsButton = (ImageView) findViewById(R.id.MainActivitySettingsImg);
    userSettingsButton.setOnClickListener(v -> {
        Intent goToUserSettingsIntent = new Intent(this, UserSettingsActivity.class);
        startActivity(goToUserSettingsIntent);
    });
}
}