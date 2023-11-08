package com.example.filmDizi.service;

import com.example.filmDizi.dto.request.FilmRequestDto;
import com.example.filmDizi.entity.Film;
import com.example.filmDizi.repostory.FilmRepostory;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {
    private final FilmRepostory filmRepostory;


    public FilmServiceImpl(FilmRepostory filmRepostory) {
        this.filmRepostory = filmRepostory;
    }


    @Override
    public Film saveFilm(FilmRequestDto requestDto) {
        Film film = new Film();
        film.setName(requestDto.getName());
      film.setImageUrl(requestDto.getImageUrl());
        film.setRating(requestDto.getRating());
        return filmRepostory.save(film);
    }
    @Override
    public Film findById(long id){
Optional<Film>filmOptional =filmRepostory.findById(id);
return filmOptional.orElseThrow(()->new RuntimeException("film is not found"));
//bi sonraki is exception package olusturma (alttaki kod satiri calismali).
       // return filmOptional.orElseThrow(()->new  ApiRequestException("film is not found"));
    }
    @Override
    public  Film deleteFilm(long id){
        var film=findById(id);
filmRepostory.delete(film);
return film;
    }
    @Override
    public Film updateFilm(long id, FilmRequestDto requestDto){
        var updateFilm=findById(id);
        updateFilm.setName(requestDto.getName());
        updateFilm.setImageUrl(requestDto.getImageUrl());
        updateFilm.setRating(requestDto.getRating());
        updateFilm.setId(id);
        return filmRepostory.save(updateFilm);
    }
}
