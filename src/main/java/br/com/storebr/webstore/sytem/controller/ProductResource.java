package br.com.storebr.webstore.sytem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.storebr.webstore.sytem.model.Product;
import br.com.storebr.webstore.sytem.service.StockService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/products")
public class ProductResource {

	@Autowired
	private StockService stockService;
	

	@GetMapping
	public List<Product> getProducts() {
		return stockService.listItems();
	}
	
	@GetMapping("/consult/{id}")
	public Product getProduct(@PathVariable int id) {
		return stockService.procurarProduto(id);
	}
	
	@CrossOrigin("Localhost:8080")
	@PostMapping("/cadastro")
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {	
			return ResponseEntity.status(HttpStatus.OK).body(stockService.registrarProduto(product));		
	}
	

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable (value="id") int id, @RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.OK).body(stockService.atualizarProduto(id, product));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable (value="id") int id, @RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(stockService.deleteProduct(id, product));
	}

	@PutMapping("/{id}")
	public Product searchProduct(@PathVariable (value="id") int id){
		return stockService.procurarProduto(id);
	}
}
