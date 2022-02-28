package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Technicien")
public class Technicien {
	
	@Id
	public String id;
	public String nom;
	public String tagtechniqueId;
	public String tagtechnique;
	public String typeActionId;
	public String typeAction;

	public Technicien() {
		
	}


	public Technicien(String id, String nom, String tagtechnique, String typeAction) {
		this.id=id;
		this.nom=nom;
		this.tagtechnique=tagtechnique;
		this.typeAction=typeAction;
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


	public String getTagtechnique() {
		return tagtechnique;
	}


	public void setTagtechnique(String tagtechnique) {
		this.tagtechnique = tagtechnique;
	}


	public String getTypeAction() {
		return typeAction;
	}


	public void setTypeAction(String typeAction) {
		this.typeAction = typeAction;
	}


	public String getTagtechniqueId() {
		return tagtechniqueId;
	}


	public void setTagtechniqueId(String tagtechniqueId) {
		this.tagtechniqueId = tagtechniqueId;
	}


	public String getTypeActionId() {
		return typeActionId;
	}


	public void setTypeActionId(String typeActionId) {
		this.typeActionId = typeActionId;
	}


}
