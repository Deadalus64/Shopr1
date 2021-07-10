//package com.example.shopr1.services;
//
//import com.example.shopr1.domain.Game;
//import com.example.shopr1.repositories.GameRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class GameServiceImpl implements GameService {
//
//    @Autowired
//    private GameRepository gameRepository;
//
//
//    public List<Game> getAllGames() {
//        return gameRepository.findAll();
//    }
//
//
//    public List<Game> getAllGame() {
//        return null;
//    }
//
//
//    public void saveGame(Game game) {
//        this.gameRepository.save(game);
//    }
//
//
//    public Game getGameById(int id) {
//        Optional<Game> optional = gameRepository.findById((long) id);
//        Game game = null;
//        if(optional.isPresent()){
//            game = optional.get();
//        } else{
//            throw new RuntimeException("Game not found for id :: " + id);
//        }
//
//        return game;
//    }
//
//    public void deleteGameById(int id) {
//        this.gameRepository.deleteById((long) id);
//    }
//
//    public Page<Game> findPaginated2(int pageNo, int pageSize, String sortField, String sortDirection) {
//        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
//                Sort.by(sortField).descending();
//
//        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
//        return this.gameRepository.findAll(pageable);
//    }
//}
