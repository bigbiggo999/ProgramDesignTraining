package homework;

import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Pet> petList = new ArrayList<>();
		Pet cat = new Cat();
		Pet dog = new Dog();
		petList.add(cat);
		petList.add(dog);
		for(Pet pet : petList) {
			pet.say();
			pet.run();
			if(pet instanceof Cat) {
				((Cat) pet).catchMouse();
			}
			if(pet instanceof Dog) {
				((Dog) pet).swim();
			}
		}
		
		GirlFriend gf1 = new GirlFriend(cat);
		GirlFriend gf2 = new GirlFriend(dog);
		
		((Cat)gf1.getPet()).catchMouse();
		((Dog)gf2.getPet()).swim();
	}

}
