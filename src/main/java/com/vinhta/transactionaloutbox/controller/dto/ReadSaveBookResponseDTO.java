package com.vinhta.transactionaloutbox.controller.dto;

import com.vinhta.transactionaloutbox.model.Book;
import lombok.Builder;

import java.time.Year;

@Builder
public record ReadSaveBookResponseDTO(String isbn, String title, String author, Year published) {

    public static ReadSaveBookResponseDTO from(Book book) {
        return ReadSaveBookResponseDTO.builder()
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .author(book.getAuthor())
                .published(book.getPublished())
                .build();
    }

}
