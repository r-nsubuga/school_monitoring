package com.example.crudapp.repo;

import com.example.crudapp.model.DayPass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayPassRepo extends JpaRepository<DayPass, Long> {
}
