package edu.iu.habahram.remotecontroller.model;

public class StereoOnCommand implements Command {
    Stereo stereo;

    public StereoOnCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public String execute() {
        return stereo.on();
    }

    @Override
    public String undo() {
        return stereo.off();
    }
}
