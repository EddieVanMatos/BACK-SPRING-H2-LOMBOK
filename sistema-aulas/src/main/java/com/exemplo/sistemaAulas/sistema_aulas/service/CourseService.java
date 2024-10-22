package com.exemplo.sistemaAulas.sistema_aulas.service;

import com.exemplo.sistemaAulas.sistema_aulas.model.Course;
import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> getAllCourses();  // Para buscar todos os cursos

    Optional<Course> getCourseById(Long id);  // Para buscar um curso por ID

    Course saveCourse(Course course);  // Para salvar um novo curso

    Course updateCourse(Long id, Course courseDetails);  // Para atualizar um curso

    void deleteCourse(Long id);  // Para deletar um curso
}

