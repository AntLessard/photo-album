package test;

import java.util.Collection;

import dogs.model.Dog;
import dogs.model.IDogRepository;

public class DogMemoryRepositoryMock implements IDogRepository{

	public boolean addMethodHasBeenCalled = false;
	public boolean getListMethodHasBeenCalled = false;
	public boolean sizeMethodHasBeenCalled = false;
	public boolean searchByIdMethodHasBeenCalled = false;
	public boolean searchByNameMethodHasBeenCalled = false;
	

	@Override
	public void add(Dog newDog) {
		this.addMethodHasBeenCalled = true;
		
	}

	public boolean addMethodHasBeenCalled() {
		return this.addMethodHasBeenCalled;
		
	}

	@Override
	public Collection<Dog> getList() {
		getListMethodHasBeenCalled = true;
		return null;
	}

	public boolean getListMethodHasBeenCalled() {
		return this.getListMethodHasBeenCalled;
	}

	@Override
	public int size() {
		this.sizeMethodHasBeenCalled = true;
		return 0;
	}

	public boolean sizeMethodHasBeenCalled() {
		return this.sizeMethodHasBeenCalled;
	}

	@Override
	public Dog searchById(int id) {
		this.searchByIdMethodHasBeenCalled = true;
		return null;
	}

	public boolean searchByIdMethodHasBeenCalled() {
		return this.searchByIdMethodHasBeenCalled;
	}

	@Override
	public Collection<Dog> searchByName(String name) {
		this.searchByNameMethodHasBeenCalled = true;
		return null;
	}

	public boolean searchByNameMethodHasBeenCalled() {
		return this.searchByNameMethodHasBeenCalled;
	}

}
