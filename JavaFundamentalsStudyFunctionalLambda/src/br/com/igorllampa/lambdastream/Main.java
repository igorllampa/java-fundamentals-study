package br.com.igorllampa.lambdastream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

	private static final Map<String, Integer> PEOPLE = Map.of("pedro", 15, "maria", 20, "paulo", 25, "jorge", 10);
	
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
		
		System.out.println(get("josé"));//nao existe
		
		Optional<Integer> opt = get("pedro");
		int idade = opt.orElse(0);
		System.out.println(idade);
		
		int idade2 = opt.orElseThrow(() -> new IllegalArgumentException("Nome inexistente"));//Opcao 01
		idade2 = opt.orElseThrow(IllegalArgumentException::new);//Opcao 02

		opt = get("pedro2");
		
		opt.ifPresent(i -> System.out.println("A idade "+i+" foi encontrada!"));
		opt.ifPresentOrElse(i -> System.out.println("A idade "+i+" foi encontrada!!"), 
				           () -> System.out.println("Não encontrado"));
		
		int multi = 2;
		IntStream.range(1, 21)
			.map(i -> i * 2)
			.forEach(System.out::println);
		
		int[] array = List.of(3, 2, 11, 5, 1, 2, 10).stream().mapToInt(i -> i.intValue()).toArray();
		System.out.println(multiply(array));
		
		System.out.println("O maior elemento é: "+max(array));
		
		String str = "ACBA";
		
		String result = str.chars()
			.map(i -> i-64)
			.mapToObj(String::valueOf)
			.collect(Collectors.joining("-", "[", "]"));
		
		System.out.println(result);
	}
	
	private static Optional<Integer> get(String name) {
		return  Optional.ofNullable(PEOPLE.get(name));
	}
	
	private static int multiply(int[] array) {
		return Arrays.stream(array).reduce((x,y) -> x * y).orElse(0);
	}
	
	private static int max(int[] array) {
		return Arrays.stream(array).reduce((x,y) -> (x > y) ? x : y).orElse(0);
	}

}
