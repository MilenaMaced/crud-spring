package com.macedo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.*;

import com.macedo.model.Lesson;

public record CourseDTO(
                Long id,
                @NotBlank @NotNull @Size(min = 5, max = 100) String name,
                @NotNull @Size(max = 10) @Pattern(regexp = "Back-end|Front-end") String category,
                List<Lesson> lessons) {

}
