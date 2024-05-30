package com.example.event_app.event.basic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicEventRepository extends JpaRepository<BasicEvent, Long> {
}