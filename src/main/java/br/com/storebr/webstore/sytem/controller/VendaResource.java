package br.com.storebr.webstore.sytem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.storebr.webstore.sytem.model.Carrinho;
import br.com.storebr.webstore.sytem.model.Pessoas;
import br.com.storebr.webstore.sytem.model.Product;
import br.com.storebr.webstore.sytem.model.Venda;
import br.com.storebr.webstore.sytem.service.VendasService;



@RestController
@RequestMapping("/sales")
public class VendaResource {
	
	@Autowired
	private VendasService vendas;
	
	@GetMapping
	public List<Venda> listVendas(){
		return vendas.listVendas();
	}
	
	@PostMapping("/onlinesales/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable(value = "id") int id, @RequestBody String cpf) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(vendas.saveSales(id, cpf));
	}
	
//	public ResponseEntity<String> updateProductCarrinho(@PathVariable(value = "sku") String sku, @RequestBody Integer quantidade){
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(carrinhoservice.atualizarCarrinho(sku, quantidade));
//	}
//	
	
	

}
