package br.com.storebr.webstore.sytem.enums;

import java.util.Map;
import java.util.HashMap;

public enum CorEnum {
	AZUL("AZ"),
	VERDE("VE"),
	AMARELO("AM"),
	PRETO("PR");
 	
//	private String cor;
    private String descricao;
    
    private static final Map<String, CorEnum>getCor = new HashMap<>();
    
    CorEnum(String descricao) {
    	//this.cor = cor;
    	this.descricao = descricao;
      }

//    public String getCor() {
//    	return cor;
//    }
    
    public String getDescricao() {
    	return descricao;
    	
    }
    static {
    	for (CorEnum cor: CorEnum.values() ) {
    		getCor.put(cor.getDescricao(), cor);
    	}
    	
    }
    public static CorEnum getCorEnum(String descricao) {
    	return getCor.get(descricao); 
    	
    }
    
}
