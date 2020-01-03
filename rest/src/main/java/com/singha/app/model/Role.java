package com.singha.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Role {
	
	@Id
	private String rolecd;
	
	private String rolenm;

}
