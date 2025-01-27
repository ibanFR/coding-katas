package com.ibanfr.liftbutton;

public class Lift {

    private boolean light;
    private LiftDoorStatus doorStatus;

    public void pressButton() {
        closeDoors();
        light = true;
    }

    private void closeDoors() {
        this.doorStatus = LiftDoorStatus.CLOSED;
    }

    public boolean lights() {
        return light;
    }

    public void doorsOpened() {
        light = false;
    }

    public LiftDoorStatus doors() {
        return doorStatus;
    }
}
