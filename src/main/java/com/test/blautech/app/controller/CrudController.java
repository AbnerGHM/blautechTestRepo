package com.test.blautech.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.blautech.app.model.Usuario;
import com.test.blautech.app.service.IUsuarioService;

@Controller
public class CrudController {
	
	@Autowired
	IUsuarioService usuarioService;

	@RequestMapping(value = "/editar", produces = { "application/json" })
	public @ResponseBody String editarUsuario(@RequestParam(name = "id") Long id,
			@RequestParam(name = "nickname") String nickname, @RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password) {

		if (id != null && id > 0) {
			Usuario usuario = usuarioService.findOne(id);
			usuario.setNickname(nickname);
			usuario.setEmail(email);
			usuario.setPassword(password);
			usuarioService.save(usuario);
			return "Registro actualizado";

		}else {
			
		return "No se logro actualizar el registro";
		}
		
		
	}
	@RequestMapping(value = "/guardar", produces = { "application/json" })
	public @ResponseBody String guardarUsuario(
			@RequestParam(name = "nickname") String nickname, @RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password) {


         Usuario usuario = new Usuario(nickname, password, email);
         
         usuarioService.save(usuario);
         
         return "Se ha registrado un nuevo usuario";
	}
	
	@RequestMapping(value = "/listar", produces = { "application/json" })
	public @ResponseBody List<Usuario> listarUsuarios() {

		return usuarioService.findAll();

	}
	
	@RequestMapping(value = "/eliminar", produces = { "application/json" })
	public @ResponseBody String eliminar(@RequestParam(name = "id") Long id) {
		
		if (id != null && id > 0) {
			
			 usuarioService.delete(id);
			 return "Registro Eliminado";
		}
		return "No se ha podido eliminar el registro";
		

	}

}
