package ames.p8;

// 업케스팅 다운 케스팅

public class Animal {

	public String noise() {
		return "peep";
	}

	public static void main(String[] args) {
		Animal animal = new Dog();
		Cat cat = (Cat) animal;
		System.out.println(cat.noise());

	}
}

class Dog extends Animal {


}

class Cat extends Animal {


}
