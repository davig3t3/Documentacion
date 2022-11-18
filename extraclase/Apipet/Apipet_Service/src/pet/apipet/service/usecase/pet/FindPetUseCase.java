package pet.apipet.service.usecase.pet;

import java.util.List;

import pet.apipet.domain.PetDTO;

public interface FindPetUseCase {
	
	List<PetDTO> execute(PetDTO pet);

}
