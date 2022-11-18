package pet.apipet.service.usecase.owner.implementation;

import java.util.List;
import java.util.UUID;

import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.domain.OwnerDTO;
import pet.apipet.service.usecase.owner.FindOwnerUseCase;

public final class FindOwnerUseCaseImpl implements FindOwnerUseCase {
	
	private final DAOFactory factory;

	
	public FindOwnerUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	
	@Override
	public final OwnerDTO execute(UUID id) {
		
		OwnerDTO result = new OwnerDTO();
		final OwnerDTO owner = OwnerDTO.create(id);
		final List<OwnerDTO> results = factory.getOwnerDAO().find(owner);
		
		if(!results.isEmpty()) {
			result = results.get(0);
			
		}
		
		return result;
	}
	
	

}
