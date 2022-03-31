package com.hunterVolunter.hunterVolunter.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hunterVolunter.hunterVolunter.models.Projeto;


public interface ProjetoRepository extends CrudRepository <Projeto, String> { 

	
	Projeto findByCodigo(long codigo);


	/* Projeto findByNome(String nome); */


	@Query(value = "select p from Projeto p where p.nome like %?1%")
	List<Projeto>findByName(String nome);
}

