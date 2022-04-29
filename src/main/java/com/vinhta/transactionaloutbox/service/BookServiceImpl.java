package com.vinhta.transactionaloutbox.service;

import com.vinhta.transactionaloutbox.controller.dto.DeleteBookResponseDTO;
import com.vinhta.transactionaloutbox.controller.dto.ReadSaveBookResponseDTO;
import com.vinhta.transactionaloutbox.controller.dto.saveBookRequestDTO;
import com.vinhta.transactionaloutbox.model.Book;
import com.vinhta.transactionaloutbox.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public ReadSaveBookResponseDTO getBook(String isbn) {
        Book book = bookRepository.getByIsbn(isbn);

        return ReadSaveBookResponseDTO.from(book);
    }

    @Override
    public ReadSaveBookResponseDTO saveBook(String isbn, saveBookRequestDTO requestDTO) {
        Book savedBook = bookRepository.save(
                Book.builder()
                        .isbn(isbn)
                        .title(requestDTO.title())
                        .author(requestDTO.author())
                        .published(requestDTO.published())
                        .build()
        );

        return ReadSaveBookResponseDTO.from(savedBook);
    }

    @Override
    public DeleteBookResponseDTO deleteBook(String isbn) {
        bookRepository.deleteByIsbn(isbn);

        return new DeleteBookResponseDTO(isbn);
    }
}
