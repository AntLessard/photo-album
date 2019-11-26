package dogs.controller;

import java.util.ArrayList;

import dogs.dto.DogDTOForCreate;
import dogs.dto.DogDTOForList;
import dogs.model.Dog;
import dogs.model.IDogRepository;
import dogs.view.CreateDogView;
import dogs.view.IView;
import dogs.view.ListDogView;

public class DogController implements IDogController {
	
	private IDogRepository repository;
	private ArrayList<DogDTOForList> dogDTOList;
	
	public DogController(IDogRepository dogRepository) {
		this.repository = dogRepository;
	}
	
	@Override
	public void goToCreate() {
		IView dogCreateView = new CreateDogView(this);
		dogCreateView.display();
	}

	@Override
	public void add(DogDTOForCreate dogToCreate) {
		Dog newDog = new Dog(dogToCreate.name, dogToCreate.breed);
		this.repository.add(newDog);
	}
	
	private void getListOfDogs() {
		dogDTOList = new ArrayList<DogDTOForList>();
		for(Dog dogToTransfer:this.repository.getList()) {
			DogDTOForList dogToAdd = new DogDTOForList(dogToTransfer.getId(), dogToTransfer.getName(), dogToTransfer.getBreed());
			dogDTOList.add(dogToAdd);
		}
	}

	@Override
	public void goToShowList() {
		getListOfDogs();
		IView listDogView = new ListDogView(this, dogDTOList);
		listDogView.display();
	}
	
}
