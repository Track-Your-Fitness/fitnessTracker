//package com.example.fitnessTracker.activities.AuthActivites;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.Button;
//import android.widget.EditText;
//
//
//import com.example.fitnessTracker.R;
//import com.example.fitnessTracker.activities.Activities.MainActivity;
//
//public class LoginActivity extends AppCompatActivity {
//
//    public static final String TAG = "login_activity";
//    Intent callingActivity;
//    String userEmail;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        callingActivity = getIntent();
//
//        setUpLoginButton();
//    }
//
//    public void setUpLoginButton() {
//
//        Button addTaskIntentButton = findViewById(R.id.loginActivitySignUpButton);
//        addTaskIntentButton.setOnClickListener(v -> {
//            Intent goToAddTaskIntent = new Intent(this, SignUpActivity.class);
//            startActivity(goToAddTaskIntent);
//        });
//
//        findViewById(R.id.loginActivitySignUpButton).setOnClickListener(v -> {
//            if (callingActivity != null && callingActivity.getStringExtra(SignUpActivity.USER_EMAIL)!= null) {
//                userEmail = callingActivity.getStringExtra(SignUpActivity.USER_EMAIL);
//                ((EditText)findViewById(R.id.loginActivityEmailEditText)).setText(userEmail);
//            } else {
//                userEmail = ((EditText)findViewById(R.id.loginActivityEmailEditText)).getText().toString();
//            }
//            String userPassword = ((EditText) findViewById(R.id.loginActivityPasswordEditText)).getText().toString();
//            Amplify.Auth.signIn(
//                    userEmail,
//                    userPassword,
//                    success -> Log.i(TAG, "Successfully Logged In User: " + userEmail),
//                    failure -> Log.i(TAG, "Failed to login user: " + userEmail + "with error code:" + failure)
//            );
//            Intent goToMainActivityIntent = new Intent(this, MainActivity.class);
//            startActivity(goToMainActivityIntent);
//        });
//    }
//}