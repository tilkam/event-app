package com.example.event_app.event.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BasicEventController {
    @Autowired
    private BasicEventService basicEventService;

    public BasicEventController(BasicEventService basicEventService) {
        this.basicEventService = basicEventService;
    }
    @GetMapping("/event/all")
    public List<BasicEvent> getBasicEventService() {
        System.out.println("Getting all events");
        Iterable<BasicEvent> event = basicEventService.findAll();
        return (List<BasicEvent>) event;
    }

    @PostMapping("/event/create")
    public ResponseEntity<String> createEvent(@RequestBody BasicEvent event) {
        basicEventService.save(event);
        return ResponseEntity.ok("Event created");
    }

}
