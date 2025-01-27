package com.ibanfr.liftbutton;

public class Lift {

    private boolean light;

    public void pressButton() {
        light = true;
    }

    public boolean lights() {
        return light;
    }

    public void doorsOpened() {
        light = false;
    }

    public LiftDoorStatus doors() {
        return LiftDoorStatus.CLOSED;
    }
}
