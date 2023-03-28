package br.com.storebr.webstore.sytem.enums;

import java.util.HashMap;
import java.util.Map;

public enum Pagamentos {
	
	
	CREDITO(1),
	DEBITO(2),
	PIX(3),
	DINHEIRO(4);
	
   private static final Map<Integer, Pagamentos>getPagamentos = new HashMap<>();
   private Integer codigo;
    
      Pagamentos(Integer codigo) {
    	this.codigo = codigo;
      }
    
    public Integer getPagamentos() {
    	return codigo;
    	
    }
    
    static {
    	for (Pagamentos pagamento : Pagamentos.values() ) {
    		getPagamentos.put(pagamento.getPagamentos(), pagamento);
    	}
    	
    }
    public static Pagamentos getPagamentos(Integer codigo) {
    	return getPagamentos.get(codigo); 
    	
    }

}
