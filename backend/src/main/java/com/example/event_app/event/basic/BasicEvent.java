package com.example.event_app.event.basic;

import com.example.event_app.event.Event;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "basic_event")
public class BasicEvent extends Event {
  /**
   * Create a basic event - for testing purposes
   * @param name name of the event
   * @param startDate start date of the event
   * @param endDate end date of the event
   * @param startTime start time of the event
   * @param endTime  end time of the event
   * @param location  location of the event
   * @param description description of the event
   */
  public void createBasicEvent(String name, String startDate, String endDate, String startTime, String endTime, String location, String description) {
    this.setName(name);
    this.setStartDate(Date.valueOf(startDate));
    this.setEndDate(Date.valueOf(endDate));
    this.setLocation(location);
    this.setDescription(description);
    this.setStartTime(startTime);
    this.setEndTime(endTime);
  }
}
