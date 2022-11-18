package pet.apipet.service.usecase.breed;

import java.util.List;

import pet.apipet.domain.BreedDTO;

public interface FindBreedUseCase {
	
	List<BreedDTO> execute(BreedDTO breed);

}
