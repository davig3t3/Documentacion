package pet.apipet.service.usecase.owner.implementation;

import java.util.UUID;

import pet.apipet.crosscutting.customException.service.ServiceCustomException;
import pet.apipet.crosscutting.helper.UUIDHelper;
import pet.apipet.crosscutting.messages.Messages;
import pet.apipet.data.daofactory.DAOFactory;
import pet.apipet.domain.OwnerDTO;
import pet.apipet.service.usecase.owner.CreateOwnerUseCase;
import pet.apipet.service.usecase.owner.FindOwnerUseCase;
import pet.apipet.service.usecase.owner.implementation.FindOwnerUseCaseImpl;

public final class CreateOwnerUseCaseImpl implements CreateOwnerUseCase {

	private final DAOFactory factory;
	private final FindOwnerUseCase findOwnerUseCase;
	
	public CreateOwnerUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		findOwnerUseCase = new FindOwnerUseCaseImpl(factory);
	}


	@Override
	public void execute(OwnerDTO owneer) {
		final OwnerDTO owner = findOwner(owneer.getId());
	
		owner.setId(UUIDHelper.getNewUUID());
		
		factory.getOwnerDAO().create(owner);
		
	}
	
	private final OwnerDTO findOwner(final UUID id) {
		final OwnerDTO owner = findOwnerUseCase.execute(id);
		
		if(owner.notExist()) {
			throw ServiceCustomException.createUserException(Messages.CreateOwnerUseCaseImpl.BUSINESS_OWNER_DOES_NOT_EXIST);
		}
		return owner;
	}

	
	
}
