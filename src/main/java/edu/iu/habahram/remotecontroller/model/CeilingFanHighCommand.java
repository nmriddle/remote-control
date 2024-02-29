package edu.iu.habahram.remotecontroller.model;

public class CeilingFanHighCommand implements Command {
    CeilingFan ceilingFan;

    @Override
    public String execute() {
        return ceilingFan.high();
    }

    @Override
    public String undo() {
        return null;
    }
}
