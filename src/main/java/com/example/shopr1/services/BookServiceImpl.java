package com.example.shopr1.services;

import com.example.shopr1.domain.Book;
import com.example.shopr1.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void saveBook(Book book) {
        this.bookRepository.save(book);
    }

    public Book getBookById(long id) {
        return bookRepository.findById(id).get();
    }

    public void deleteBookById(long id) {

    }

    public Page<Book> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        return null;
    }


    public Book getBookById(int id) {
        Optional<Book> optional = bookRepository.findById((long) id);
        Book book = null;
        if(optional.isPresent()){
            book = optional.get();
        } else{
            throw new RuntimeException("Book not found for id :: " + id);
        }

        return book;
    }

    public void deleteBookById(int id) {
        this.bookRepository.deleteById((long) id);
    }

    public Page<Book> findPaginated2(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.bookRepository.findAll(pageable);
    }
}
