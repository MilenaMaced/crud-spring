package com.macedo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macedo.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}