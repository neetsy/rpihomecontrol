package com.piddamsetty.rpihomecontrol;

import com.piddamsetty.rpihomecontrol.services.RpiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rewatiraman.
 */
@RestController
public class WebPoint {

    RpiService rpiService = new RpiService();

    @RequestMapping("/")
    public String root() {
        System.out.println("New request for home");
        String content = "index.html";
        return content;
    }

    @RequestMapping("/light1on")
    public void pin1on() {
       rpiService.turnOnPin1();
    }

}
