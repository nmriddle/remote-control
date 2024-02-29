package edu.iu.habahram.remotecontroller.repository;

import edu.iu.habahram.remotecontroller.model.*;

import java.util.HashMap;
import java.util.List;

public class RemoteLoader implements IRemoteLoader {

    public volatile static RemoteLoader uniqueRemoteLoader;
    HashMap<Integer, RemoteControl> remoteControls = new HashMap<>();

    private RemoteLoader() {
    }

    public static RemoteLoader getInstance() {
        if (uniqueRemoteLoader == null) {
            synchronized (RemoteLoader.class) {
                if (uniqueRemoteLoader == null) {
                    uniqueRemoteLoader = new RemoteLoader();
                }
            }
        }
        return uniqueRemoteLoader;
    }

    @Override
    public void setup(int id, List<DeviceData> devices) {
        RemoteControl remoteControl = new RemoteControl(devices.size());
        for (DeviceData device : devices) {
            switch (device.type()) {
                case "light":
                    Light light = new Light(device.location());
                    remoteControl.setCommand(device.slot(), new Command() {
                        @Override
                        public String execute() {
                            return light.on();
                        }

                        @Override
                        public String undo() {
                            return light.off();
                        }
                    }, new Command() {
                        @Override
                        public String execute() {
                            return light.off();
                        }

                        @Override
                        public String undo() {
                            return light.on();
                        }
                    });
                    break;
                case "stereo":
                    Stereo stereo = new Stereo(device.location());
                    remoteControl.setCommand(device.slot(), new StereoOnCommand(stereo), new StereoOffCommand(stereo));
                    break;
                case "fan":
                    CeilingFan fan = new CeilingFan("high", device.location());
                    remoteControl.setCommand(device.slot(), new CeilingFanHighCommand(), new Command() {
                        @Override
                        public String execute() {
                            return fan.off();
                        }

                        @Override
                        public String undo() {
                            return fan.high();
                        }
                    });
            }
        }
        remoteControls.put(id, remoteControl);
        System.out.println(remoteControl.toString());
    }

    @Override
    public String onButtonWasPushed(int id, int slot) {
        return remoteControls.get(id).onButtonWasPushed(slot);
    }

    @Override
    public String offButtonWasPushed(int id, int slot) {
        return remoteControls.get(id).offButtonWasPushed(slot);

    }

    @Override
    public String undoButtonWasPushed(int id, int slot) {
        return remoteControls.get(id).undoButtonWasPushed(slot);

    }
}
