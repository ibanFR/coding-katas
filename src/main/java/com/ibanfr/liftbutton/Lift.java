package com.ibanfr.liftbutton;

public class Lift {

    private boolean light;

    public void pressButton() {
        // Do nothing
        light = true;
    }

    public boolean lights() {
        return light;
    }

    public void doorsOpened() {
        light = false;
    }
}
