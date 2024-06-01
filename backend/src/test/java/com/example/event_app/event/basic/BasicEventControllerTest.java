package com.example.event_app.event.basic;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;


@WebMvcTest(BasicEventController.class)
class BasicEventControllerTest {
    @MockBean
    private BasicEventService basicEventService;
    @Autowired
    private MockMvc mockMvc;
    @Test
    void getAllBasicEvents() throws Exception {
        BasicEvent event = new BasicEvent();
        event.createBasicEvent("name", "2024-06-01", "2024-06-01", "17:00","18.00","location", "description");

        List<BasicEvent> events = Collections.singletonList(event);
        Mockito.when(basicEventService.findAll()).thenReturn(events);

        mockMvc.perform(get("/event/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void createEvent() throws Exception {
        BasicEvent event = new BasicEvent();
        event.createBasicEvent("name", "2024-06-01", "2024-06-01", "17:00","18.00","location", "description");

        mockMvc.perform(post("/event/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(event)))
                .andExpect(status().isOk());

        Mockito.verify(basicEventService, Mockito.times(1)).save(ArgumentMatchers.any(BasicEvent.class));
    }

    @Test
    void deleteEvent() throws Exception {
        Long id = 1L;

        mockMvc.perform(delete("/event/delete/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Mockito.verify(basicEventService, Mockito.times(1)).delete(id);
    }
}