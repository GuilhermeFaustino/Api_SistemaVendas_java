package br.com.storebr.webstore.sytem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.storebr.webstore.sytem.model.Pessoas;

public interface PessoaRepository extends CrudRepository<Pessoas, String>{
	
    List<Pessoas> findAll();
	
	Pessoas findById(int id);
	
	Pessoas findByCpf(String cpf);
	
	void deleteById(Pessoas id);
	
	void delete(Pessoas pessoa);
	
	<Pessoa extends Pessoas> Pessoa save(Pessoas pessoa);
}
