package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dogs.controller.DogController;
import dogs.dto.DogDTOForCreate;

class DogControllerTest {

	private final String ANY_NAME = "Ben";
	private final String ANY_BREED = "Berger";
	
	@Test
	public void WHEN_AddDogButtonIsPressed_THEN_addMethodIsCalled() {
		DogDTOForCreate dogToAdd = new DogDTOForCreate(ANY_NAME, ANY_BREED);
		
		DogMemoryRepositoryMock repository = new DogMemoryRepositoryMock();
		DogController controller = new DogController(repository);
		controller.add(dogToAdd);
		
		assertTrue(repository.addMethodHasBeenCalled());
	}
}
