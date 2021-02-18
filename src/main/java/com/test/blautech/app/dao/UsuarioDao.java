package com.test.blautech.app.dao;



import org.springframework.data.repository.PagingAndSortingRepository;

import com.test.blautech.app.model.Usuario;

public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long> {

}
