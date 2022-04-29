package com.vinhta.transactionaloutbox.repository;

import com.vinhta.transactionaloutbox.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {

    default Book getByIsbn(String isbn) {
        return getById(isbn);
    }

    default void deleteByIsbn(String isbn) {
        deleteById(isbn);
    }
}
