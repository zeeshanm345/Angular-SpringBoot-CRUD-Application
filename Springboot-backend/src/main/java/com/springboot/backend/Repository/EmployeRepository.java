package com.springboot.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.backend.Model.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
