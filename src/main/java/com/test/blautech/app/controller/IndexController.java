package com.test.blautech.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.test.blautech.app.service.IUsuarioService;

@Controller
public class IndexController {

	@Autowired
	IUsuarioService usuarioService;

	@RequestMapping({ "", "/", "index" })
	public String index(Model model) {
		model.addAttribute("titulo", "Usuarios");
		model.addAttribute("usuarios", usuarioService.findAll());
		return "index";

	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarUsuario(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		usuarioService.delete(id);
		// flash.addFlashAttribute("usuarioEliminado", "Usuario Eliminado");
		return "redirect:/index";

	}

	@RequestMapping(value = "/actualizar/{id}")
	public String editarUsuario(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		flash.addFlashAttribute("usuario", usuarioService.findOne(id));
		return "redirect:/actualizar";

	}
	

}
