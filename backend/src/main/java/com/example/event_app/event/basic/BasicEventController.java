package com.example.event_app.event.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BasicEventController {
    @Autowired
    private BasicEventRepository basicEventService;

    public BasicEventController(BasicEventRepository basicEventService) {
        this.basicEventService = basicEventService;
    }

    public List<BasicEvent> getBasicEventService() {
        return basicEventService.findAll();
    }
}
