package com.dompetku.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="ddigital")
	private int ddgital;
	
	@Column(name="ndigital")
	private String ndigital;
	
	@Column(name="jmlh")
	private int jmlh;
	
	@Column(name="tdigital")
	private int tdigital;
	
	@Column(name="ntdigital")
	private String ntdigital;
	
	@Column(name="status")
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDdgital() {
		return ddgital;
	}

	public void setDdgital(int ddgital) {
		this.ddgital = ddgital;
	}

	public String getNdigital() {
		return ndigital;
	}

	public void setNdigital(String ndigital) {
		this.ndigital = ndigital;
	}

	public int getJmlh() {
		return jmlh;
	}

	public void setJmlh(int jmlh) {
		this.jmlh = jmlh;
	}

	public int getTdigital() {
		return tdigital;
	}

	public void setTdigital(int tdigital) {
		this.tdigital = tdigital;
	}

	public String getNtdigital() {
		return ntdigital;
	}

	public void setNtdigital(String ntdigital) {
		this.ntdigital = ntdigital;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
