package dogs.model;

import java.util.Collection;

public interface IDogRepository {
	void add(Dog newDog);
	
	Collection<Dog> getList();
	
	int size();
	
	Dog searchById(int id);
	
	Collection<Dog> searchByName(String name);
}
