package com.exemplo.sistemaAulas.sistema_aulas.repository;

import com.exemplo.sistemaAulas.sistema_aulas.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByNomeContainingIgnoreCase(String name);
}
