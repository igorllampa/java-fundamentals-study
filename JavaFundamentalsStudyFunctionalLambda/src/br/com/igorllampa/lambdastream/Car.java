package br.com.igorllampa.lambdastream;

public class Car {
	
	private String brand;
	private double price;
	
	
	public Car(String brand, double price) {
		this.brand = brand;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void addTax() {
		price = price += price * 0.1;
		
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + "]";
	}
}
