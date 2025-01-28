package com.ibanfr.liftbutton;

public class Lift {

    private LampStatus liftLampStatus;
    private DoorStatus doorStatus;

    public void closeDoors() {
        this.doorStatus = DoorStatus.CLOSED;
    }

    public void pressButton() {
        if (doorStatus == DoorStatus.OPEN) {
            return;
        }
        liftLampStatus = LampStatus.ON;
    }

    public void arrived() {
        doorStatus = DoorStatus.OPEN;
        liftLampStatus = LampStatus.OFF;
    }

    public LampStatus lights() {
        return liftLampStatus;
    }

    public DoorStatus doors() {
        return doorStatus;
    }
}
