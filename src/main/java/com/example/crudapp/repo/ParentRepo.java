package com.example.crudapp.repo;

import com.example.crudapp.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepo extends JpaRepository<Parent, Long> {
}
