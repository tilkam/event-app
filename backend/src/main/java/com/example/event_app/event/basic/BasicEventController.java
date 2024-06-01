package com.example.event_app.event.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class BasicEventController {
    @Autowired
    private BasicEventService basicEventService;

    public BasicEventController(BasicEventService basicEventService) {
        this.basicEventService = basicEventService;
    }
    @GetMapping("/event/all")
    public List<BasicEvent> getBasicAllEvents() {
        Iterable<BasicEvent> event = basicEventService.findAll();
        return (List<BasicEvent>) event;
    }

    @PostMapping("/event/create")
    public ResponseEntity<String> createEvent(@RequestBody BasicEvent event) {
        basicEventService.save(event);
        return ResponseEntity.ok("Event created");
    }
    @DeleteMapping("/event/delete/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id){
        basicEventService.delete(id);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");

        return ResponseEntity.ok().headers(responseHeaders).body("Event deleted");
    }
}
