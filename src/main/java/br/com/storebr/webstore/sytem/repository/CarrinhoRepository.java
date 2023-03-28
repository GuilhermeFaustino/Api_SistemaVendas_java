package br.com.storebr.webstore.sytem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.storebr.webstore.sytem.model.Carrinho;
import br.com.storebr.webstore.sytem.model.Product;

public interface CarrinhoRepository extends CrudRepository<Carrinho, Integer>{
	
	    List<Carrinho> findAll();
		
		Carrinho findById(int id);
		
		Carrinho findBySku(String sku);
		
		void deleteById(Product id);
		
		void deleteBySku(String sku);
		
		void delete(Carrinho carrinho);
		
		<Cart extends Carrinho> Cart save(Product produto);

}
