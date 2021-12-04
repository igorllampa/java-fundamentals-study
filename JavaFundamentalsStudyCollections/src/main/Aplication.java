package main;
import collections.ArrayCase;
import collections.ListCaseStudy;
import collections.MapCaseStudy;
import collections.SetCaseStudy;
import collections.VarargsCaseStudy;

public class Aplication {

	public static void main(String[] args) {
		
		System.out.println("Testing Collections:");		
		ArrayCase arrayCase = new ArrayCase();
		arrayCase.exampleArrayInt();
		
		
		System.out.println("Testing Variable Arguments - Varargs");
		VarargsCaseStudy varargsCaseStudy = new VarargsCaseStudy();
		varargsCaseStudy.imprimirNomes("João", "José", "Maria");
		
		String[] arrayNomes = {"Maria", "José", "Felipe"};		
		varargsCaseStudy.imprimirNomes(arrayNomes);
		
		System.out.println("Testing Lists:");
		ListCaseStudy listCaseStudy = new ListCaseStudy();
		listCaseStudy.imprimirLista();
		
		System.out.println("Testing Sets:");
		SetCaseStudy setCaseStudy = new SetCaseStudy();
		setCaseStudy.imprimirSet();
		
		System.out.println("Testing Map:");
		MapCaseStudy mapCaseStudy = new MapCaseStudy();
		mapCaseStudy.imprimirMap();
			
	}
}
