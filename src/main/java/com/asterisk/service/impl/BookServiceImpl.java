package com.asterisk.service.impl;

import com.asterisk.service.BookService;
import com.asterisk.domain.Book;
import com.asterisk.repository.BookRepository;
import com.asterisk.repository.search.BookSearchRepository;
import com.asterisk.service.dto.BookDTO;
import com.asterisk.service.mapper.BookMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing Book.
 */
@Service
@Transactional
public class BookServiceImpl implements BookService{

    private final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
    
    @Inject
    private BookRepository bookRepository;

    @Inject
    private BookMapper bookMapper;

    @Inject
    private BookSearchRepository bookSearchRepository;

    /**
     * Save a book.
     *
     * @param bookDTO the entity to save
     * @return the persisted entity
     */
    public BookDTO save(BookDTO bookDTO) {
        log.debug("Request to save Book : {}", bookDTO);
        Book book = bookMapper.bookDTOToBook(bookDTO);
        book = bookRepository.save(book);
        BookDTO result = bookMapper.bookToBookDTO(book);
        bookSearchRepository.save(book);
        return result;
    }

    /**
     *  Get all the books.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<BookDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Books");
        Page<Book> result = bookRepository.findAll(pageable);
        return result.map(book -> bookMapper.bookToBookDTO(book));
    }

    /**
     *  Get one book by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public BookDTO findOne(Long id) {
        log.debug("Request to get Book : {}", id);
        Book book = bookRepository.findOne(id);
        BookDTO bookDTO = bookMapper.bookToBookDTO(book);
        return bookDTO;
    }

    /**
     *  Delete the  book by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Book : {}", id);
        bookRepository.delete(id);
        bookSearchRepository.delete(id);
    }

    /**
     * Search for the book corresponding to the query.
     *
     *  @param query the query of the search
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<BookDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Books for query {}", query);
        Page<Book> result = bookSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(book -> bookMapper.bookToBookDTO(book));
    }
}
