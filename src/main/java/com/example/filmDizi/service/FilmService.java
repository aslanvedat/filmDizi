package com.example.filmDizi.service;

import com.example.filmDizi.dto.request.FilmRequestDto;
import com.example.filmDizi.entity.Film;
import org.springframework.stereotype.Service;


public interface FilmService {
    Film saveFilm(FilmRequestDto requestDto);
    Film findById(long id);
    Film deleteFilm(long id);
    Film updateFilm(long id, FilmRequestDto requestDto);
}
