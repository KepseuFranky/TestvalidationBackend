package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "TagTechnique")
public class TagTechnique {

@Id
public String id;
public String nom;
public boolean isselected=false;

public TagTechnique() {
	this.isselected=false;
}


public TagTechnique(String id, String nom) {
	this.isselected=false;
	this.id=id;
	this.nom=nom;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}


public boolean isIsselected() {
	return isselected;
}


public void setIsselected(boolean isselected) {
	this.isselected = isselected;
}

}
