package br.com.storebr.webstore.sytem.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.storebr.webstore.sytem.model.Carrinho;
import br.com.storebr.webstore.sytem.model.Product;
import br.com.storebr.webstore.sytem.repository.CarrinhoRepository;
import br.com.storebr.webstore.sytem.repository.ProductyRepository;




@Service
public class CarrinhoService{
	
	@Autowired
	private ProductyRepository product;
	@Autowired
	private CarrinhoRepository carrinho;
	
//	Product productEstoque = new Product();
	
	// LISTA PRODUTOS NO CARRINHO.
	public List<Carrinho> listCart() {
		return carrinho.findAll();
	}

	// PROCURA PRODUTO POR ID.
	public Product productId(int id) {
		return product.findById(id);
	}
	
	public Carrinho cartId(int id) {
		return carrinho.findById(id);
	}
	
	public Product procurandoSku(String sku) {		
		return product.findBySku(sku);
	}
	
	public Carrinho pCarrihno(String sku) {		
		return carrinho.findBySku(sku);
	}
	
	

	// ADICIONAR PRODUTO NO CARRINHO.
	public String colocarNoCarrinho(int id, Integer quantidade) {
		Product produto = productId(id);
		String msg = null;
		if (produto == null) {
			msg = "produto nao exite";
		} else if (produto.getQuantidade() < quantidade) {
			return "Não temos";
		} else if (quantidade <= 0) {
			return "Quantidade inválida, digite novamente";
		} else {
			Carrinho pCarrinho = new Carrinho(produto);
			pCarrinho.setQuantidade(quantidade);
			pCarrinho.setTotal(quantidade * produto.getValor());
			carrinho.save(pCarrinho);
			msg = "produto no carrinho";

		}
		return msg;
	}
	

	// RETIRANDO QUANTIDADE DO PRODUTO CARRINHO POR ID.
	public String removerDoCarrinho(int id, Integer quantidade) {
		Carrinho cart = cartId(id);		
		if (cart == null) {
			return "Não existe";
		} else if (cart.getQuantidade() < quantidade) {
			return "Não tem essa quantidade";
		} else if (quantidade <= 0) {
			return "Quantidade inválida";
		} else{
	    	 cart.setQuantidade((int) (cart.getQuantidade() - quantidade));
			 carrinho.save(cart);	
			 return "Removido : " + quantidade.toString() + " unidade do produto.";
		}  
	  }

	//ATUALIZA QTD DO PRODUTO NO CARRINHO
	public String atualizarCarrinho(String sku, Integer quantidade) {		
		Carrinho cart = pCarrihno(sku);
		String msg = "";
		if(cart.getSku().equals(sku)) {
			cart.setQuantidade((int) (cart.getQuantidade() + quantidade));
			cart.setTotal(cart.getQuantidade() * cart.getValor());
			carrinho.save(cart);
			msg =  "Adicionado : " + quantidade.toString() + " unidade do produto.";
		}
		return msg;
	}


	
	 //DELETA PRODUTO DO CARRINHO
	public String delProdDoCarrinho(Integer id) {
		Product produto = productId(id);
		String msg = "";
		if(produto.equals(null)) {
			msg = "Não exite o Produto";
		}else {
			carrinho.deleteById(produto.getId());
			msg = "Produto removido";
		}
		return msg;
	}

	// DELETA TODOS OS PRODUTOS DO CARRINHO.
		public String removeCart() {
		  carrinho.deleteAll();
		  return "Carrinho vazio";
		}

}

