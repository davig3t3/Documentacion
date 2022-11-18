package pet.apipet.service.usecase.location;

import pet.apipet.domain.LocationDTO;

public interface CreateLocationUseCase {

	void execute(LocationDTO location);
	
}
