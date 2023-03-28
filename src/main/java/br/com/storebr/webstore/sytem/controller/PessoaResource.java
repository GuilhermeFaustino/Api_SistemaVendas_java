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

import br.com.storebr.webstore.sytem.model.Pessoas;
import br.com.storebr.webstore.sytem.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaService pessoa;
	

	@GetMapping
	public List<Pessoas> getProducts() {
		return pessoa.listItems();
	}
	
	@PostMapping("/cadastro")
	public ResponseEntity<String> cadastroPessoa(@RequestBody Pessoas pessoas){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(pessoa.cadastroPessoas(pessoas));
	}
	
	@PutMapping("/alterar/{id}")
	public ResponseEntity<String> updatePessoa(@PathVariable int id, @RequestBody Pessoas pessoas){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(pessoa.alterarCadastroPessoa(id, pessoas));
	}
	
	@DeleteMapping("/deletar")
	public ResponseEntity<String> deletePessoa(@RequestBody Integer id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(pessoa.deletePessoas(id));
	}
}
