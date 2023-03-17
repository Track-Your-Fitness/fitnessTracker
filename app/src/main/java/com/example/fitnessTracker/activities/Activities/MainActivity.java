package com.example.fitnessTracker.activities.Activities;
import static com.example.fitnessTracker.activities.Activities.UserSettingsActivity.USER_NAME_TAG;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.amplifyframework.auth.AuthUser;
import com.amplifyframework.core.Amplify;
import com.example.fitnessTracker.R;
import com.example.fitnessTracker.activities.AuthActivites.LoginActivity;
import com.example.fitnessTracker.activities.UserWorkout.SelectedCategoryActivity;
import com.example.fitnessTracker.activities.UserWorkout.SelectedWorkoutActivity;
import com.example.fitnessTracker.activities.UserWorkout.UserWorkoutActivity;
import com.example.fitnessTracker.activities.UserWorkout.WorkOutCategoryActivity;
//package com.example.testrapidapi;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;

    AuthUser authUser;
    Button logoutButton;
    //extracts from local.properties, else "".


    public static final String TAG = "mainActivity";
    public static final String USER_INPUT_EXTRA_TAG = "userInput";
    public static final String USER_USERNAME_TAG = "userName";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        logoutButton = findViewById(R.id.logoutButton);
        setupWorkoutButtons();
        intentButtons();




        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        File exampleFile = new File(getApplicationContext().getFilesDir(), "ExampleKey");

//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(exampleFile));
//            writer.append("Example file contents");
//            writer.close();
//        } catch (Exception exception) {
//            Log.e("MyAmplifyApp", "Upload failed", exception);
//        }
//
//        Amplify.Storage.uploadFile(
//                "ExampleKey",
//                exampleFile,
//                success -> Log.i(TAG, "Successfully uploaded: " + success.getKey()),
//                failure -> Log.e(TAG, "Upload failed", failure)
//        );
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);

        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.bottom_home:
                    return true;

                case R.id.bottom_userPage:
                    startActivity(new Intent(getApplicationContext(), UserProfileActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;

//                case R.id.bottom_userworkout:
//                    startActivity(new Intent(getApplicationContext(), UserWorkoutActivity.class ));
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//                    finish();
//                    return true;

                case R.id.bottom_workOutCategory:
                    startActivity(new Intent(getApplicationContext(), WorkOutCategoryActivity.class ));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;

                case R.id.bottom_settings:
                    startActivity(new Intent(getApplicationContext(), UserSettingsActivity.class ));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
            }
            return false;
        });
        setupButtons();

    }



    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String userName = preferences.getString(USER_USERNAME_TAG, "no username");
        ((TextView)findViewById(R.id.MainUsernameDisplay)).setText(userName);
    }


    public void renderButtons() {

        if (authUser != null) {
            logoutButton.setVisibility(View.VISIBLE);
        } else {
            logoutButton.setVisibility(View.INVISIBLE);
        }
    }

        public void intentButtons() {
            final String[] username = {preferences.getString(USER_NAME_TAG, "no username")};
            Amplify.Auth.getCurrentUser(
                    success -> {
                        Log.i(TAG, "Got Current User");
                        username[0] = success.getUsername();
                    },
                    failure -> {
                    }
            );

            logoutButton.setOnClickListener(v -> Amplify.Auth.signOut(
                    success -> {
                        Log.i(TAG, "User successfully logged out.");
                        authUser = null;
                        runOnUiThread(this::renderButtons);
                        Intent goToLoginActivityIntent = new Intent(this, LoginActivity.class);
                        startActivity(goToLoginActivityIntent);
                    }
            ));

        }


