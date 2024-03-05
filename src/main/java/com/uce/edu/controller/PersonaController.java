package com.uce.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	//todo metodo de controll retorna un string
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
	//cuando viaja el modelo en el response
	//GET
	// /buscarPorCedula/11111
	@GetMapping("/buscarPorCedula/{cedulaPersona}")
	public String buscarPorCedula(@PathVariable("cedulaPersona") String cedula, Model modelo) {
		Persona persona = this.iPersonaService.consultarPorCedula(cedula);
		modelo.addAttribute("persona", persona);
		return "vistaPersona";
	}
	
	//Cuando viaja el modelo en el request se declara el objeto que viaja
		@PutMapping("/actualizar/{cedulaPersona}")
		public String actualizar(@PathVariable("cedulaPersona") String cedula, Persona persona) {
			persona.setCedula(cedula);
			
			//busca a la persona en la base de datos
			Persona perAux1 = this.iPersonaService.consultarPorCedula(cedula);
			perAux1.setApellido(persona.getApellido());
			perAux1.setNombre(persona.getNombre());
			perAux1.setCedula(persona.getCedula());
			perAux1.setGenero(persona.getGenero());
			this.iPersonaService.actualizar(perAux1);
			return "redirect:/personas/buscarTodos";
		}
	


	
	@PostMapping("/insertar")
	public String insertar(Persona persona) {
		this.iPersonaService.guardar(persona);
		return "redirect:/personas/buscarTodos";
	}
	

	@GetMapping("/nuevaPersona")
	public String mostrarNuevaPersona(Model modelo) {
		modelo.addAttribute("persona", new Persona());
		return "vistaNuevaPersona";
	}
		
	@DeleteMapping("/borrar/{cedula}")
	public String borrar(@PathVariable("cedula") String cedula) {
		this.iPersonaService.borrarPorCedula(cedula);
		
		return "redirect:/personas/buscarTodos";
	}
	
}

