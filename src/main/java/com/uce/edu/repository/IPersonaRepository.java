package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.modelo.Persona;

public interface IPersonaRepository {

	
	public void insertar(Persona persona);
	
	public void actualizar(Persona persona);
	
	public Persona consultarPorCedula(String cedula);
	
	public List<Persona> consultarTodos();
	
	public void eliminarPorCedula(String cedula);
}
