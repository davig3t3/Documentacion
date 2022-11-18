package pet.apipet.service.usecase.pet;

import pet.apipet.domain.PetDTO;

public interface CreatePetUseCase {
	
	void execute(PetDTO pet);

}
