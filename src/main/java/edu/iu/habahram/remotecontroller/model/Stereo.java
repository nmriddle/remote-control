package edu.iu.habahram.remotecontroller.model;

public class Stereo {
    String location = "";

    public Stereo(String location) {
        this.location = location;
    }

    public String on() {
        return location + " is on\n" + setCd() + setVolume(8);
    }

    public String off() {
        return location + " is off\n";
    }

    public String setCd() {
        return location + " playing OK Computer\n";
    }

    public String setDvd() {
        return location + " watching Shrek 2\n";
    }

    public String setRadio() {
        return location + " listening to Coldplay\n";
    }

    public String setVolume(int volume) {
        return location + " set to " + volume + "\n";
    }
}
