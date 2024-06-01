package com.example.event_app.event.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicEventRepository extends JpaRepository<BasicEvent, Long> {
}