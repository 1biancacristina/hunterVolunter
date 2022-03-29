package com.hunterVolunter.hunterVolunter.models;

/*import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;*/
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;



@Entity
public class Entidade {
	
	@Id
	private String identificacao;
	
	@NotEmpty
	private String nomeVoluntario;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String telefone;
	
	@NotEmpty
	private String senha;

	@NotEmpty
	private String modelo;
	
	@NotEmpty
	private String datanascimento;
	
	@NotEmpty
	private String endereco;

	
	@NotEmpty
	private String estado;
	
	@NotEmpty
	private String interesse;
	
	/*
	 * @OneToMany(mappedBy = "entidade", cascade = CascadeType.REMOVE) private
	 * List<Projeto> projetos;
	 */

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public String getNomeVoluntario() {
		return nomeVoluntario;
	}

	public void setNomeVoluntario(String nomeVoluntario) {
		this.nomeVoluntario = nomeVoluntario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getInteresse() {
		return interesse;
	}

	public void setInteresse(String interesse) {
		this.interesse = interesse;
	}

	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	
}
