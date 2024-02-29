package edu.iu.habahram.remotecontroller.model;

public class CeilingFan {

    String location = "";
    String speed;

    public CeilingFan(String speed, String location) {
        this.speed = speed;
        this.location = location;
    }

    public String high() {
        return location + " is on high\n";
    }

    public String medium() {
        return location + " is on medium\n";
    }

    public String low() {
        return location + " is on low\n";
    }

    public String off() {
        return location + " is off\n";
    }

    public String getSpeed() {
        return speed;
    }
}
