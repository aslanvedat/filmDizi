package com.example.filmDizi.rest;

import com.example.filmDizi.FilmDiziApplication;
import com.example.filmDizi.dto.request.FilmRequestDto;
import com.example.filmDizi.entity.Film;
import com.example.filmDizi.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/film")
public class FilmController {
private FilmService filmService;
public FilmController(FilmService filmService){
    this.filmService=filmService;
}
@PostMapping("/save")
    public ResponseEntity<Film>saveFilm(@RequestBody FilmRequestDto input){
    var result=filmService.saveFilm(input);
    return  new ResponseEntity<Film>(result,HttpStatus.OK);
}
@GetMapping("/{filmId}")
    public ResponseEntity<Film>viewFilm(@PathVariable long filmId){
    var result=filmService.findById(filmId);
    return  new ResponseEntity<Film>(result,HttpStatus.OK);
}
@DeleteMapping("/{filmId}")
    public ResponseEntity<Film>deleteFilm(@PathVariable long filmId){
    var result=filmService.deleteFilm(filmId);
    return new ResponseEntity<Film>(result,HttpStatus.OK);
}
@PutMapping("/{filmId}")
    public ResponseEntity<Film>updateFilm(@PathVariable long filmId,@RequestBody FilmRequestDto input){
var result=filmService.updateFilm(filmId,input);
return  new ResponseEntity<Film>(result,HttpStatus.OK);

}

}

