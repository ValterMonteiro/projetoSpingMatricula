package br.edu.ifms.matricula.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EstudanteRequest {
	
	@Size(max=80, message='Informe o nome completo')
	@NotBlank(message='O campo nome não pode ser vazio')
	private String nome;
	
	@Size(min=11, max=11)
	@NotBlank('O campo CPF não pode ser vazio')
	private String cpf;
	
	
	private String email;
	
	@NotBlank(message='O campo senha não pode ser vazio')
	@Size(max=50, message='Informe uma senha com até 50 caracteres')
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
