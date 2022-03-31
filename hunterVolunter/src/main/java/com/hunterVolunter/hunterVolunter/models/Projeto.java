package com.hunterVolunter.hunterVolunter.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;



@Entity
public class Projeto implements Serializable {
	private static final long serrialVersionUID = 1L; 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String prazo;
	
	/*
	 * @NotEmpty private String modelo;
	 * 
	 * @NotEmpty private String categoria;
	 * 
	 * @NotEmpty private String status;
	 */
	@NotEmpty
	private String telefone;
	
	@NotEmpty
	private String email;
	/*
	 * @NotEmpty private String endereco;
	 * 
	 * @NotEmpty private String cidade;
	 * 
	 * @NotEmpty private String estado;
	 */
	

	 
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPrazo() {
		return prazo;
	}

	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}

	/*
	 * public String getModelo() { return modelo; }
	 * 
	 * public void setModelo(String modelo) { this.modelo = modelo; }
	 * 
	 * public String getCategoria() { return categoria; }
	 * 
	 * public void setCategoria(String categoria) { this.categoria = categoria; }
	 * 
	 * public String getStatus() { return status; }
	 * 
	 * public void setStatus(String status) { this.status = status; }
	 */
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * public String getEndereco() { return endereco; }
	 * 
	 * public void setEndereco(String endereco) { this.endereco = endereco; }
	 * 
	 * public String getCidade() { return cidade; }
	 * 
	 * public void setCidade(String cidade) { this.cidade = cidade; }
	 * 
	 * public String getEstado() { return estado; }
	 * 
	 * public void setEstado(String estado) { this.estado = estado; }
	 */

}
