package com.example.crudapp.repo;

import com.example.crudapp.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for managing Parent entities
public interface ParentRepo extends JpaRepository<Parent, Long> {
}
