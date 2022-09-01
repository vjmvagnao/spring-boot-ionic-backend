package com.vjm.cusomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vjm.cusomc.domain.Categoria;
import com.vjm.cusomc.repositories.CategariaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategariaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);		
		return obj.orElse(null);		
	}

}
