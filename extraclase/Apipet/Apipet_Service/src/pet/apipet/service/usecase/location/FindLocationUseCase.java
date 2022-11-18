package pet.apipet.service.usecase.location;

import java.util.List;

import pet.apipet.domain.LocationDTO;

public interface FindLocationUseCase {
	
	List<LocationDTO> execute(LocationDTO location);

}
