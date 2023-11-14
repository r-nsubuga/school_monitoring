package com.example.crudapp.repo;

import com.example.crudapp.model.DayPass;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for managing DayPass entities
public interface DayPassRepo extends JpaRepository<DayPass, Long> {
}
