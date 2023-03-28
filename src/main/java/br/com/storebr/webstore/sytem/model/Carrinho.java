package br.com.storebr.webstore.sytem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Carrinho")
public class Carrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String descricao;
	private double valor;
	private Double total;
	private Integer quantidade;
	private String sku; 	
	
	public Carrinho() {
		
	}
	
	public Carrinho (Product produto){
		this.valor = produto.getValor();
		this.descricao = produto.getDescricao();
		this.quantidade = produto.getQuantidade();
		this.sku = produto.getSku();
	}
	
	public Carrinho(String descricao, double valor, Double total, Integer quantidade) {
		this.descricao = descricao;
		this.valor = valor;
		this.total = total;
		this.quantidade = quantidade;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	@Override
	public String toString() {
		return "Carrinho [id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", total=" + total
				+ ", quantidade=" + quantidade + ", sku=" + sku + "]";
	}
}
