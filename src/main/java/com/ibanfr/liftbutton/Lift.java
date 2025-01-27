package com.ibanfr.liftbutton;

public class Lift {

    private LiftLampStatus liftLampStatus;
    private LiftDoorStatus doorStatus;

    public void closeDoors() {
        this.doorStatus = LiftDoorStatus.CLOSED;
    }

    public void pressButton() {
        if (doorStatus == LiftDoorStatus.OPEN) {
            return;
        }
        liftLampStatus = LiftLampStatus.ON;
    }

    public void arrived() {
        doorStatus = LiftDoorStatus.OPEN;
        liftLampStatus = LiftLampStatus.OFF;
    }

    public LiftLampStatus lights() {
        return liftLampStatus;
    }

    public LiftDoorStatus doors() {
        return doorStatus;
    }
}
