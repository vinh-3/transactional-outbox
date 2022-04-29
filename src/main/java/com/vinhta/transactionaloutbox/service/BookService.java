package com.vinhta.transactionaloutbox.service;

import com.vinhta.transactionaloutbox.controller.dto.DeleteBookResponseDTO;
import com.vinhta.transactionaloutbox.controller.dto.ReadSaveBookResponseDTO;
import com.vinhta.transactionaloutbox.controller.dto.saveBookRequestDTO;

public interface BookService {

    ReadSaveBookResponseDTO getBook(String isbn);

    ReadSaveBookResponseDTO saveBook(String isbn, saveBookRequestDTO requestDTO);

    DeleteBookResponseDTO deleteBook(String isbn);

}
