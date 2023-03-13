package com.example.fitnessTracker.activities.UserWorkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import com.example.fitnessTracker.R;


public class WorkOutCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out_category);

        intentButtons();
    }


    public void intentButtons(){
        ImageView backToMainIntentButton = (ImageView) findViewById(R.id.WorkOutCategoryBackButton);
        backToMainIntentButton.setOnClickListener(v -> {
            Intent goToMainIntent = new Intent(this, MainActivity.class);
            startActivity(goToMainIntent);
        });
    }
}