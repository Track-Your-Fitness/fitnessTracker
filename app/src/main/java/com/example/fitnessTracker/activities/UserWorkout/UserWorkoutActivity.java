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


public class UserWorkoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_workout);
        consumeExtras();
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