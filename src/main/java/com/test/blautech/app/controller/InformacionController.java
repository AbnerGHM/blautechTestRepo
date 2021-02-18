package com.test.blautech.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.blautech.app.model.Usuario;
import com.test.blautech.app.service.IUsuarioService;

@Controller
public class InformacionController {
	
	@Autowired
	IUsuarioService usuarioService;
	@RequestMapping({ "informacion" })
	public String index(Model model) {
		model.addAttribute("titulo", "Información");
		return "informacion";

	}
	
	@RequestMapping(value = "/actualizar/{id}", params = { "save" })
	public String recuperarInformacionUsuario(@PathVariable(value = "id") Long id, @ModelAttribute("usuario") Usuario usuario) {
	

		usuarioService.save(usuario);
		
		
	return "redirect:/index";

	}
	@RequestMapping(value = "/crear", params = { "create" } )
	public String crearUsuario(@ModelAttribute("usuario") Usuario usuario) {
		
		usuarioService.save(usuario);
	return "redirect:/index";

	}
	
	
}
