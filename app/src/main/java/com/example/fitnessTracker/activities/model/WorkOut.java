package com.example.fitnessTracker.activities.model;

import android.media.Image;

public class WorkOut {
    private String id;
    private String name;
    private String bodyPart;
    private String muscleTarget;
    private String equipmentUsed;
    private String  image;

    public WorkOut(String id, String name, String bodyPart, String muscleTarget, String equipmentUsed, String image){
        this.id = id;
        this.name = name;
        this.bodyPart = bodyPart;
        this.muscleTarget = muscleTarget;
        this.equipmentUsed = equipmentUsed;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public String getMuscleTarget() {
        return muscleTarget;
    }

    public void setMuscleTarget(String muscleTarget) {
        this.muscleTarget = muscleTarget;
    }

    public String getEquipmentUsed() {
        return equipmentUsed;
    }

    public void setEquipmentUsed(String equipmentUsed) {
        this.equipmentUsed = equipmentUsed;
    }

    public String  getImage() {
        return image;
    }

    public void setImage(String  image) {
        this.image = image;
    }
}
