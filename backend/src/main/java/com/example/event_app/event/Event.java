package com.example.event_app.event;

import jakarta.persistence.*;

import java.sql.Date;

@MappedSuperclass
public abstract class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

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


    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }
}
