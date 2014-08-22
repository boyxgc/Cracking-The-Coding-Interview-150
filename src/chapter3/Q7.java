package chapter3;

import java.util.LinkedList;
import java.util.List;

/**
 * An animal shelter holds only dogs and cats, and operates on a strictly
 * "first in, first out" basis. People must adopt either the oldest(based on
 * arrival time) of the all animals at the shelter, or they can choose a type
 * (they will receive the oldest of that type). They cannot choose a specific
 * animal. Create a data structure to maintain this system and implement
 * operations such as enqueue, dequeueAny, dequeueDog and dequeueCat
 * 
 * @author boyxgc
 * 
 */
public class Q7 {

	public class DogCatShelter {
		private List<Dog> dogs;
		private List<Cat> cats;

		public DogCatShelter() {
			dogs = new LinkedList<Dog>();
			cats = new LinkedList<Cat>();
		}

		public void enqueue(Animal animal) {
			animal.setArricalDate(System.currentTimeMillis());
			if (animal instanceof Dog) {
				dogs.add((Dog) animal);
			} else if (animal instanceof Cat) {
				cats.add((Cat) animal);
			} else {
				throw new RuntimeException("Unspported animal type: "
						+ animal.getClass());
			}
		}

		public Animal dequeueAny() {
			if (dogs.isEmpty() && cats.isEmpty()) {
				return null;
			} else if (dogs.isEmpty()) {
				return cats.remove(0);
			} else if (cats.isEmpty()) {
				return dogs.remove(0);
			} else {
				if (cats.get(0).isEarlier(dogs.get(0))) {
					return cats.remove(0);
				} else {
					return dogs.remove(0);
				}
			}
		}

		public Dog dequeueDog() {
			if (dogs.isEmpty()) {
				return null;
			}
			return dogs.remove(0);
		}

		public Cat dequeueCat() {
			if (cats.isEmpty()) {
				return null;
			}
			return cats.remove(0);
		}
	}

	public class Animal {
		public String name;
		public long arrivalDate;

		public Animal(String _name) {
			name = _name;
		}

		public void setArricalDate(long _arrivalDate) {
			arrivalDate = _arrivalDate;
		}

		public boolean isEarlier(Animal otherAnimal) {
			return arrivalDate < otherAnimal.arrivalDate;
		}
	}

	public class Dog extends Animal {

		public Dog(String _name) {
			super(_name);
		}

	}

	public class Cat extends Animal {

		public Cat(String _name) {
			super(_name);
		}
	}

	public static void main(String[] args) {
		Q7 q7 = new Q7();
		DogCatShelter shelter = q7.new DogCatShelter();
		shelter.enqueue(q7.new Dog("dog1"));
		shelter.enqueue(q7.new Dog("dog2"));
		shelter.enqueue(q7.new Cat("cat1"));
		shelter.enqueue(q7.new Dog("dog3"));
		shelter.enqueue(q7.new Cat("cat2"));

		System.out.println("Adopt a dog: " + shelter.dequeueDog().name);
		System.out.println("Adopt a cat: " + shelter.dequeueCat().name);
		System.out.println("Adopt any: " + shelter.dequeueAny().name);
	}
}
