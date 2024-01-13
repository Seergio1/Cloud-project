package com.example.stock.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.Models.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long>{

    Optional<Employer> findEmployerById(Long id);

    Optional<Employer> findEmployerByEmail(String email);

    

    
}
