package pet.apipet.service.usecase.typePet;

import java.util.List;

import pet.apipet.domain.TypePetDTO;

public interface FindTypePetUseCase {

	List<TypePetDTO> execute(TypePetDTO typePet);
}
