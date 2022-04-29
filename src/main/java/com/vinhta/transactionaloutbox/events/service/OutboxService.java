package com.vinhta.transactionaloutbox.events.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vinhta.transactionaloutbox.events.model.OutboxEvent;
import com.vinhta.transactionaloutbox.events.repository.OutboxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class OutboxService {

    private final OutboxRepository outboxRepository;
    private final ObjectMapper objectMapper;

    public <T> void addEvent(Map<String, Object> headers, T body) {
        outboxRepository.save(
                OutboxEvent.builder()
                        .headers(headers)
                        .payload(jsonStringify(body))
                        .build()
        );
    }

    private String jsonStringify(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException exception) {
            throw new RuntimeException("Payload object failed to be converted to String.");
        }
    }
}
