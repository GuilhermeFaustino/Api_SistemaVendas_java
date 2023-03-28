package br.com.storebr.webstore.sytem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.storebr.webstore.sytem.model.Carrinho;
import br.com.storebr.webstore.sytem.service.CarrinhoService;
@RestController
@RequestMapping("/carrinho")
public class CarrinhoResource {
	
	@Autowired
	private CarrinhoService carrinhoservice;
	
	
	@GetMapping
	public List<Carrinho> getCarrinho() {
		return carrinhoservice.listCart();
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<String> saveProductCarrinho(@PathVariable int id, @RequestBody Integer quantidade) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(carrinhoservice.colocarNoCarrinho(id, quantidade));		
	}
	
	@PutMapping("/atualizar/{sku}")
	public ResponseEntity<String> updateProductCarrinho(@PathVariable(value = "sku") String sku, @RequestBody Integer quantidade){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(carrinhoservice.atualizarCarrinho(sku, quantidade));
	}
	
	
	@PutMapping("/remover/{id}")
	public ResponseEntity<String> deletQtdCarrinho(@PathVariable int id, @RequestBody Integer quantidade) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(carrinhoservice.removerDoCarrinho(id, quantidade));		
	}
	
	@DeleteMapping("/remover/produto/{id}")
	public ResponseEntity<String> deletProductCarrinho(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(carrinhoservice.delProdDoCarrinho(id));		
	}
	
	@PutMapping("/delete")
	public ResponseEntity<String> deleteCarrinho() {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(carrinhoservice.removeCart());		
	}
	
}
