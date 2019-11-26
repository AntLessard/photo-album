package test;

import dogs.controller.IDogController;
import dogs.dto.DogDTOForCreate;

public class DogControllerMock implements IDogController{

	boolean goToCreateMethodHasBeenCalled = false;
	boolean addMethodHasBeenCalled = false;
	
	public boolean goToCreateMethodHasBeenCalled() {
		return this.goToCreateMethodHasBeenCalled;
	}
	
	public boolean addMethodHasBeenCalled() {
		return this.addMethodHasBeenCalled;
	}

	@Override
	public void goToCreate() {
		this.goToCreateMethodHasBeenCalled = true;
		
	}
	
	@Override
	public void add(DogDTOForCreate dogToCreate) {
		this.addMethodHasBeenCalled = true;
	}

	@Override
	public void goToShowList() {
		// TODO Auto-generated method stub
		
	}

}
