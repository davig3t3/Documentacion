package pet.apipet.service.usecase.breed;

import pet.apipet.domain.BreedDTO;

public interface CreateBreedUseCase {
	
	void execute(BreedDTO breed);

}
