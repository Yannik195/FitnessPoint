package de.yanniksimon.fitnesspoint.Objects;

public class Set {

    private String bodyPart;
    private String exercise;
    private double weight;
    private int reps;


    public Set(String bodyPart, String exercise, double weight, int reps){
        this.bodyPart = bodyPart;
        this.exercise = exercise;
        this.weight = weight;
        this.reps = reps;

    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }
}
