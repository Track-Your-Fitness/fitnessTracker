package com.example.fitnessTracker.activities.UserWorkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import com.example.fitnessTracker.R;

import com.example.fitnessTracker.activities.Activities.MainActivity;
import com.example.fitnessTracker.activities.Activities.UserProfileActivity;
import com.example.fitnessTracker.activities.Activities.UserSettingsActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class WorkOutCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out_category);

        intentButtons();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_workOutCategory);

        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.bottom_home:
                    startActivity(new Intent(getApplicationContext(), MainActivity.class ));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;

                case R.id.bottom_userPage:
                    startActivity(new Intent(getApplicationContext(), UserProfileActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;

                case R.id.bottom_userworkout:
                    startActivity(new Intent(getApplicationContext(), UserWorkoutActivity.class ));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;

                case R.id.bottom_workOutCategory:
                    return true;

                case R.id.bottom_settings:
                    startActivity(new Intent(getApplicationContext(), UserSettingsActivity.class ));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
            }
            return false;
        });

    }


    public void intentButtons() {
        Button selectedCategoryIntentButton = (Button) findViewById(R.id.GoToSelectedCategoryButton);
        selectedCategoryIntentButton.setOnClickListener(v -> {
            Intent goToSelectedCategoryIntent = new Intent(this, SelectedCategoryActivity.class);
            startActivity(goToSelectedCategoryIntent);
        });
    }
}