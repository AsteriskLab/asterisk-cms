package com.asterisk.service.mapper;

import com.asterisk.domain.*;
import com.asterisk.service.dto.BookDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Book and its DTO BookDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BookMapper {

    BookDTO bookToBookDTO(Book book);

    List<BookDTO> booksToBookDTOs(List<Book> books);

    Book bookDTOToBook(BookDTO bookDTO);

    List<Book> bookDTOsToBooks(List<BookDTO> bookDTOs);
}
