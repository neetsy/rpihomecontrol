package com.piddamsetty.rpihomecontrol;

import com.piddamsetty.rpihomecontrol.services.FileServices;
import com.piddamsetty.rpihomecontrol.services.RpiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rewatiraman.
 */
@RestController
public class WebPoint {

    FileServices fileServices;
    RpiService rpiService;
    String indexPage;

    @RequestMapping("/")
    public String root() {
        if(indexPage != null) {
            initialize();
        }
        return indexPage;
    }

    @RequestMapping("/light1on")
    public String pin1on() {
       rpiService.turnOnPin1();
       return root();
    }

    @RequestMapping("/light1off")
    public String pin1off() {
        rpiService.turnOffPin1();
        return root();
    }

    private void initialize() {
        try {
            this.fileServices = new FileServices();
            this.rpiService = new RpiService();
            indexPage = fileServices.resourceFileRead("index.html");
        } catch (Exception e) {
            System.out.println("Unable to initialize WebPoint. Exception: "+e.getMessage());
        }
    }

}
