package pet.apipet.service.usecase.infoCategoryLocation;

import java.util.List;

import pet.apipet.domain.InfoCategoryLocationDTO;

public interface FindInfoCategoryLocationUseCase {
	
	List<InfoCategoryLocationDTO> execute(InfoCategoryLocationDTO infoCategoryLocation);
	
}
