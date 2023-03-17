package com.example.fitnessTracker.activities.Activities;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import com.example.fitnessTracker.R;
import com.example.fitnessTracker.activities.UserWorkout.SelectedCategoryActivity;
import com.example.fitnessTracker.activities.UserWorkout.SelectedWorkoutActivity;
import com.example.fitnessTracker.activities.UserWorkout.UserWorkoutActivity;
import com.example.fitnessTracker.activities.UserWorkout.WorkOutCategoryActivity;
//package com.example.testrapidapi;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.io.IOException;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonArrayRequest;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    public final String TAG ="main_activity";
    public static final String USER_INPUT_EXTRA_TAG = "userInput";
    public static final String USER_USERNAME_TAG = "userName";

//    Spinner bodyPartSpinner;
//    Spinner equipmentUsedSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        bodyPartSpinner = findViewById(R.id.MainSpinnerBodyPart);
//        equipmentUsedSpinner = findViewById(R.id.MainSpinnerEquipmentUsed);


        setupWorkoutButtons();
        intentButtons();


        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        ImageView settingsButton = (ImageView) findViewById(R.id.MainActivitySettingsImg);
        settingsButton.setOnClickListener(v -> {
//            String userInput = ((EditText)findViewById(R.id.)).getText().toString();
            Intent goToUserSettingsIntent = new Intent(this, UserSettingsActivity.class);
//            goToUserSettingsIntent.putExtra(, userInput);
            startActivity(goToUserSettingsIntent);
        });

    }

    public void setUpSpinners (){
//        bodyPartSpinner.setAdapter(new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_spinner_item,
//
//        ));
    }


    /**
     * Method that will use rapidapi to get content. log.d will show what is being extracted when running program.
     * @throws NullPointerException if url is null.
     */


    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String userName = preferences.getString(USER_USERNAME_TAG, "no username");
        ((TextView)findViewById(R.id.MainUsernameDisplay)).setText(userName);
    }

//    public void apiSubmitButton (){
//        Button submitWorkoutSelectionButton = (Button) findViewById(R.id.MainButtonSubmit);
//        submitWorkoutSelectionButton.setOnClickListener(v -> {
//            Intent goToSelectedWorkoutIntent = new Intent(this, SelectedWorkoutActivity.class);
//            startActivity(goToSelectedWorkoutIntent);
//        });
//    }

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


public void intentButtons() {

    ImageView userProfileButton = (ImageView) findViewById(R.id.MainActivityUserProfileBtn);
    userProfileButton.setOnClickListener(v -> {
        Intent goToUserProfileIntent = new Intent(this, UserProfileActivity.class);
        startActivity(goToUserProfileIntent);
    });
    ImageView selectWorkoutButton = (ImageView) findViewById(R.id.SelectWorkoutButton);
    selectWorkoutButton.setOnClickListener(v -> {
        Intent goToSelectWorkoutIntent = new Intent(this, WorkOutCategoryActivity.class);
        startActivity(goToSelectWorkoutIntent);
    });
    ImageView userPastWorkoutsButton = (ImageView) findViewById(R.id.MainActivityYourWorkoutBttn);
    userPastWorkoutsButton.setOnClickListener(v -> {
        Intent goToUserWorkoutIntent = new Intent(this, UserWorkoutActivity.class);
        startActivity(goToUserWorkoutIntent);
    });
    ImageView userSettingsButton = (ImageView) findViewById(R.id.MainActivitySettingsImg);
    userSettingsButton.setOnClickListener(v -> {
        Intent goToUserSettingsIntent = new Intent(this, UserSettingsActivity.class);
        startActivity(goToUserSettingsIntent);
    });

}}

