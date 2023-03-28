package br.com.storebr.webstore.sytem.service;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.storebr.webstore.sytem.model.Carrinho;
import br.com.storebr.webstore.sytem.model.Pessoas;
import br.com.storebr.webstore.sytem.model.Product;
import br.com.storebr.webstore.sytem.model.Venda;
import br.com.storebr.webstore.sytem.repository.CarrinhoRepository;
import br.com.storebr.webstore.sytem.repository.PessoaRepository;
import br.com.storebr.webstore.sytem.repository.ProductyRepository;
import br.com.storebr.webstore.sytem.repository.VendaRepository;
import jakarta.transaction.Transactional;



@Service
@Transactional
public class VendasService {
	
//@Autowired	
//private ProductyRepository lista;
//
//
////    private final HistoricoRepository historicoRepository;
////	private final EstoqueRepository estoqueRepository;
////	private StockService service;
////	private HistoricoVendas historico = new HistoricoVendas();
////
//	
	@Autowired
	private ProductyRepository producty;
	@Autowired
	private CarrinhoRepository carrinho;
	@Autowired
	private VendaRepository venda;	
	@Autowired
	private PessoaRepository pessoa;
	
	private Product produto;
	
	//LISTA PRODUTOS NO CARRINHO.
	public List<Product> listProducty() {
		return producty.findAll();
	}
	public List<Pessoas> listPesoas() {
		return pessoa.findAll();
	}
	
	public List<Carrinho> listCart() {
		return carrinho.findAll();
	}
	
	public List<Venda> listVendas() {
		return venda.findAll();
	}
	
	// VERIFCA PRODUTO NO CARRINHO PELO ID
	public Carrinho cartId(int id) {
		return carrinho.findById(id);
	}
	public Product productId(int id) {
		return producty.findById(id);
	}
	
	public Pessoas pessoaId(int id) {
		return pessoa.findById(id);
	}
	
	public Pessoas pessoaCpf(String cpf) {
		return pessoa.findByCpf(cpf);
	}
	
//	public Product productSku(String sku) {
//		return producty.findBySku(sku);
//	}
//	
//	public Carrinho pCarrihno(String sku) {		
//		return carrinho.findBySku(sku);
//	}
	
	
//////// FINALIZANDO VENDA.
//public String checkoutSales(String cpf, Integer pagamento, Prodcut produto) {
//	String msg;
//	if (!lista.isEmpty()) {
//		if (tirandoProdutoDoEstoque() == "Concluído") {
//			venda = new Venda(valorFinal(), cpf, pagamento);
//			venda.setProdutos(lista);
//			historicoRepository.save(venda);
//			esvaziarCarrinho();
//			msg = "Venda concluida";
//		} else {
//			msg = "Venda cancelada";
//		}
//	} else {
//		msg = "Carrinho Vazio!";
//	}
//	return msg;
//}
		
	  // RETIRANDO PRODUTO DO ESTOQUE ao concluir a venda.
	  public String saveSales(Integer id, String cpf) {		 
		  String msg = null;
		  for(Carrinho cart : listCart()) {
			  Pessoas pessoa = pessoaId(id);
			  LocalDateTime agora = LocalDateTime.now(); 
			  List<Product> produt = listProducty();
				Venda sales = new Venda();
				sales.setQuantidade(cart.getQuantidade());
				sales.setCpf(cpf);
				sales.setDescricao(cart.getDescricao());
				sales.setTotal(cart.getTotal()+ cart.getValor());
				sales.setProduct(produt.get(0));
				sales.setPessoas(pessoa);
				sales.setDescricao(cart.getDescricao());
				sales.setData(agora);
				sales.setIdCompra("#"+id+id+1);
				venda.save(sales);
				msg = "venda cadastra";
		  }
		  
//			if(produto.getQuantidade() < ((Carrinho) cart).getQuantidade()) {
//				carrinho.deleteById(id);				
//				msg = "Produto removido do carrinho";
//			}else {
//				produto.setQuantidade((int) (produto.getQuantidade() - ((Carrinho) cart).getQuantidade()));			
//				Venda sales = new Venda();
//				sales.setQuantidade(((Carrinho) cart).getQuantidade());
//				sales.setCpf(pessoa.getCpf());
//				sales.setDescricao(((Carrinho) cart).getDescricao());
//				sales.setTotal(((Carrinho) cart).getQuantidade() * ((Carrinho) cart).getValor());
//				sales.setProduct(produto);
//				sales.setPessoas(pessoa);
//				sales.setDescricao(msg);
				//venda.save(cart);
				//producty.save(produto);
//				msg = "Produto adicionado a venda";
//			}
			return msg;
		//}
		
	}
	  
	  
//produto.setQuantidade((int) (produto.getQuantidade() - quantidade));


	

	
	
////
////	// RETIRANDO PRODUTO DO ESTOQUE.
////	public String tirandoProdutoDoEstoque() {
////		Product stockProduct;
////		Product cartProduct;
////		String msg = "Concluído";
////		for (int x = 0; x < lista.size(); x++) {
////			cartProduct = lista.get(x);
////			stockProduct = estoqueRepository.findBySku(cartProduct.getSku());
////			if (stockProduct != null && cartProduct.getQuantidade() < stockProduct.getQuantidade()) {
////				stockProduct.setQuantidade(stockProduct.getQuantidade() - cartProduct.getQuantidade());
////			} else if (stockProduct != null && cartProduct.getQuantidade() == stockProduct.getQuantidade()) {
////				estoqueRepository.delete(stockProduct);
////			} else {
////				esvaziarCarrinho();
////				msg = "Operação cancelada";
////				break;
////			}
////		}
////		return msg;
////	}
////
////	// VALOR TOTAL DA COMPRAR.
	public double valorFinal() {
		Double valorFinal = 0.0;
		for (int x = 0; x < listCart().size(); x++) {
			valorFinal = valorFinal + (listCart().get(x).getValor() * listCart().get(x).getQuantidade());
		}
		return valorFinal;
	}
////
////	// DELETA DOS OS PRODUTOS DO CARRINHO.
////	public String esvaziarCarrinho() {
////		lista.removeAll(lista);
////		return "Carrinho Vazio.";
////	}
////
////	// LISTA HISTORICO DE VENDA FINALIZADA.
////	public List<Venda> getVendas() {
////		List<Venda> vendaDto = new ArrayList<>();
////		for(Venda venda : historicoRepository.findAll()) {
////			vendaDto.add(venda);
////		}
////		return vendaDto;
////	}
//

	
	
	
//	// VALOR TOTAL DA COMPRAR.
//	public double valorFinal() {
//		Double valorFinal = 0.0;
//		for (int x = 0; x < lista.size(); x++) {
//			valorFinal = valorFinal + (lista.get(x).getValor() * lista.get(x).getQuantidade());
//		}
//		return valorFinal;
//	}
//
	
//
//	// LISTA HISTORICO DE VENDA FINALIZADA.
//	public List<Venda> getVendas() {
//		List<Venda> vendaDto = new ArrayList<>();
//		for(Venda venda : historicoRepository.findAll()) {
//			vendaDto.add(venda);
//		}
//		return vendaDto;
//	}

}
