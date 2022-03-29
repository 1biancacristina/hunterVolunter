package com.hunterVolunter.hunterVolunter.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.hunterVolunter.hunterVolunter.models.Entidade;
import com.hunterVolunter.hunterVolunter.models.Projeto;

@Repository
public interface EntidadeRepository extends CrudRepository <Entidade, String> {

	Entidade findByIdentificacao(String identificacao);
	List<Entidade>findByNomeVoluntario(String nomeVoluntario);
	
	@Query(value = "select e from Entidade e where e.nomeVoluntario like %?1%")
	List<Projeto>findBynNomeVoluntario(String nomeVoluntario);

	
	@Query(value = "select e from Entidade e where email = :email and senha = :senha", nativeQuery = true)
	public Entidade Login(String email, String senha);
 
}


