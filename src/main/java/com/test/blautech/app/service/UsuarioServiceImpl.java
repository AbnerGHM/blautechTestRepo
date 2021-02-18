package com.test.blautech.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.blautech.app.dao.UsuarioDao;
import com.test.blautech.app.model.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
	
		return  (List<Usuario>) usuarioDao.findAll();
	}
	
	public Usuario findOne(Long id) {
		
	return usuarioDao.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		usuarioDao.deleteById(id);
	}

	@Override
	public void save(Usuario usuario) {
		
		
	 usuarioDao.save(usuario);
		
	}

}
