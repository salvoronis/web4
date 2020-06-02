package com.jaxrs.models;

import lombok.Data;
import javax.persistence.*;
import oracle.jdbc.driver.OracleDriver;

@Data
@Entity
@Table(name = "DOTS")
public class Point{
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "X")
	private double x;

	@Column(name = "Y")
	private double y;

	@Column(name = "R")
	private double r;

	@Column(name = "RESULT")
	private String result;

	@Column(name = "AUTHOR")
	private String login;

	@Transient
	private String token;

	public Point(double x,double y,double r){
		this.x = x;
		this.y = y;
		this.r = r;
	}

	public Point(){
		
	}

	public void solve(){
		if ((this.x <= 0.0) && (this.y >= 0.0) && (this.y <= this.x*2.0 + this.r)) {
			this.result = "Y";
		} else if ((this.y <= 0.0) && (this.x >= 0.0) && (this.x <= this.r) && (this.y >= -this.r/2)){
			this.result = "Y";
		} else if ((y <= 0.0) && (x <= 0.0) && ((Math.pow((Math.abs(this.x)), 2) + Math.pow((Math.abs(this.y)), 2))<=Math.pow(this.r/2, 2))){
			this.result = "Y";
		} else {
			this.result = "N";
		}
	}
}