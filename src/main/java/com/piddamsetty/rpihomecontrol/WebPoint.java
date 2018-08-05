package com.piddamsetty.rpihomecontrol;

import com.piddamsetty.rpihomecontrol.services.FileServices;
import com.piddamsetty.rpihomecontrol.services.RpiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        if(indexPage == null) {
            initialize();
        }
        return indexPage;
    }

    @RequestMapping("/light1on")
    public void pin1on(HttpServletResponse response) throws IOException {
       rpiService.turnOnPin1();
        response.sendRedirect("/");
    }

    @RequestMapping("/light1off")
    public void pin1off(HttpServletResponse response) throws IOException {
        rpiService.turnOffPin1();
        response.sendRedirect("/");
    }

    @RequestMapping("/light1blink")
    public void pin1blink(HttpServletResponse response) throws IOException {
        rpiService.blinkPin1(100L);
        response.sendRedirect("/");
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
