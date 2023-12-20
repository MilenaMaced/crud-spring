package com.macedo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.macedo.dto.CourseDTO;
import com.macedo.dto.mapper.CourseMapper;
import com.macedo.exception.RecordNotFoundException;
import com.macedo.model.Course;
import com.macedo.repository.CourseRepository;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public List<CourseDTO> list() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toDTO)
                .toList();
    }

    public CourseDTO findById(Long id) {
        return courseRepository.findById(id).map(courseMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public CourseDTO create(CourseDTO course) {
        return courseMapper.toDTO(courseRepository.save(courseMapper.toEntity(course)));
    }

    public CourseDTO update(Long id, CourseDTO courseDTO) {
        return courseRepository.findById(id)
                .map(recordFound -> {
                    Course course = courseMapper.toEntity(courseDTO);

                    recordFound.setName(courseDTO.name());
                    recordFound.setCategory(courseMapper.convertCategoryValue(courseDTO.category()));
                    recordFound.getLessons().clear();

                    course.getLessons().forEach(recordFound.getLessons()::add);

                    return courseMapper.toDTO(courseRepository.save(recordFound));

                }).orElseThrow(() -> new RecordNotFoundException(id));

    }

    public void delete(Long id) {
        courseRepository.delete(courseRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
