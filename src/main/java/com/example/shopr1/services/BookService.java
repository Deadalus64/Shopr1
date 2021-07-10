package com.example.shopr1.services;

import com.example.shopr1.domain.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    void saveBook(Book book);
    Book getBookById(long id);
    void deleteBookById(long id);
    Page<Book> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
