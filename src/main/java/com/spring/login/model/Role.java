package com.spring.login.model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role extends BaseModel {

	@Column(name = "role")
	private String role;
}
