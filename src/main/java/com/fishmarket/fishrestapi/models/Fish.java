package com.fishmarket.fishrestapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sales")
public class Fish {

	@Id
	String id;
	String fishName;
	
	public Fish() {
		
	}
	
	public Fish(String fishName) {
		this.fishName = fishName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFishName() {
		return fishName;
	}

	public void setFishName(String fishName) {
		this.fishName = fishName;
	}

}
