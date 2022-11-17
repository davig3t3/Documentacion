package pet.apipet.service.usecase.owner;

import pet.apipet.domain.OwnerDTO;

public interface CreateOwnerUseCase {
	
	void execute(OwnerDTO owner);

}
