package com.jaxrs.models;

import lombok.Data;
import javax.persistence.*;
import oracle.jdbc.driver.OracleDriver;

@Data
@Entity
@Table(name = "USERS")
public class User {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "LOGIN")
	String email;

	@Column(name = "PASSWD")
	String password;

	@Column(name = "TOKEN")
	String token;
}