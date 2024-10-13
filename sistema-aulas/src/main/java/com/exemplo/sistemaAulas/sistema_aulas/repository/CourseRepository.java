package com.exemplo.sistemaAulas.sistema_aulas.repository;

import com.exemplo.sistemaAulas.sistema_aulas.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
