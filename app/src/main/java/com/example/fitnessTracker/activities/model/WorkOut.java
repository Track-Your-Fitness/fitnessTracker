package com.example.fitnessTracker.activities.model;

import android.media.Image;

public class WorkOut {
    private String id;
    private String name;
    private String bodyPart;
    private String muscleTarget;
    private String equipmentUsed;
    private Image image;

    public WorkOut(String id, String name, String bodyPart, String muscleTarget, String equipmentUsed, Image image){
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}