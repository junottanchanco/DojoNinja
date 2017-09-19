package com.codingdojo.dojoNinja.models;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ninjas")
public class Ninja {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@Size(min=5, max=255)
	private String first_name;
	
	@Column
	@Size(min=5, max=255)
	private String last_name;
	
	@Column
	@Min(18)
	private int age;
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyy")
	private Date created_at;
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyy")
	private Date updated_at;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dojo_id")
	private Dojo dojo;
	
	@PrePersist
	protected void onCreate() {
		this.created_at = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updated_at = new Date();
	}
	
	public Ninja() {
	}
	
	public Ninja(String first_name, String last_name, int age) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUdpated_at() {
		return updated_at;
	}

	public void setUdpated_at(Date udpated_at) {
		this.updated_at = udpated_at;
	}

	public Dojo getDojo() {
		return dojo;
	}

	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}
	
}
