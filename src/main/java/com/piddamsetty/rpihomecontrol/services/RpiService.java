package com.piddamsetty.rpihomecontrol.services;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

import java.util.concurrent.TimeUnit;

/**
 * Created by praneet on 8/4/18.
 */
public class RpiService {
    final GpioController gpio = GpioFactory.getInstance();

    GpioPinDigitalOutput pin1;

    public RpiService() {
        try {
            pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07);
        } catch (Exception e) {
            System.out.println("Cannot create led 1. Exception: "+e.getMessage());
        }
    }

    public void turnOnPin1(){
        try {
            pin1.high();
        } catch (Exception e) {
            System.out.println("Cannot turn on led 1. Exception: "+e.getMessage());
        }

    }

    public void turnOffPin1() {
        try {
           pin1.low();
        } catch (Exception e) {
            System.out.println("Cannot turn off led 1. Exception: "+e.getMessage());
        }
    }

    public void blinkPin1(Long delay) {
        try {
            pin1.blink(delay);
        } catch (Exception e) {
            System.out.println("Cannot turn off led 1. Exception: "+e.getMessage());
        }
    }

    public void openOrCloseDoor() {
        try {
            pin1.low();
            System.out.println(System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(5);
            pin1.high();

        } catch (Exception e) {
            System.out.println("Cannot turn off led 1. Exception: " + e.getMessage());
        }

    }
}
