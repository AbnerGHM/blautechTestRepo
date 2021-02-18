package com.test.blautech.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.blautech.app.model.Usuario;
import com.test.blautech.app.service.IUsuarioService;

@Controller
public class IndexController {

	@Autowired
	private IUsuarioService usuarioService;

	@RequestMapping({ "", "/", "index" })
	public String index(Model model) {
		model.addAttribute("titulo", "Usuarios");
		model.addAttribute("usuarios", usuarioService.findAll());
		return "index";

	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarUsuario(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		usuarioService.delete(id);
		return "redirect:/index";

	}

	@RequestMapping(value = "/actualizar/{id}")
	public String editarUsuario(@PathVariable(value = "id") Long id, Model model) {

		Usuario usuario = usuarioService.findOne(id);
		if (usuario != null) {
		model.addAttribute("usuario", usuario);
		
	}
		return "actualizar";

	}
	
	@RequestMapping(value = "/crear")
	public String crearUsuario(Model model) {
		
		model.addAttribute("usuario", new Usuario());
		return "crear";

	}

}
