package edu.iu.habahram.remotecontroller.model;

public class StereoOffCommand implements Command {
    Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public String execute() {
        return stereo.off();
    }

    @Override
    public String undo() {
        return stereo.on();
    }
}
