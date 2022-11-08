package com.webshoppe.ecommerce.service;

import java.math.BigDecimal;
import java.util.List;

import com.webshoppe.ecommerce.entity.Book;
import com.webshoppe.ecommerce.exception.DataAccessException;
import com.webshoppe.ecommerce.exception.ServiceException;
import com.webshoppe.ecommerce.repository.BookRepository;

public class BookCatalogService {
    private BookRepository bookRepository;

    public BookCatalogService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBookCatalog() {
        try {
            return bookRepository.findAll();
        } catch (DataAccessException e) {
            throw ServiceException.instance(e.getMessage());
        }

    }

    public List<Book> getBookCatalog(BigDecimal minimumPrice, BigDecimal maximumPrice) {
        try {
            return bookRepository.findByPrice(minimumPrice, maximumPrice);
        } catch (DataAccessException e) {
            throw ServiceException.instance(e.getMessage());
        }

    }
}
