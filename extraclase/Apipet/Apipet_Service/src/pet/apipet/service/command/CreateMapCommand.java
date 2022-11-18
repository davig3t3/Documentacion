package pet.apipet.service.command;

import pet.apipet.domain.MapDTO;

public interface CreateMapCommand {
	
	
	void execute(MapDTO map);

}
