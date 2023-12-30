package com.springboot.backend.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.Exception.ResourceNotFoundException;
import com.springboot.backend.Model.Employe;
import com.springboot.backend.Repository.EmployeRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeController {
	@Autowired
	EmployeRepository employeRepository;

	@GetMapping("/employe")
	public List<Employe> getAllEmployes() {
		return employeRepository.findAll();
	}

	// Create employe Rest Api
	@PostMapping("/employe")
	public Employe createEmploye(@RequestBody Employe employe) {
		return employeRepository.save(employe);
	}

	// Get Employe By id
	@GetMapping("/employe/{id}")
	public ResponseEntity<Employe> getEimployeById(@PathVariable Long id) {
		Employe employe = employeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employe Not Found with id :" + id));
		return ResponseEntity.ok(employe);
	}

	// update Employee
	@PutMapping("/employe/{id}")
	public ResponseEntity<Employe> updateEmploye(@PathVariable long id, @RequestBody Employe employeDetails) {
		Employe employe = employeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employe Not Found with id :" + id));
		employe.setFirstName(employeDetails.getFirstName());
		employe.setLastName(employeDetails.getLastName());
		employe.setEmailId(employeDetails.getEmailId());

		Employe updatedEmploye = employeRepository.save(employe);
		return ResponseEntity.ok(updatedEmploye);
	}

	// Delete Employee
	@DeleteMapping("/employe/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable long id) {
		Employe employe = employeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employe Not Found with id :" + id));
		employeRepository.delete(employe);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
