package dogs.model;

public class Dog {  // La classe est tres simple ici mais il pourrait avoir des validations ou des algos plus complexes.
	
	private static int nextId = 1;
	
	private int id;
	private String name;
	private String breed;  // Idealement faire une classe Breed (preferer a une enum)
	
	public Dog(String name, String breed) {
		this.id = nextId;
		incrementNextId();
		//TODO: calculer l'id --> un no unique pour identifier un chien
		this.name = name;
		this.breed = breed;
	}

	private void incrementNextId() {
		nextId++;
		
	}

	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}

}
