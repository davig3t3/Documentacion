package pet.apipet.service.usecase.basicCare;

import java.util.List;

import pet.apipet.domain.BasicCareDTO;

public interface FindBasicCareUseCase {
	
	List<BasicCareDTO> execute(BasicCareDTO basicCare);

}
