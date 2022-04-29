package com.vinhta.transactionaloutbox.events.dto;

import com.vinhta.transactionaloutbox.model.Book;

public record BookEventBody(String isbn) {

    public static BookEventBody from(Book book) {
        return new BookEventBody(book.getIsbn());
    }

    public static BookEventBody from(String isbn) {
        return new BookEventBody(isbn);
    }

}
