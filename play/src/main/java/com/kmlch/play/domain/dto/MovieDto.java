package com.kmlch.play.domain.dto;

import com.kmlch.play.domain.Genre;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record MovieDto (
        Long id,
        @NotBlank(message = "El titulo es obligatorio")
        String title,

        @NotNull(message = "La duracion es obligatoria")
        Integer duration,

        @NotNull(message = "El genero es obligatorio")
        Genre genre,

        @NotNull(message = "La fecha no pueder estar vacia")
        @PastOrPresent(message = "La fecha debe ser actual o pasada")
        LocalDate releaseDate,

        @Max(value = 5, message = "Maximo debe ser 5")
        @Min(value = 0, message = "Minimo debe ser 0")
        Double rating
) {
}
