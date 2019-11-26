package dogs.controller;

import dogs.dto.DogDTOForCreate;

public interface IDogController {

	void goToCreate();

	void add(DogDTOForCreate dogToCreate);

	void goToShowList();

}
