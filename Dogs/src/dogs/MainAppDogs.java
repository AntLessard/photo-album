package dogs;

import dogs.controller.DogController;
import dogs.controller.IDogController;
import dogs.controller.IWelcomeController;
//import dogs.controller.ListDogController;
import dogs.controller.WelcomeController;
import dogs.model.DogMemoryRepository;
import dogs.model.IDogRepository;

public class MainAppDogs {

	private IDogRepository dogRepository = new DogMemoryRepository();
	
	public static void main(String[] args) {
		new MainAppDogs();
	}

	public MainAppDogs() {
		this.seedData();
		this.createControllers();
	}
	
	private void seedData() {
		new DogDataSeeder(dogRepository);
	}

	private void createControllers() {
		//IListDogController listDogController = new ListDogController(dogRepository);
		IDogController dogController = new DogController(dogRepository);
		IWelcomeController appController = new WelcomeController(dogController); //gere la logic. A un startapplication ->vue d'acceuil
		appController.startApplication();
	}

}
