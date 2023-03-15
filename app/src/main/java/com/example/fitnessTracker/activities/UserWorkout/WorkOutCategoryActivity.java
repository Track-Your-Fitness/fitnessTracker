package com.example.fitnessTracker.activities.UserWorkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import com.example.fitnessTracker.R;

import com.example.fitnessTracker.activities.Activities.MainActivity;



public class WorkOutCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out_category);

        intentButtons();
    }


    public void intentButtons() {
        Button selectedCategoryIntentButton = (Button) findViewById(R.id.GoToSelectedCategoryButton);
        selectedCategoryIntentButton.setOnClickListener(v -> {
            Intent goToSelectedCategoryIntent = new Intent(this, SelectedCategoryActivity.class);
            startActivity(goToSelectedCategoryIntent);
        });
    }
}