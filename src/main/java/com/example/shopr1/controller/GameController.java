//package com.example.shopr1.controller;
//
//import com.example.shopr1.domain.Book;
//import com.example.shopr1.domain.Game;
//import com.example.shopr1.services.BookService;
//import com.example.shopr1.services.GameService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//public class GameController {
//
//    @Autowired
//    private GameService gameService;
//
//    @Autowired
//    private BookService bookService;
//
//
//    @GetMapping("/manageGames")
//    public String viewGames(Model model) {
//        return findPaginated2(1, "id", "asc", model);
//    }
//
//    @GetMapping("/showNewGameForm")
//    public String showNewGameForm(Model model) {
//        // create model attribute to bind form data
//        Game game = new Game();
//        model.addAttribute("game", game);
//        return "newGame";
//    }
//
//    @PostMapping("/saveGame")
//    public String saveGame(@ModelAttribute("game") Game game) {
//        // save book to database
//        gameService.saveGame(game);
//        return "redirect:/manageGames";
//    }
//
//    @GetMapping("/showFormForGameUpdate/{id}")
//    public String showFormForGameUpdate(@PathVariable( value = "id") int id, Model model) {
//
//        // get game from the service
//        Game game = gameService.getGameById(id);
//
//        List<Book> listBooks = bookService.getAllBooks();
//
//        // set game as a model attribute to pre-populate the form
//        model.addAttribute("game", game);
//        model.addAttribute("listBooks", listBooks);
//        return "updateGame";
//    }
//
//    @GetMapping("/deleteGame/{id}")
//    public String deleteGame(@PathVariable (value = "id") int id) {
//
//        // call delete book method
//        this.gameService.deleteGameById(id);
//        return "redirect:/manageGames";
//    }
//
//
//    @GetMapping("/pages/{pageNo}")
//    public String findPaginated2(@PathVariable (value = "pageNo") int pageNo,
//                                 @RequestParam("sortField") String sortField,
//                                 @RequestParam("sortDir") String sortDir,
//                                 Model model) {
//        int pageSize = 20;
//
//        Page<Game> pages = gameService.findPaginated2(pageNo, pageSize, sortField, sortDir);
//        List<Game> listGames = pages.getContent();
//
//        model.addAttribute("currentPage", pageNo);
//        model.addAttribute("totalPages", pages.getTotalPages());
//        model.addAttribute("totalItems", pages.getTotalElements());
//
//        model.addAttribute("sortField", sortField);
//        model.addAttribute("sortDir", sortDir);
//        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
//
//        model.addAttribute("listGames", listGames);
//        return "manageGames";
//    }
//
//}
