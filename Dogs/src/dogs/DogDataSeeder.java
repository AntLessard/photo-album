package dogs;

import dogs.model.Dog;
import dogs.model.IDogRepository;

public class DogDataSeeder {
	
	private IDogRepository repository;
	
	public DogDataSeeder(IDogRepository repository) {
		this.repository = repository;
		this.seedTable();
	}

	private void seedTable() {
		this.repository.add(new Dog("Django", "batard"));
		this.repository.add(new Dog("Fitzou", "husky"));
		this.repository.add(new Dog("Kalie", "berger"));
		this.repository.add(new Dog("Filou", "saucisse"));
	}
}
