package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "TypeAction")
public class TypeAction {

	@Id
	public String id;
	public String nomAction;
	public boolean isselected;

	public TypeAction() {
		this.isselected=false;
	}


	public TypeAction(String id, String nom) {
		this.isselected=false;
		this.id=id;
		this.nomAction=nom;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomAction() {
		return nomAction;
	}


	public void setNomAction(String nomAction) {
		this.nomAction = nomAction;
	}


	public boolean isIsselected() {
		return isselected;
	}


	public void setIsselected(boolean isselected) {
		this.isselected = isselected;
	}

	
}
