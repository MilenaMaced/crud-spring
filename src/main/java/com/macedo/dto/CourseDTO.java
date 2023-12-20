package com.macedo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.*;

import com.macedo.enums.Category;
import com.macedo.enums.validation.ValueOfEnum;

public record CourseDTO(
        Long id,
        @NotBlank @NotNull @Size(min = 5, max = 100) String name,
        @NotNull @Size(max = 10) @ValueOfEnum(enumClass = Category.class) String category,
        @NotEmpty @NotNull @Valid List<LessonDTO> lessons) {

}
