package br.com.storebr.webstore.sytem.model;
import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.storebr.webstore.sytem.enums.Pagamentos;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Venda")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double total;
	@OneToOne
	private Product product;
	@OneToOne
	private Pessoas pessoas;
	private String idCompra;
	private String descricao;
	private String Cpf;
	private Double quantidade;
	private LocalDateTime data;
	private Pagamentos pagamentoEnum;


	
	public Venda() {
		
	}

	
	public Venda(Integer id, Double total, Product product, Pessoas pessoas, String descricao, String cpf,
			Double quantidade, Pagamentos pagamentoEnum) {
		this.id = id;
		this.total = total;
		this.product = product;
		this.pessoas = pessoas;
		this.descricao = descricao;
		Cpf = cpf;
		this.quantidade = quantidade;
		this.pagamentoEnum = pagamentoEnum;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Double getTotal() {
		return total;
	}



	public void setTotal(Double total) {
		this.total = total;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public Pessoas getPessoas() {
		return pessoas;
	}



	public void setPessoas(Pessoas pessoas) {
		this.pessoas = pessoas;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public String getCpf() {
		return Cpf;
	}



	public void setCpf(String cpf) {
		Cpf = cpf;
	}



	public Double getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDateTime getData() {
		return data;
	}


	public void setData(LocalDateTime data) {
		this.data = data;
	}


	public Pagamentos getPagamentoEnum() {
		return pagamentoEnum;
	}



	public void setPagamentoEnum(Pagamentos pagamentoEnum) {
		this.pagamentoEnum = pagamentoEnum;
	}


	public String getIdCompra() {
		return idCompra;
	}


	public void setIdCompra(String string) {
		this.idCompra = string;
	}


	@Override
	public String toString() {
		return "Venda [id=" + id + ", total=" + total + ", product=" + product + ", pessoas=" + pessoas + ", idCompra="
				+ idCompra + ", descricao=" + descricao + ", Cpf=" + Cpf + ", quantidade=" + quantidade + ", data="
				+ data + ", pagamentoEnum=" + pagamentoEnum + "]";
	}

	
}
