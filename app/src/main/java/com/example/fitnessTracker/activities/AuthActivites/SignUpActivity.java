package com.example.fitnessTracker.activities.AuthActivites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.EditText;

import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;
import com.example.fitnessTracker.R;


public class SignUpActivity extends AppCompatActivity {

    SharedPreferences preferences;

    public final String TAG = "sign_up_activity";
    public static final String USER_EMAIL = "user_email";
    static final String NAME_TAG = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        setUpSignUpButton();

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String name = preferences.getString(NAME_TAG, "");
        EditText editNameText = findViewById(R.id.signUpActivityNameEditText);
        editNameText.setText(name);

    }

    public void setUpSignUpButton() {

        findViewById(R.id.signUpActivitySignUpButton).setOnClickListener(view -> {
            String userEmail = ((EditText) findViewById(R.id.signUpEmailEditText)).getText().toString();
            String userPassword = ((EditText) findViewById(R.id.signUpPasswordEditText)).getText().toString();
            EditText nameEditText = findViewById(R.id.signUpActivityNameEditText);

            SharedPreferences.Editor preferencesEditor = preferences.edit();
            String nameString = nameEditText.getText().toString();
            preferencesEditor.putString(NAME_TAG, nameString);


            preferencesEditor.apply();

            Amplify.Auth.signUp(
                    userEmail,
                    userPassword,
                    AuthSignUpOptions.builder()
                            .userAttribute(AuthUserAttributeKey.email(), userEmail)

                            .build(),
                    success -> Log.i(TAG, "Sign Up Success"),
                    failure -> Log.e(TAG, "Sign Up Failed With Email: " + userEmail + failure)
            );
            Intent goToConfirmSignUpActivity = new Intent(this, VerifySignUpActivity.class);
            goToConfirmSignUpActivity.putExtra(USER_EMAIL, userEmail);
            startActivity(goToConfirmSignUpActivity);
        });
    }
}