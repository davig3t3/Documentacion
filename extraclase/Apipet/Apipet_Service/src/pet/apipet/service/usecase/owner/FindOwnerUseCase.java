package pet.apipet.service.usecase.owner;

import java.util.UUID;

import pet.apipet.domain.OwnerDTO;

public interface FindOwnerUseCase {
	OwnerDTO execute(UUID id);

}
