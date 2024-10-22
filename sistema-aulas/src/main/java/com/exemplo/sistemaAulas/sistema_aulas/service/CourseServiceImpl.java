package com.exemplo.sistemaAulas.sistema_aulas.service;

import com.exemplo.sistemaAulas.sistema_aulas.model.Course;
import com.exemplo.sistemaAulas.sistema_aulas.repository.CourseRepository;
import com.exemplo.sistemaAulas.sistema_aulas.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;  // Injeção de dependência do repositório

    // Implementação para buscar todos os cursos
    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Implementação para buscar curso por ID
    @Override
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    // Implementação para salvar um novo curso
    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    // Implementação para atualizar um curso existente
    @Override
    public Course updateCourse(Long id, Course courseDetails) {
        Optional<Course> existingCourse = courseRepository.findById(id);
        if (existingCourse.isPresent()) {
            Course course = existingCourse.get();
            course.setNome(courseDetails.getNome());
            course.setDescricao(courseDetails.getDescricao());
            return courseRepository.save(course);
        }
        throw new RuntimeException("Curso com ID " + id + " não encontrado.");
    }

    // Implementação para deletar curso pelo ID
    @Override
    public void deleteCourse(Long id) {
        Optional<Course> existingCourse = courseRepository.findById(id);
        if (existingCourse.isPresent()) {
            courseRepository.delete(existingCourse.get());
        } else {
            throw new RuntimeException("Curso com ID " + id + " não encontrado.");
        }
    }
}
