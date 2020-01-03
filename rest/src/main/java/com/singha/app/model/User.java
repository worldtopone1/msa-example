package com.singha.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
public class User {

	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
    private String userno;
    private String userid;
    private String password;
    private String name;
    
    @OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "userno", insertable = false, updatable = false)
	private List<UserAuth> roles;

}
