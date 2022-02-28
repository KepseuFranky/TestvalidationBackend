package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TagTechnique;
import com.example.demo.repository.TagTechniqueRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TagTechniqueController {

@Autowired
TagTechniqueRepository tagTechniqueRepository;

@PostMapping("/addTagTechnique")
public String SaveTagTechnique(@RequestBody TagTechnique tagTechnique) {
	tagTechniqueRepository.save(tagTechnique);
	return "Added tagTechnique with id : " + tagTechnique.getId();
}

@GetMapping("/findAllTagTechniques")
public List<TagTechnique> getTagTechniques() {
	return tagTechniqueRepository.findAll();
}

@GetMapping("/findAllTagTechniques/{id}")
public Optional<TagTechnique> getBook(@PathVariable String id) {
	return tagTechniqueRepository.findById(id);
}
	
}
