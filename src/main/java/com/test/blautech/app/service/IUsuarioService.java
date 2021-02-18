package com.test.blautech.app.service;

import java.util.List;

import com.test.blautech.app.model.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario findOne(Long id);
	
	public void delete(Long id);
	
	public  void save (Usuario usuario);
	

}
