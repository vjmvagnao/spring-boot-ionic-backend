package com.vjm.cusomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.vjm.cusomc.domain.Cliente;
import com.vjm.cusomc.services.validation.ClienteUpdate;

@ClienteUpdate
public class ClienteDTO implements Serializable {	
	private static final long serialVersionUID = 1L;
		
	private Integer id;
	
	@NotBlank(message="Preenchimento obrigatório")
	@Size(min=5, max=120, message="Tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@NotBlank(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;
	
	public ClienteDTO() {}
	
	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	
}
