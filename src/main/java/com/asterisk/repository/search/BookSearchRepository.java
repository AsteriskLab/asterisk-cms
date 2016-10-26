package com.asterisk.repository.search;

import com.asterisk.domain.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data ElasticSearch repository for the Book entity.
 */
public interface BookSearchRepository extends ElasticsearchRepository<Book, Long> {
}
