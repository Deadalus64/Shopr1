package com.example.shopr1.controller;

import com.example.shopr1.domain.*;
import com.example.shopr1.services.BookService;
//import com.example.shopr1.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

//    @Autowired
//    private GameService gameService;

    // display list of books
    @GetMapping("@{/manageBooks}")
    public String viewBooks(Model model) {
        model.addAttribute("listBooks", bookService.getAllBooks());
        //        return findPaginated(1, "id", "asc", model);
        return  "Books";
    }

    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model) {
        // create model attribute to bind form data
        BookFiction bookFiction = new BookFiction();
        BookNonFiction bookNonFiction = new BookNonFiction();
        model.addAttribute("bookFiction", bookFiction);
        model.addAttribute("bookNonFiction", bookNonFiction);
        return "newBook";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("bookFiction") BookFiction bookFiction) {
        // save book to database
        if (bookFiction instanceof BookFiction) {
            bookService.saveBook((BookFiction)bookFiction);
        }
//        else if (bookFiction instanceof BookNonFiction) {
//            bookService.saveBook((BookNonFiction)bookFiction);
//        }
        bookService.saveBook(bookFiction);
        return "redirect:/manageBooks";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {

        // get book from the service
        if (bookService.getBookById(id) instanceof BookFiction) {
            BookFiction bookFiction = (BookFiction)bookService.getBookById(id);
            model.addAttribute("bookFiction", bookFiction);
        } else if (bookService.getBookById(id) instanceof BookNonFiction) {
            BookNonFiction bookNonFiction = (BookNonFiction) bookService.getBookById(id);
            model.addAttribute("bookNonFiction", bookNonFiction);
        }

        // set book as a model attribute to pre-populate the form
//        model.addAttribute("book", bookService.getBookById(id));
//        model.addAttribute("listGames", gameService.getAllGame());

        return "updateBook";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable (value = "id") long id) {

        // call delete book method 
        this.bookService.deleteBookById(id);
        return "redirect:/manageBooks";
    }


    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Book> page = bookService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Book> listBooks = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listBooks", listBooks);
        return "manageBooks";
    }
}
