package com.example.crudapp.repo;

import com.example.crudapp.model.ResParent;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for managing ResParent entities
public interface ResParentRepo extends JpaRepository<ResParent, Long> {
}
