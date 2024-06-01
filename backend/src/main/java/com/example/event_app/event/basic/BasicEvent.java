package com.example.event_app.event.basic;

import com.example.event_app.event.Event;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "basic_event")
public class BasicEvent extends Event {
  public void createBasicEvent(String name, String startDate, String endDate, String location, String description) {
    this.setName(name);
    this.setStartDate(Date.valueOf(startDate));
    this.setEndDate(Date.valueOf(endDate));
    this.setLocation(location);
    this.setDescription(description);
  }
}
