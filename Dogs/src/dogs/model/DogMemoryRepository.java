package dogs.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DogMemoryRepository implements IDogRepository{

	private Map<Integer, Dog> dogs = new HashMap<Integer, Dog>();
	
	private int nextId = 1;
	
	@Override
	public void add(Dog newDog) {
		dogs.put(nextId, newDog);
		nextId++;
	}
	
	@Override
	public Collection<Dog> getList(){
		return this.dogs.values();
	}
	
	@Override
	public int size() {
		return this.dogs.size();
	}
	
	@Override
	public Dog searchById(int id) {
		return null;
	}

	@Override
	public Collection<Dog> searchByName(String name) {
		return null;
	}

}
