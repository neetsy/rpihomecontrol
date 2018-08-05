package com.piddamsetty.rpihomecontrol.services;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 * Created by praneet on 8/4/18.
 */
public class RpiService {
    final GpioController gpio = GpioFactory.getInstance();

    public void turnOnPin1(){
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.HIGH);

    }

    public void turnOffPin1() {
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);
    }


}
