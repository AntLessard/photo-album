package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dogs.controller.WelcomeController;

class WelcomeControllerTest {
	
	DogControllerMock dogController;
	
	WelcomeController controller;
	
	@BeforeEach
	public void initializeMocks() {
		dogController = new DogControllerMock();
		controller = new WelcomeController(dogController);
	}
	
	@Test
	public void WHEN_RegisterDogButtonIsPressed_THEN_goToCreateMethodIsCalled() {
		
		controller.wantToCreateDog();
		
		assertTrue(dogController.goToCreateMethodHasBeenCalled());
	}

	@Test
	public void ShowListDogButtonIsPressed_THEN_wantToShowListMethodIsCalled() {
		controller.wantToShowListDogs();
		
		//assertTrue(dogController.goToShowListMethodHasBeenCalled());
	}
	
}
