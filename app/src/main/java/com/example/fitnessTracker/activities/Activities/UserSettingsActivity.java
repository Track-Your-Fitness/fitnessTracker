package com.example.fitnessTracker.activities.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitnessTracker.R;


public class UserSettingsActivity extends AppCompatActivity {
    SharedPreferences preferences;
    public static final String USER_NAME_TAG = "userName";
    public static final String USER_AGE_TAG = "age";
    public static final String USER_WEIGHT_TAG = "weight";
    public static final String USER_HEIGHT_TAG = "height";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        Intent callingIntent = getIntent();
        String userInputString = null;
        if (callingIntent != null) {
            userInputString = callingIntent.getStringExtra(MainActivity.USER_INPUT_EXTRA_TAG);
        }
        userSettingsInput();
        setupSaveBtn();
    }

    public void userSettingsInput(){
        String userName = preferences.getString(USER_NAME_TAG, "");
        EditText editUsernameText = findViewById(R.id.UserSettingsActivityUserName);
        editUsernameText.setText(userName);

        String userAge = preferences.getString(USER_AGE_TAG, "");
        EditText editUserAgeText = findViewById(R.id.UserSettingsActivityAge);
        editUserAgeText.setText(userAge);

        String userWeight = preferences.getString(USER_WEIGHT_TAG, "");
        EditText editUserWeightText = findViewById(R.id.UserSettingsActivityWtInput);
        editUserWeightText.setText(userWeight);

        String userHeight = preferences.getString(USER_HEIGHT_TAG, "");
        EditText editUserHeightText = findViewById(R.id.UserSettingsActivityHt);
        editUserHeightText.setText(userHeight);
    }

    public void setupSaveBtn(){
        Button saveButton = findViewById(R.id.UserSettingsActivitySaveBtn);
        EditText userNameEditText = (EditText) findViewById(R.id.UserSettingsActivityUserName);
        EditText userAgeEditText = (EditText) findViewById(R.id.UserSettingsActivityAge);
        EditText userWeightEditText = (EditText) findViewById(R.id.UserSettingsActivityWtInput);
        EditText userHeightEditText = (EditText) findViewById(R.id.UserSettingsActivityHt);
        saveButton.setOnClickListener(v -> {
            String userNameString = userNameEditText.getText().toString();
            String userAgeString = userAgeEditText.getText().toString();
            String userWeightString = userWeightEditText.getText().toString();
            String userHeightString = userHeightEditText.getText().toString();
            SharedPreferences.Editor preferencesEditor = preferences.edit();

            preferencesEditor.putString(USER_NAME_TAG, userNameString);
            preferencesEditor.putString(USER_AGE_TAG, userAgeString);
            preferencesEditor.putString(USER_WEIGHT_TAG, userWeightString);
            preferencesEditor.putString(USER_HEIGHT_TAG, userHeightString);
            preferencesEditor.apply();

            Toast.makeText(UserSettingsActivity.this, "Settings saved!", Toast.LENGTH_SHORT).show();
        });
    }
}