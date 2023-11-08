package com.example.filmDizi.repostory;

import com.example.filmDizi.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepostory extends JpaRepository<Film,Long> {
}
