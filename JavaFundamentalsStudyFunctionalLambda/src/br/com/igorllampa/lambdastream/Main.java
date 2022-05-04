package br.com.igorllampa.lambdastream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>(List.of(5, 3, 4, 1, 2));
		
		//Modo 01: tradicional, criando uma classe para comparacao
		NumberComparator comparator = new NumberComparator();		
		numbers.sort(comparator);
		System.out.println(numbers);
				
		
		//Modo 02: tradicional, usando uma classe anonima
		numbers = new ArrayList<>(List.of(5, 3, 4, 1, 2));
		Comparator<Integer> comparator2 = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}			
		};
		numbers.sort(comparator2);			
		System.out.println(numbers);
		
		//Modo 03: com expressao lambda
		numbers = new ArrayList<>(List.of(5, 3, 4, 1, 2));
		Comparator<Integer> comparator3 = (o1,o2) -> o1.compareTo(o2);
		numbers.sort(comparator3);
		System.out.println(numbers);
		
		//Modo 03: com expressao lambda
		numbers = new ArrayList<>(List.of(5, 3, 4, 1, 2));		
		numbers.sort((o1,o2) -> o1.compareTo(o2));
		System.out.println(numbers);
	
		//Exemplo: Interface Funcional
		Operator op = (x,y) -> x * y;		
		System.out.println(op.execute(5, 2));
		System.out.println(op.execute(4, 3));
		
		Operator op2 = (x,y) -> {
			int r = x + y;
			int s = x * y;
			return r * s;
		};		
		System.out.println(op2.execute(4, 8));
		
		
		//Exemplo de uso da expressao lambda com StreamAPI
		List<String> words = List.of("CARLOS", "JOSÉ", "JOÃO", "JOANA", "MARIA", "CELSO");
		List<String> filteredWords = words.stream()
			.filter(w -> w.startsWith("J"))
			.map(w -> w.toLowerCase())
			.collect(Collectors.toList());
		
		System.out.println(filteredWords);
		
		filteredWords.forEach(w -> System.out.println(w));
		
		words.stream()
				.filter(w -> w.startsWith("J"))
				.map(w -> w.toLowerCase())
				.forEach(w -> System.out.println(w));
		
		List<String> filteredWords2 = words.stream()
				.filter(w -> w.startsWith("J"))
				//.map(w -> w.toLowerCase())
				.map(String::toLowerCase)
				.collect(Collectors.toList());
		//filteredWords2.forEach(w ->System.out.println(w));
		filteredWords2.forEach(System.out::println);
		
		
		
		List<Car> cars = List.of(new Car("BMW", 120000), new Car("Renault", 85000), new Car("VW", 70000));
		cars.stream()
			.sorted((c1,c2) -> Double.valueOf(c1.getPrice()).compareTo(c2.getPrice()))
			.map(c -> new Car(c.getBrand().toLowerCase(), c.getPrice()))
			.peek(Car::addTax)
			.forEach(System.out::println);
		
	}

}
