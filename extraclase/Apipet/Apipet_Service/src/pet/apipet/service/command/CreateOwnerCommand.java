package pet.apipet.service.command;

import pet.apipet.domain.OwnerDTO;

public interface CreateOwnerCommand {
	
	void execute(OwnerDTO owner);

}
