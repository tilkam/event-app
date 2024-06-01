package com.example.event_app.event.basic;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class BasicEventController {
    private final BasicEventService basicEventService;

    public BasicEventController(BasicEventService basicEventService) {
        this.basicEventService = basicEventService;
    }
    @GetMapping("/event/all")
    public List<BasicEvent> getAllBasicEvents() {
        Iterable<BasicEvent> event = basicEventService.findAll();
        return (List<BasicEvent>) event;
    }

    @PostMapping("/event/create")
    public ResponseEntity<String> createEvent(@RequestBody BasicEvent event) {
        basicEventService.save(event);
        return ResponseEntity.ok("Event created");
    }
    @DeleteMapping("/event/delete/{id}")
    @CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.DELETE})
    public ResponseEntity<String> deleteEvent(@PathVariable Long id){
        basicEventService.delete(id);
        return ResponseEntity.ok("Event deleted");
    }
}
