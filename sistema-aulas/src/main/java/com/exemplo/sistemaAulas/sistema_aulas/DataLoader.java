package com.exemplo.sistemaAulas.sistema_aulas;

import com.exemplo.sistemaAulas.sistema_aulas.model.Course;
import com.exemplo.sistemaAulas.sistema_aulas.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CourseRepository courseRepository;

    public DataLoader(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Criando um novo curso e salvando no banco
        Course course = new Course(null, "Curso de Java", "Aprenda Java com Spring Boot");
        courseRepository.save(course);

        // Listando todos os cursos no banco
        courseRepository.findAll().forEach(System.out::println);
    }
}

