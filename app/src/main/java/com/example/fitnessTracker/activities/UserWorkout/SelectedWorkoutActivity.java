package com.example.fitnessTracker.activities.UserWorkout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fitnessTracker.R;
import com.example.fitnessTracker.activities.adapter.WorkOutRecyclerViewAdapter;
import com.example.fitnessTracker.activities.model.WorkOut;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


public class SelectedWorkoutActivity extends AppCompatActivity {
    public ArrayList<String> workoutName;
    public ArrayList<String> workoutBodyPart;
    public ArrayList<String> workoutEquipment;
    public ArrayList<String> workoutImage;
    Uri myUri = Uri.parse("http://stackoverflow.com");
    public static String workoutTypeString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_workout);
        recyclerView();
        consumeExtras();
    }

    public void consumeExtras(){
        Intent callingIntent = getIntent();
        workoutTypeString = callingIntent.getStringExtra(workoutTypeString);
        workoutName = new ArrayList<>();
        workoutBodyPart = new ArrayList<>();
        workoutEquipment = new ArrayList<>();
        workoutImage = new ArrayList<>();
        if (callingIntent !=null){
            workoutName = callingIntent.getStringArrayListExtra(WorkOutRecyclerViewAdapter.WORKOUT_NAME_TAG);
            workoutBodyPart = callingIntent.getStringArrayListExtra(WorkOutRecyclerViewAdapter.WORKOUT_BODY_PART_TAG);
            workoutEquipment = callingIntent.getStringArrayListExtra(WorkOutRecyclerViewAdapter.WORKOUT_EQUIPMENT_TAG);
            workoutImage = callingIntent.getStringArrayListExtra(WorkOutRecyclerViewAdapter.WORKOUT_IMAGE_TAG);
        }
//        ((TextView) findViewById(R.id.ExerciseFragTVName)).setText((CharSequence) workoutName);
//        ((TextView)findViewById(R.id.ExerciseFragTVBodyPart)).setText((CharSequence) workoutBodyPart);
//        ((TextView)findViewById(R.id.ExerciseFragTVEquipmentUsed)).setText((CharSequence) workoutEquipment);
//        ((ImageView)findViewById(R.id.UserWorkOutImageTV)).setImageURI(URI);
    }

    public void recyclerView(){

        List<WorkOut> workOutList = new ArrayList<>();
        WorkOut workOut = new WorkOut("877", "Exercise: Straight Arm Lat Pulldown", "Target: Back", "Muscle Target: Latissimus Dorsi", "Equipment Needed: Lat Bar w/Cable", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQv5IZLWJtFdrMVq70yPbZh3JGdc0QBkfWFIA&usqp=CAU");
        WorkOut workOut1 = new WorkOut("421", "Exercise: Cable upper row", "Target: back", "Muscle Target: Upper-back", "Equipment Needed: Cable", "d");
        WorkOut workOut2 = new WorkOut("76", "Exercise: Band shrug", "Target: Back", "Muscle Target: Traps", "Equipment Needed: Resistance Band", "");
        WorkOut workOut3 = new WorkOut("869", "jump rope", "cardio", "cardiovascular-system", "rope", "");
        WorkOut workOut4 = new WorkOut("1027", "mountain climber", "cardio", "cardiovascular-system", "body-weight", "");
        WorkOut workOut5 = new WorkOut("1245", "star jump (male)", "cardio", "cardiovascular-system", "body-weight", "");
        WorkOut workOut6 = new WorkOut("920", "korean dips", "chest", "pectorals", "body-weight", "");
        WorkOut workOut7 = new WorkOut("981", "lever seated fly", "chest", "pectorals", "leverage-machine", "");
        WorkOut workOut8 = new WorkOut("732", "dumbbell straight arm pullover", "chest", "pectorals", "dumbbell", "");
        WorkOut workOut9 = new WorkOut("797", "finger curls", "lower-arms", "forearms", "barbell", "");
        WorkOut workOut10 = new WorkOut("388", "cable standing back wrist curl", "lower-arms", "forearms", "cable", "");
        WorkOut workOut11 = new WorkOut("680", "dumbbell seated one arm rotate", "lower-arms", "forearms", "dumbbell", "");
        WorkOut workOut12 = new WorkOut("1237", "standing calf raise (on a staircase)", "lower-legs", "calves", "body-weight", "");
        WorkOut workOut13 = new WorkOut("1054", "posterior tibialis stretch", "lower-legs", "calves", "rope", "");
        WorkOut workOut14 = new WorkOut("461", "donkey calf raise", "lower-legs", "calves", "body-weight", "");
        WorkOut workOut15 = new WorkOut("1031", "neck side stretch", "neck", "levator-scapulae", "body-weight", "");
        WorkOut workOut16 = new WorkOut("1143", "side push neck stretch", "neck", "levator-scapulae", "body-weight", "");
        WorkOut workOut17 = new WorkOut("658", "dumbbell rotation reverse fly", "shoulders", "delts", "dumbbell", "");
        WorkOut workOut18 = new WorkOut("279", "cable cross-over revers fly", "shoulders", "delts", "cable", "");
        WorkOut workOut19 = new WorkOut("554", "dumbbell lateral raise", "shoulders", "delts", "dumbell", "");
        WorkOut workOut20 = new WorkOut("399", "cable standing pulldown (with rope)", "upper-arms", "biceps", "cable", "");
        WorkOut workOut21 = new WorkOut("1039", "one arm dip", "upper-arms", "triceps", "biceps", "");
        WorkOut workOut22 = new WorkOut("607", "dumbbell one arm seated hammer curl", "upper-arms", "biceps", "dumbbell", "");
        WorkOut workOut23 = new WorkOut("1057", "power clean", "upper-legs", "hamstring", "barbell", "");
        WorkOut workOut24 = new WorkOut("1142", "side plank hip adduction", "upper-legs", "adductors", "body-weight", "");
        WorkOut workOut25 = new WorkOut("1153", "sissy squat", "upper-legs", "quads", "body-weight", "");
        WorkOut workOut26 = new WorkOut("452", "curl-up", "waist", "abs", "body-weight", "");
        WorkOut workOut27 = new WorkOut("922", "l-sit on floor", "waist", "abs", "body-weight", "");
        WorkOut workOut28 = new WorkOut("302", "cable judo flip", "waist", "abs", "cable", "");
        workOutList.add(workOut);
        workOutList.add(workOut1);
        workOutList.add(workOut2);
        workOutList.add(workOut3);
        workOutList.add(workOut4);
        workOutList.add(workOut5);
        workOutList.add(workOut6);
        workOutList.add(workOut7);
        workOutList.add(workOut8);
        workOutList.add(workOut9);
        workOutList.add(workOut10);
        workOutList.add(workOut11);
        workOutList.add(workOut12);
        workOutList.add(workOut13);
        workOutList.add(workOut14);
        workOutList.add(workOut15);
        workOutList.add(workOut16);
        workOutList.add(workOut17);
        workOutList.add(workOut18);
        workOutList.add(workOut19);
        workOutList.add(workOut20);
        workOutList.add(workOut21);
        workOutList.add(workOut22);
        workOutList.add(workOut23);
        workOutList.add(workOut24);
        workOutList.add(workOut25);
        workOutList.add(workOut26);
        workOutList.add(workOut27);
        workOutList.add(workOut28);


        RecyclerView selectedWorkoutRecyclerView = findViewById(R.id.SelectedWorkoutActivityRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        selectedWorkoutRecyclerView.setLayoutManager(layoutManager);




        WorkOutRecyclerViewAdapter adapter = new WorkOutRecyclerViewAdapter(workOutList, this);
        selectedWorkoutRecyclerView.setAdapter(adapter);
    }

}