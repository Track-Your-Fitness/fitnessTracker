package com.example.fitnessTracker.activities.adapter;


import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessTracker.R;
import com.example.fitnessTracker.activities.UserWorkout.UserWorkoutActivity;
import com.example.fitnessTracker.activities.model.WorkOut;

import java.util.List;

public class WorkOutRecyclerViewAdapter extends RecyclerView.Adapter <WorkOutRecyclerViewAdapter.WorkoutViewHolder>{
    public static final String TAG = "workout_recycler_view";
    public static final String WORKOUT_NAME_TAG = "workout_name";
    public static final String WORKOUT_BODY_PART_TAG = "workout_body_part";
    public static final String WORKOUT_EQUIPMENT_TAG = "workout_equipment";
    public static final String WORKOUT_IMAGE_TAG = "workout_image";
    Context callingActivity;
    List<WorkOut> workOutList;
    public WorkOutRecyclerViewAdapter(List<WorkOut> workOutList, Context callingActivity) {
        this.workOutList = workOutList;
        this.callingActivity = callingActivity;
    }

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View workOutFragment = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_excercise, parent, false);
        return new WorkoutViewHolder(workOutFragment);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {
        TextView workOutNameView = holder.itemView.findViewById(R.id.ExerciseFragTVName);
        TextView workOutBodyPartView = holder.itemView.findViewById(R.id.ExerciseFragTVBodyPart);
        TextView workOutEquipmentUsedView = holder.itemView.findViewById(R.id.ExerciseFragTVEquipmentUsed);
        ImageView workOutImageview = holder.itemView.findViewById(R.id.ExerciseFragImageView);
        String workOutName = workOutList.get(position).getName();
        String workOutBodyPart = workOutList.get(position).getBodyPart();
        String workOutEquipment = workOutList.get(position).getEquipmentUsed();
        //may need to import string to workout image and allow the image to be whichever one is chosen.
        String  workOutImage = workOutList.get(position).getImage();
        workOutNameView.setText(position + ". " + workOutName);
        workOutBodyPartView.setText(position + ". " + workOutBodyPart);
        workOutEquipmentUsedView.setText(position + ". " + workOutEquipment);
        workOutImageview.setImageURI(Uri.parse(workOutImage));
        View workOutViewHolder = holder.itemView;
        workOutViewHolder.setOnClickListener(v->{
            Intent goToUserWorkoutActivityIntent = new Intent(callingActivity, UserWorkoutActivity.class);
            goToUserWorkoutActivityIntent.putExtra(WORKOUT_NAME_TAG, workOutName);
            goToUserWorkoutActivityIntent.putExtra(WORKOUT_BODY_PART_TAG, workOutBodyPart);
            goToUserWorkoutActivityIntent.putExtra(WORKOUT_EQUIPMENT_TAG, workOutEquipment);
            goToUserWorkoutActivityIntent.putExtra(WORKOUT_IMAGE_TAG, workOutImage);
            callingActivity.startActivity(goToUserWorkoutActivityIntent);
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class WorkoutViewHolder extends RecyclerView.ViewHolder{

        public WorkoutViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
