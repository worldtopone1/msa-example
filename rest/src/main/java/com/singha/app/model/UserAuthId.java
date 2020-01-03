package com.singha.app.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserAuthId implements Serializable {
	
	private static final long serialVersionUID = 3318987157549290203L;
	
	private String userno;
	private String rolecd;

}

