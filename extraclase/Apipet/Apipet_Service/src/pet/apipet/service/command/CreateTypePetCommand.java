package pet.apipet.service.command;

import pet.apipet.domain.TypePetDTO;

public interface CreateTypePetCommand {
	
	void execute(TypePetDTO typePet);

}
