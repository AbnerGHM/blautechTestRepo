package com.test.blautech.app.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping(value = "/informacion/{id}")
	public String recuperarInformacionUsuario(@PathParam(value = "id") Long id, RedirectAttributes flash) {
	
		flash.addAttribute("usuario", usuarioService.findOne(id));
	return "redirect:/informacion";

	}
}
