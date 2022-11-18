package pet.apipet.service.usecase.map;

import java.util.List;

import pet.apipet.domain.MapDTO;

public interface FindMapUseCase {
	
	List<MapDTO> execute(MapDTO map);

}
