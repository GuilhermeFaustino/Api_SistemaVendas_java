package br.com.storebr.webstore.sytem.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.storebr.webstore.sytem.model.Pessoas;
import br.com.storebr.webstore.sytem.repository.PessoaRepository;


@Service
public class PessoaService {
	
	@Autowired
	  private PessoaRepository pessoa;
		

	 //LISTA PRODUTOS NO ESTOQUE
	  public List<Pessoas> listItems() {
			return pessoa.findAll();
	  }
	  
	  public Pessoas searcCpf(String cpf) {
			return pessoa.findByCpf(cpf);
		}
	  
	  public Pessoas searchPessoa(int id) {
			return pessoa.findById(id);
	  }
	  
	  
	
	public String cadastroPessoas(Pessoas pessoas) {
		String msg = "";
		Pessoas cpf = searcCpf(pessoas.getCpf());
		for (Pessoas cpf1 : listItems()) {
			if (cpf != null) {
				msg =  "Já existe um usuario com esse Cpf.";
			}else {
				pessoa.save(pessoas);
				msg =  "Cliente cadastrado";
			}			
		}
		return msg;		
	}	
	
	

	public String alterarCadastroPessoa(int id, Pessoas pessoas) {
		String msg = "";
		pessoas.setId(id);
		if(!pessoas.getId().equals(id)) {			
			msg = "Usuario nao Existe"; 
		}else {
			pessoa.save(pessoas);
			msg = "Usuario Alterado!";
		}
		return msg;
	}
	
	public String deletePessoas(int id) {		
		String msg;
		 Pessoas user = searchPessoa(id);
		  
		if(user.getId().equals(id)) {
		 pessoa.delete(user);
			msg = "usuario deletado";
		}else {
			msg = "usuario nao encontrado";
		}
		return msg;
	}
	
	
 }



