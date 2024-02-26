package edu.iu.habahram.remotecontroller.model;

public class Stereo {
    String location = "";

    public String on() {

        return location + "is on";
    }

    public String off() {
        return location + "off";
    }

    public String setCd() {
        return location + " playing OK Computer";
    }

    public String setDvd() {
        return location + " watching Shrek 2";
    }

    public String setRadio() {
        return location + " listening Coldplay";
    }

    public String setVolume(int volume) {
        return location + volume;
    }
}
