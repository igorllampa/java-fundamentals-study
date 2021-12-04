package collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetCaseStudy {
	
	public void imprimirSet() {
		
		//HashSet não permite adicionar dois ou mais elementos iguais. Caso seja inserido, apenas um será armazenado
		//HashSet não garante a ordem
		Set<String> set = new HashSet<>();
		set.add("React");
		set.add("Angular");
		set.add("Vue.js");
		set.add("Vue.js");
		set.add("Vue.js");
		set.add("Vue.js");
		set.add("Vue.js");
		
		
		System.out.println("Imprimir Hash Set com for enhanced");
		for(String str : set) {
			System.out.println(str);
		}
		
		
		System.out.println("Imprimir Hash Set com iterator");
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());			
		}
		
		//LinkedHashSet não permite adicionar dois ou mais elementos iguais
		//Garante a ordem de insercao
		Set<String> setLinked = new LinkedHashSet<>();
		setLinked.add("HTML");
		setLinked.add("CSS");
		setLinked.add("CSS");
		setLinked.add("CSS");
		setLinked.add("CSS");				
		setLinked.add("JS");
		
		System.out.println("Imprimir o LinkedHashSet com for enhanced");
		for(String str : setLinked) {
			System.out.println(str);
		}
		
		System.out.println("Imprimir o LinkedHashSet com iterator");
		Iterator<String> iterator2 = setLinked.iterator();
		while(iterator2.hasNext()) {
			System.out.println(iterator2.next());
		}
		
		//Tree Set nao permite adicionar dois ou mais elementos iguais
		//Tree Set faz a ordenação (No caso do tipo String faz a ordenação alfabética por padrao)
		Set<String> setTree = new TreeSet<>();
		setTree.add("Json");
		setTree.add("XML");
		setTree.add("YAML");
		setTree.add("Plain Text");		
		setTree.add("XHTML");
		setTree.add("Json");
		
		System.out.println("Imprimir o Tree set com o for enhanced");
		for(String str : setTree) {
			System.out.println(str);
		}
		
		System.out.println("Imprimir o Tree set com o iterator");
		Iterator<String> iterator3 = setTree.iterator();
		while (iterator3.hasNext()) {
			System.out.println(iterator3.next());			
		}
	}

}
