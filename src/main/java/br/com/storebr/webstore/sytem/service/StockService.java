package br.com.storebr.webstore.sytem.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.storebr.webstore.sytem.model.Product;
import br.com.storebr.webstore.sytem.repository.ProductyRepository;
import jakarta.transaction.Transactional;

@Service
public class StockService {
 
	
  @Autowired
  private ProductyRepository product;
	

 //LISTA PRODUTOS NO ESTOQUE
  public List<Product> listItems() {
		return product.findAll();
  }
	
// PROCURAR PRODUTO POR ID.
	public Product procurarProduto(Integer id) {
		return product.findById(id);
	}
	
	// PROCURAR PRODUTO POR SKU.
	public Product searchSku(String sku) {
		return product.findBySku(sku);
	}

	// CADASTRAR PRODUTO NO STOQUE.
	

	
	public String registrarProduto(Product produto) {
		String msg = null;
				if (produto.getCategoria() == null || produto.getDepartamento() == null || produto.getCor() == null
						|| produto.getDescricao() == null || produto.getTamanho() == null) {
					msg = "1";
				}else {					
					Product produtoSku = searchSku(produto.getSku());
					if (produtoSku == null && produto.getQuantidade() > 0) {
						product.save(produto);
						msg = "3";
					} else {
						msg = "2";
					}
				}
				return msg;		
	}

	// ATUALIZAR PRODUTO EM ESTOQUE PELO SKU.
	public String atualizarProduto(int id, Product prod) {
		String msg = null;
		prod.setId(id);
		boolean atlprod = true;
		if(atlprod) {
			product.save(prod);
			msg = "Produto atualizado";
		}else {
			msg = "produto nao atualizado";
		}
		return msg;
	}



	// EXCLUIR PRODUTO DO ESTOQUE.
	@Transactional
	public String deleteProduct(int id, Product productDel) {	
		String msg = "Erro";
		productDel.setId(id);
		boolean productde = true;
		if(productde) {
			product.delete(productDel);
			msg = "Excluido";			
		}else {
			msg ="Erro ao excluir";			
		}			
		return msg;

	}

}
