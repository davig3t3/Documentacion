package pet.apipet.service.usecase.specialCare;

import java.util.List;

import pet.apipet.domain.SpecialCareDTO;

public interface FindSpecialCareUseCase {
	
	List<SpecialCareDTO> execute(SpecialCareDTO specialCare);

}
