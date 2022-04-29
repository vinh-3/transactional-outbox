package com.vinhta.transactionaloutbox.controller;

import com.vinhta.transactionaloutbox.controller.dto.DeleteBookResponseDTO;
import com.vinhta.transactionaloutbox.controller.dto.ReadSaveBookResponseDTO;
import com.vinhta.transactionaloutbox.controller.dto.saveBookRequestDTO;
import com.vinhta.transactionaloutbox.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping(value = "/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReadSaveBookResponseDTO get(@PathVariable("isbn") String isbn) {
        return bookService.getBook(isbn);
    }

    @PutMapping(value = "/{isbn}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReadSaveBookResponseDTO save(@PathVariable("isbn") String isbn, @RequestBody saveBookRequestDTO requestDTO) {
        return bookService.saveBook(isbn, requestDTO);
    }

    @DeleteMapping(value = "/{isbn}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DeleteBookResponseDTO delete(@PathVariable("isbn") String isbn) {
        return bookService.deleteBook(isbn);
    }
}
