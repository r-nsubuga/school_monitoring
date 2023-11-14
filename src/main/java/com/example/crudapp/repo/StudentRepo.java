package com.example.crudapp.repo;

import com.example.crudapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for managing Student entities
public interface StudentRepo extends JpaRepository<Student, Long> {
}
