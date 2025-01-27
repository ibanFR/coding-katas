package com.ibanfr.liftbutton;

public class Lift {

    private boolean light;
    private LiftDoorStatus doorStatus;

    public void pressButton() {
        if (doorStatus == LiftDoorStatus.OPEN) {
            return;
        }
        light = true;
    }

    public void closeDoors() {
        this.doorStatus = LiftDoorStatus.CLOSED;
    }

    public boolean lights() {
        return light;
    }

    public void arrived() {
        openDoors();
        light = false;
    }

    private void openDoors() {
        this.doorStatus = LiftDoorStatus.OPEN;
    }

    public LiftDoorStatus doors() {
        return doorStatus;
    }
}
