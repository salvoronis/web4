package com.jaxrs.models;

import lombok.Data;

@Data
public class AnswerRegister {
	private String token;
	private boolean pass;
	public AnswerRegister(String token, boolean pass){
		this.token = token;
		this.pass = pass;
	}
	public AnswerRegister(boolean pass){
		this.pass = pass;
	}
}