//        ImageView userProfileButton = (ImageView) findViewById(R.id.MainActivityUserProfileBtn);
//        userProfileButton.setOnClickListener(v -> {
//            Intent goToUserProfileIntent = new Intent(this, UserProfileActivity.class);
//            startActivity(goToUserProfileIntent);
//        });
//        ImageView selectWorkoutButton = (ImageView) findViewById(R.id.SelectWorkoutButton);
//        selectWorkoutButton.setOnClickListener(v -> {
//            Intent goToSelectWorkoutIntent = new Intent(this, WorkOutCategoryActivity.class);
//            startActivity(goToSelectWorkoutIntent);
//        });
//        ImageView userPastWorkoutsButton = (ImageView) findViewById(R.id.MainActivityYourWorkoutBttn);
//        userPastWorkoutsButton.setOnClickListener(v -> {
//            Intent goToUserWorkoutIntent = new Intent(this, UserWorkoutActivity.class);
//            startActivity(goToUserWorkoutIntent);
//        });
//        ImageView userSettingsButton = (ImageView) findViewById(R.id.MainActivitySettingsImg);
//        userSettingsButton.setOnClickListener(v -> {
//            Intent goToUserSettingsIntent = new Intent(this, UserSettingsActivity.class);
//            startActivity(goToUserSettingsIntent);
//        });
//    }
public void setupButtons() {

    // logout button

}

    public void setupWorkoutButtons(){
        Button cardioButton = this.findViewById(R.id.MainActivityCardioButton);
        Button neckButton = this.findViewById(R.id.MainActivityNeckButton);
        Button chestButton = this.findViewById(R.id.MainActivityChestButton);
        Button backButton = this.findViewById(R.id.MainActivityBackButton);
        Button shouldersButton = this.findViewById(R.id.MainActivityShouldersButton);
        Button upperLegsButton = this.findViewById(R.id.MainActivityUpperLegsButton);
        Button upperArmsButton = this.findViewById(R.id.MainActivityUpperArmsButton);
        Button waistButton = this.findViewById(R.id.MainActivityWaistButton);
        Button lowerLegsButton = this.findViewById(R.id.MainActivityLowerLegsButton);
        Button lowerArmsButton = this.findViewById(R.id.MainActivityLowerArmsButton);

        Button workoutIntentButton = (Button) findViewById(R.id.MainActivityBackButton);
        workoutIntentButton.setOnClickListener(v -> {
            Intent goToWorkoutIntent = new Intent(this, SelectedWorkoutActivity.class);
            startActivity(goToWorkoutIntent);
        });

        cardioButton.setOnClickListener(v->{
            Intent selectedWorkout = new Intent(this, SelectedWorkoutActivity.class);
            selectedWorkout.putExtra(SelectedWorkoutActivity.workoutTypeString, "cardio");
            startActivity(selectedWorkout);
        });

        neckButton.setOnClickListener(v->{
            Intent selectedWorkout = new Intent(this, SelectedWorkoutActivity.class);
            selectedWorkout.putExtra(SelectedWorkoutActivity.workoutTypeString, "neck");
            startActivity(selectedWorkout);
        });

        chestButton.setOnClickListener(v->{
            Intent selectedWorkout = new Intent(this, SelectedWorkoutActivity.class);
            selectedWorkout.putExtra(SelectedWorkoutActivity.workoutTypeString, "chest");
            startActivity(selectedWorkout);
        });

        backButton.setOnClickListener(v->{
            Intent selectedWorkout = new Intent(this, SelectedWorkoutActivity.class);
            selectedWorkout.putExtra(SelectedWorkoutActivity.workoutTypeString, "back");
            startActivity(selectedWorkout);
        });

        shouldersButton.setOnClickListener(v->{
            Intent selectedWorkout = new Intent(this, SelectedWorkoutActivity.class);
            selectedWorkout.putExtra(SelectedWorkoutActivity.workoutTypeString, "shoulders");
            startActivity(selectedWorkout);
        });

        upperLegsButton.setOnClickListener(v->{
            Intent selectedWorkout = new Intent(this, SelectedWorkoutActivity.class);
            selectedWorkout.putExtra(SelectedWorkoutActivity.workoutTypeString, "upper-legs");
            startActivity(selectedWorkout);
        });

        upperArmsButton.setOnClickListener(v->{
            Intent selectedWorkout = new Intent(this, SelectedWorkoutActivity.class);
            selectedWorkout.putExtra(SelectedWorkoutActivity.workoutTypeString, "upper-arms");
            startActivity(selectedWorkout);
        });

        waistButton.setOnClickListener(v->{
            Intent selectedWorkout = new Intent(this, SelectedWorkoutActivity.class);
            selectedWorkout.putExtra(SelectedWorkoutActivity.workoutTypeString, "waist");
            startActivity(selectedWorkout);
        });

        lowerLegsButton.setOnClickListener(v->{
            Intent selectedWorkout = new Intent(this, SelectedWorkoutActivity.class);
            selectedWorkout.putExtra(SelectedWorkoutActivity.workoutTypeString, "lower-legs");
            startActivity(selectedWorkout);
        });

        lowerArmsButton.setOnClickListener(v->{
            Intent selectedWorkout = new Intent(this, SelectedWorkoutActivity.class);
            selectedWorkout.putExtra(SelectedWorkoutActivity.workoutTypeString, "lower-arms");
            startActivity(selectedWorkout);
        });

    }
}


//public void intentButtons() {
//
//    ImageView userProfileButton = (ImageView) findViewById(R.id.MainActivityUserProfileBtn);
//    userProfileButton.setOnClickListener(v -> {
//        Intent goToUserProfileIntent = new Intent(this, UserProfileActivity.class);
//        startActivity(goToUserProfileIntent);
//    });
//    ImageView selectWorkoutButton = (ImageView) findViewById(R.id.SelectWorkoutButton);
//    selectWorkoutButton.setOnClickListener(v -> {
//        Intent goToSelectWorkoutIntent = new Intent(this, WorkOutCategoryActivity.class);
//        startActivity(goToSelectWorkoutIntent);
//    });
//    ImageView userPastWorkoutsButton = (ImageView) findViewById(R.id.MainActivityYourWorkoutBttn);
//    userPastWorkoutsButton.setOnClickListener(v -> {
//        Intent goToUserWorkoutIntent = new Intent(this, UserWorkoutActivity.class);
//        startActivity(goToUserWorkoutIntent);
//    });
//    ImageView userSettingsButton = (ImageView) findViewById(R.id.MainActivitySettingsImg);
//    userSettingsButton.setOnClickListener(v -> {
//        Intent goToUserSettingsIntent = new Intent(this, UserSettingsActivity.class);
//        startActivity(goToUserSettingsIntent);
//    });

//}}






