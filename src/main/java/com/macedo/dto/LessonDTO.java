package com.macedo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LessonDTO(
                Long id,
                @NotBlank @NotNull @Size(min = 5, max = 100) String name,
                @NotBlank @NotNull @Size(min = 10, max = 100) String youtubeUrl) {

}
