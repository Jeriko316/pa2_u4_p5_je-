package com.uce.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.Persona;
import com.uce.edu.service.IPersonaService;

//http://localhost:8080/personas/buscarTodos
//http://localhost:8080/personas/actualizar

@Controller
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private IPersonaService iPersonaService;
	
	//diferentes tipos de request
	//verbo o metodos HTTP
	
	@GetMapping("/buscarTodos")
	public String buscarTodos(Model modelo) {
		List<Persona> lista=this.iPersonaService.consultarTodos();
		modelo.addAttribute("personas",lista);
		return "vistaListaPersonas";
	}
	
	//Path
	//GET
	@GetMapping("/buscar")
	public String buscarPorCedula(String cedula) {
		
		return null;
	}
	
	//Put
	@PutMapping("/actualizar")
	public String actualizar(String cedula) {
		
		return null;
	}
	
	@DeleteMapping("/borrar")
	public String borrar() {
		
		return null;
	}
	
	@PostMapping("/guardar")
	public String guardar() {
		
		return null;
	}
}

