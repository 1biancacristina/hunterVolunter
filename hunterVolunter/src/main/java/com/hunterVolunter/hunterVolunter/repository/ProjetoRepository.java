package com.hunterVolunter.hunterVolunter.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hunterVolunter.hunterVolunter.models.Projeto;
/*import com.hunterVolunter.hunterVolunter.models.Entidade;*/

public interface ProjetoRepository extends CrudRepository <Projeto, Long> { 

	/* Iterable<Projeto> findByEntidade(Entidade entidade); */
	
	Projeto findByNome(String nome);
	Projeto findByCodigo(long codigo);
	


	@Query(value = "select p from Projeto p where p.nome like %?1%")
	List<Projeto>findByName(String nome);
}

