package com.vjm.cusomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;

import com.vjm.cusomc.domain.Categoria;


public class CategoriaDTO implements Serializable {	
	private static final long serialVersionUID = 1L;
		
	private Integer id;
	
	@NotBlank(message="Preenchimento obrigatório")
	@Size(min=5, max=80, message="Tamanho deve ser entre 5 e 80 caracteres")
	private String nome;
	
	public CategoriaDTO() {}
	
	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
