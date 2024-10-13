package com.exemplo.sistemaAulas.sistema_aulas.controller;

import com.exemplo.sistemaAulas.sistema_aulas.model.Course;
import com.exemplo.sistemaAulas.sistema_aulas.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    // Retorna todos os cursos
    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Retorna um curso específico pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return courseRepository.findById(id)
                .map(course -> ResponseEntity.ok(course))
                .orElse(ResponseEntity.notFound().build());
    }

    // Salva um novo curso
    @PostMapping
    public Course saveCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    // Atualiza um curso existente
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setNome(courseDetails.getNome());
                    course.setDescricao(courseDetails.getDescricao());
                    Course updatedCourse = courseRepository.save(course);
                    return ResponseEntity.ok(updatedCourse);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Deleta um curso pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable Long id) {
        return courseRepository.findById(id)
                .map(course -> {
                    courseRepository.delete(course);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
