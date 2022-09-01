package com.vjm.cusomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vjm.cusomc.domain.Categoria;

@Repository
public interface CategariaRepository extends JpaRepository<Categoria, Integer> {
		 

}
