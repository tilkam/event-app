package com.example.event_app.event;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }


    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }
}
