package com.asterisk.service.dto;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;


/**
 * A DTO for the Book entity.
 */
public class BookDTO implements Serializable {

    private Long id;

    @NotNull
    @DecimalMin(value = "1")
    private Double price;

    private String isbn;

    private String author;

    private LocalDate publishDate;

    private Integer counts;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BookDTO bookDTO = (BookDTO) o;

        if ( ! Objects.equals(id, bookDTO.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "BookDTO{" +
            "id=" + id +
            ", price='" + price + "'" +
            ", isbn='" + isbn + "'" +
            ", author='" + author + "'" +
            ", publishDate='" + publishDate + "'" +
            ", counts='" + counts + "'" +
            '}';
    }
}
