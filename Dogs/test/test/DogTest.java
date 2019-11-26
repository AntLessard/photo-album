package test;

import org.junit.jupiter.api.BeforeEach;

import dogs.model.Dog;

public class DogTest {
	
	private final String ANY_NAME = "Ben";
	private final String ANY_BREED = "Berger";
	
	Dog dog;
	
	@BeforeEach
	public void initializeDog() {
		dog = new Dog(ANY_NAME, ANY_BREED);
	}
	/*
	@Test
	public void WHEN_DogIsCreated_T
	*/
}
