package com.example.event_app.event.basic;

import org.springframework.stereotype.Service;

@Service
public class BasicEventService {
    private final BasicEventRepository basicEventRepository;

    public BasicEventService(BasicEventRepository basicEventRepository) {
        this.basicEventRepository = basicEventRepository;
    }

    public void save(BasicEvent event) {
        basicEventRepository.save(event);
    }


    public Iterable<BasicEvent> findAll() {
        return basicEventRepository.findAll();
    }

    public void delete(Long id){
        basicEventRepository.deleteById(id);
    }

    public void update(BasicEvent event) {
        basicEventRepository.save(event);
    }

    public BasicEvent findById(Long id) {
        return basicEventRepository.findById(id).orElse(null);
    }
}

