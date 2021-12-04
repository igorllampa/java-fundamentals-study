package collections;

import java.util.Random;

public class ArrayCase {

	public void exampleArrayInt() {
		
		
		System.out.println("Array de inteiros:");
		
		//Declaration
		int[] array = new int[5];
				
		
		System.out.println("Utilizando for:");
		
		//Percorrer e preencher com dados
		for(int i=0; i < array.length; i++) {
			array[i] = i+100;
		}
		
		//Percorrer e exibir
		for(int i=0; i < array.length; i++) {			
			System.out.println(array[i]);
		}
		
		System.out.println("Utilizando enhanced for:");				
		//Outra forma de percorrer e exibir: enhanced for
		for(int x : array) {
			System.out.println(x);
		}
				
		
		System.out.println("Array String:");
		String[] arrayStr = new String[10];
		
		for(int i=0; i<arrayStr.length; i++) {
			arrayStr[i] = "Testing:"+String.valueOf(i);			
		}
		for(String str : arrayStr) {
			System.out.println(str);
		}		
	
		
		System.out.println("Array multimensionais");
		int[][] arrayNumeros = new int[10][3];
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 3; j++) {
				arrayNumeros[i][j] = i+j-i; 
			}
		}
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 3; j++) {
				  
				 System.out.print(" ["+arrayNumeros[i][j]+"] ");
			}
			System.out.println("");
		}
		
		
	}
}
