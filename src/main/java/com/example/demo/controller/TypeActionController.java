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
import com.example.demo.model.TypeAction;
import com.example.demo.repository.TypeActionRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TypeActionController {
	
	@Autowired
	TypeActionRepository typeActionRepository;

	@PostMapping("/addTypeAction")
	public String SaveTypeAction(@RequestBody TypeAction typeAction) {
		typeActionRepository.save(typeAction);
		return "Added typeAction with id : " + typeAction.getId();
	}

	@GetMapping("/findAllTypeAction")
	public List<TypeAction> getTypeAction() {
		return typeActionRepository.findAll();
	}

	@GetMapping("/findAllTypeAction/{id}")
	public Optional<TypeAction> getBook(@PathVariable String id) {
		return typeActionRepository.findById(id);
	}
	
	@DeleteMapping("/deleteTypeAction/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTypeAction(@PathVariable String id){
		TypeAction typeAction = typeActionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("TypeAction not exist with id :" + id));
		
		typeActionRepository.delete(typeAction);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TypeAction> updateTypeAction(@PathVariable String id, @RequestBody TypeAction typeActionDetails){
		TypeAction typeAction = typeActionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("TypeAction not exist with id :" + id));
		
		typeAction.setNomAction(typeActionDetails.getNomAction());
		
		TypeAction updatedTypeAction = typeActionRepository.save(typeAction);
		return ResponseEntity.ok(updatedTypeAction);
	}

}
