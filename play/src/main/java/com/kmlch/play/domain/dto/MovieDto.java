package com.kmlch.play.domain.dto;

import com.kmlch.play.domain.Genre;

import java.time.LocalDate;

public record MovieDto (
        Long id,
        String title,
        Integer duration,
        Genre genre,
        LocalDate releaseDate,
        Double rating
) {
}
