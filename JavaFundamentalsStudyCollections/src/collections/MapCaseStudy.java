package collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapCaseStudy {
	
	private String status = "Teste";
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void imprimirMap(){
		
		
		System.out.println("Test with HashMap:");
		Map<Integer, String> map = new HashMap<>();//O Hash Map não garante a ordem de insercao
		
		
		map.put(1, "JavaScript");
		map.put(2, "HTML5");
		map.put(3, "JSON");
		map.put(3, "PHP");//Obs: No Map as chaves são únicas, e quando há repeticao o valor é sobrescrito
		
		
		System.out.println("Iterando sob as chaves:");
		Set<Integer> set = map.keySet();
		for(int chave : set) {
			System.out.println("Chave: "+chave + " - Valor:"+map.get(chave));
		}
		
		System.out.println("Iterando sob os valores:");
		Collection<String> valores = map.values();
		for(String valor : valores) {
			System.out.println(" ->"+valor);
		}
		
		System.out.println("Iterando sob os pares chave/valor:");
		Set<Map.Entry<Integer, String>> conjunto = map.entrySet();
		for(Map.Entry<Integer, String> item : conjunto) {
			System.out.println("[Chave]: " + item.getKey() + " -> "+item.getValue());
		}
		
		
		System.out.println("Test with LinkedHashMap: ");
		Map<String, Double> mapPesos = new LinkedHashMap<>();//Garante a ordem de insercao
		mapPesos.put("Igor", 70.5);
		mapPesos.put("Fernanda", 56.2);
		mapPesos.put("Teste", 75.1);
		
		Set<Map.Entry<String, Double>> conjuntoPesos = mapPesos.entrySet();
		for(Map.Entry<String, Double> item : conjuntoPesos) {
			System.out.println("["+item.getKey()+"] = "+item.getValue());
			
		}
		
		System.out.println("Test with TreeMap: ");
		Map<String, Integer> listaCompras = new TreeMap<>();//Garante a ordenação
		listaCompras.put("Coca-Cola - Garrafa 600 ml", 3);
		listaCompras.put("Suco Laranja", 2);
		listaCompras.put("Cheirinho Casa", 1);
		Set<Map.Entry<String, Integer>> itensCompra  = listaCompras.entrySet();
		for(Map.Entry<String, Integer> itemCompra : itensCompra) {
			System.out.println("["+itemCompra.getKey()+"] => qtde: " + itemCompra.getValue()+" UN");
		}
		
		
		
		
	
		
		
	}

}
