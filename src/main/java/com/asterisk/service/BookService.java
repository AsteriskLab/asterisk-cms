package com.asterisk.service;

import com.asterisk.service.dto.BookDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.LinkedList;
import java.util.List;

/**
 * Service Interface for managing Book.
 */
public interface BookService {

    /**
     * Save a book.
     *
     * @param bookDTO the entity to save
     * @return the persisted entity
     */
    BookDTO save(BookDTO bookDTO);

    /**
     *  Get all the books.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<BookDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" book.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    BookDTO findOne(Long id);

    /**
     *  Delete the "id" book.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the book corresponding to the query.
     *
     *  @param query the query of the search
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<BookDTO> search(String query, Pageable pageable);
}
