package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Technicien;
import com.example.demo.model.TypeAction;
import com.example.demo.repository.TechnicienRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TechnicienController {
	
	@Autowired
	TechnicienRepository technicienRepository;

	@PostMapping("/addTechnicien")
	public String SaveTechnicien(@RequestBody Technicien technicien) {
		technicienRepository.save(technicien);
		return "Added Technicien with id : " + technicien.getId();
	}

	@GetMapping("/findAllTechniciens")
	public List<Technicien> getTechniciens() {
		return technicienRepository.findAll();
	}

	@GetMapping("/findAllTechniciens/{id}")
	public Optional<Technicien> getTechnicien(@PathVariable String id) {
		return technicienRepository.findById(id);
	}
	
	@DeleteMapping("/deleteTechnicien/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTechnicien(@PathVariable String id){
		Technicien technicien = technicienRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Technicien not exist with id :" + id));
		
		technicienRepository.delete(technicien);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/UpdateTechnicien/{id}")
	public ResponseEntity<Technicien> updateTechnicien(@PathVariable String id, @RequestBody Technicien technicienDetails ){
		Technicien technicien = technicienRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Technicien not exist with id :" + id));
		
		technicien.setTypeAction(technicienDetails.getTypeAction());
		
		Technicien updatedTechnicien = technicienRepository.save(technicien);
		return ResponseEntity.ok(updatedTechnicien);
	}

}
