package com.example.fitnessTracker.activities.UserWorkout;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fitnessTracker.R;
import com.example.fitnessTracker.activities.adapter.WorkOutRecyclerViewAdapter;
import com.example.fitnessTracker.activities.Activities.MainActivity;
import com.example.fitnessTracker.activities.Activities.UserProfileActivity;
import com.example.fitnessTracker.activities.Activities.UserSettingsActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;



public class UserWorkoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_workout);

        consumeExtras();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_userworkout);

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
                    return true;

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
    }

    public void consumeExtras(){
        Intent callingIntent = getIntent();
        String workoutName = null;
        String workoutBodyPart = null;
        String workoutEquipment = null;
        String workoutImage = null;
            if (callingIntent !=null){
                workoutName = callingIntent.getStringExtra(WorkOutRecyclerViewAdapter.WORKOUT_NAME_TAG);
                workoutBodyPart = callingIntent.getStringExtra(WorkOutRecyclerViewAdapter.WORKOUT_BODY_PART_TAG);
                workoutEquipment = callingIntent.getStringExtra(WorkOutRecyclerViewAdapter.WORKOUT_EQUIPMENT_TAG);
                workoutImage = callingIntent.getStringExtra(WorkOutRecyclerViewAdapter.WORKOUT_IMAGE_TAG);
            }
        ((TextView)findViewById(R.id.UserWorkoutWorkoutNameTV)).setText(workoutName);
        ((TextView)findViewById(R.id.UserWorkoutBodyPartTV)).setText(workoutBodyPart);
        ((TextView)findViewById(R.id.UserWorkOutEquipmentTV)).setText(workoutEquipment);
//        ((ImageView)findViewById(R.id.UserWorkOutImageTV)).setImageURI(workoutImage);
    }

}