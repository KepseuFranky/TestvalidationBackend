package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.TagTechnique;

public interface TagTechniqueRepository extends MongoRepository<TagTechnique, String> {

}
