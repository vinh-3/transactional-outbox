package com.vinhta.transactionaloutbox.controller.dto;

import java.time.Year;

public record saveBookRequestDTO(String title, String author, Year published) {}
