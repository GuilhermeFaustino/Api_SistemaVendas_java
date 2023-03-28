package br.com.storebr.webstore.sytem.model;

import br.com.storebr.webstore.sytem.enums.CategoriaEnum;
import br.com.storebr.webstore.sytem.enums.CorEnum;
import br.com.storebr.webstore.sytem.enums.DepartamentoEnum;
import br.com.storebr.webstore.sytem.enums.TamanhoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Product")
public class Product {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;	
	private String sku;
	private Integer quantidade;
	private Double valor;
	private String descricao;
	@Enumerated(EnumType.STRING)
	private DepartamentoEnum departamento;	
	@Enumerated(EnumType.STRING)
	private CategoriaEnum categoria;
	@Enumerated(EnumType.STRING)
	private CorEnum cor;
	@Enumerated(EnumType.STRING)
	private TamanhoEnum tamanho;
	
	

    public Product() {
    	
    }
    
	public Product(String sku, Integer quantidade, Double valor, String descricao) {
		this.sku = sku;
		this.quantidade = quantidade;
		this.valor = valor;
		this.descricao = descricao;
		//dados();
	}
	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Enumerated(EnumType.STRING)
	public DepartamentoEnum getDepartamento() {
		return departamento;
	}

	@Enumerated(EnumType.STRING)
	public CategoriaEnum getCategoria() {
		return categoria;
	}
	@Enumerated(EnumType.STRING)
	public CorEnum getCor() {
		return cor;
	}
 
	@Enumerated(EnumType.STRING)
	public TamanhoEnum getTamanho() {
		return tamanho;
	}

  
//	public void dados() {
//		 this.categoria = CategoriaEnum.getCategoriaEnum(sku.substring(0,3));
//		 this.cor = CorEnum.getCorEnum(sku.substring(3,5)); 
//		 this. departamento = DepartamentoEnum.getDepartamentoEnum(sku.substring(5,8));
//         this.tamanho = TamanhoEnum.getTamanhoEnum(sku.substring(8));
//	}
   @Override
    public String toString() {
	return "\nSKU:" + sku + "\nQuantidade:" +quantidade +"\nValor:" + valor + "\nDescricao:" +descricao + 
			", " + categoria + ", " + cor + "," + departamento + ", " + tamanho + "\n";
  } 
  
}









