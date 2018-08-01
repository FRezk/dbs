package br.com.rezk.environment.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Rating")
public class Rating {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="id_restaurant")
	private Long idRestaurant;
	
	@Column(name="grade")
	private Long grade;
	
	@Column(name="author")
	private String author;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGrade() {
		return grade;
	}

	public void setGrade(Long grade) {
		this.grade = grade;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Long getIdRestaurant() {
		return idRestaurant;
	}

	public void setIdRestaurant(Long idRestaurant) {
		this.idRestaurant = idRestaurant;
	}

}
