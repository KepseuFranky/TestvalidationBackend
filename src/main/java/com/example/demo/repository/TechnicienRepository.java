package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Technicien;

public interface TechnicienRepository extends MongoRepository<Technicien, String> {
}