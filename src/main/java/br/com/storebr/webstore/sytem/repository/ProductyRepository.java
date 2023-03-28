package br.com.storebr.webstore.sytem.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.storebr.webstore.sytem.model.Product;

public interface ProductyRepository extends CrudRepository<Product, String> {
	
	List<Product> findAll();
	
	Product findById(int id);
	
	Product findBySku(String sku);
	
	void delete(Product product);
	
	<Prod extends Product> Prod save(Prod product);
	
}