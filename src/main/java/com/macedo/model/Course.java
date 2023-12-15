package com.macedo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @NotNull
    @Size(min = 5, max = 100)
    @Column(length = 200, nullable = false)
    private String name;

    @NotNull
    @Size(max = 10)
    @Pattern(regexp = "Back-end | Front-end")
    @Column(length = 10, nullable = false)
    private String category;
}
