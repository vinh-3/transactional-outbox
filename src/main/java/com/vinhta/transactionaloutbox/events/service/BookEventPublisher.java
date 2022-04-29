package com.vinhta.transactionaloutbox.events.service;

import com.vinhta.transactionaloutbox.events.dto.BookEventBody;
import com.vinhta.transactionaloutbox.events.dto.EventType;
import com.vinhta.transactionaloutbox.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class BookEventPublisher {

    private final OutboxService outboxService;

    private void publishReadEvent(Book book) {
            Map<String, Object> headers = getHeaders(EventType.READ);
            BookEventBody eventBody = BookEventBody.from(book);

            outboxService.addEvent(headers, eventBody);
    }

    private void publishSaveEvent(Book book) {
        Map<String, Object> headers = getHeaders(EventType.SAVE);
        BookEventBody eventBody = BookEventBody.from(book);

        outboxService.addEvent(headers, eventBody);
    }

    private void publishDeleteEvent(String isbn) {
        Map<String, Object> headers = getHeaders(EventType.DELETE);
        BookEventBody eventBody = BookEventBody.from(isbn);

        outboxService.addEvent(headers, eventBody);
    }

    private Map<String, Object> getHeaders(EventType eventType) {
        return Map.of("EventType", eventType.name());
    }

}
