package br.com.storebr.webstore.sytem.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import br.com.storebr.webstore.sytem.model.Carrinho;
import br.com.storebr.webstore.sytem.model.Venda;

public interface VendaRepository extends CrudRepository<Venda, String>{
	
	List<Venda> findAll();
	
	Venda findById(int id);
	
	//Venda findBySku(String sku);
	
	void delete(Venda venda);
	
	<Vend extends Venda> Vend save(Vend cart);

}
