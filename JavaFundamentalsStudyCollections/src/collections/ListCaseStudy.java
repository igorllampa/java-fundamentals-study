package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListCaseStudy {

	public void imprimirLista() {
		System.out.println("Lista.....");
		
		List<String> list = new ArrayList<String>(); //ou usar apenas: new ArrayList<>(); //Notacao diamond
		
		list.add("C#");//Insere no final da lista
		list.add("PHP");//Insere no final da lista
		list.add("Java");//Insere no final da lista
		list.set(1, "Pascal/Delphi");//Insere em posição especifica
		
		//Imprimir usando o for enhanced
		System.out.println("Utilizando for enhanced:");
		for(String str : list) {
			System.out.println(str);
		}
		
		//Imprimir usando o for padrao
		System.out.println("Utilizando o for padrão:");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		//Utilizar o Iterator
		System.out.println("Utilizando o for padrão:");
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}
	
}
