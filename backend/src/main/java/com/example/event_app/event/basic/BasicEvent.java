package com.example.event_app.event.basic;

import com.example.event_app.event.Event;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "basic_event")
public class BasicEvent extends Event {

}
