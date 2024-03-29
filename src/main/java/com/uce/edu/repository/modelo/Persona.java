package com.uce.edu.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="persona")
public class Persona {

	@Id
	@Column(name="pers_id")
	@GeneratedValue(generator="seq_persona", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_persona", sequenceName="seq_persona", allocationSize = 1)
	private Integer id;
	
	@Column(name="pers_cedula")
	private String cedula;
	
	@Column(name="pers_nombre")
	private String nombre;
	
	@Column(name="pers_apellido")
	private String apellido;
	
	@Column(name="pers_genero")
	private String genero;
	
	

	//gettersa anda setter

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	
	
}
