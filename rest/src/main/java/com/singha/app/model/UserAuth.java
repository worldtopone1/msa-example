package com.singha.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@IdClass(UserAuthId.class)
@Table(name="user_role")
public class UserAuth{
	
	@Id
	private String userno;
	@Id
	private String rolecd;
	
}

