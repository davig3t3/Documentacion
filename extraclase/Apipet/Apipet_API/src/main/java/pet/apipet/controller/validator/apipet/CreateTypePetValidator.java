package pet.apipet.controller.validator.apipet;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import pet.apipet.controller.validator.Validator;

import pet.apipet.crosscutting.helper.UUIDHelper;
import pet.apipet.crosscutting.messages.Message;
import pet.apipet.domain.OwnerDTO;
import pet.apipet.domain.TypePetDTO;

public class CreateTypePetValidator implements Validator<TypePetDTO>{
	
	public List<Message> validate(TypePetDTO dto) {
		List<Message> messages = new ArrayList<>();
		
		validateTypeId(dto.getId(), messages);
		
		return messages;
	}
	
	private void validateTypeId(UUID typePetID, List<Message> messages) {
		if(UUIDHelper.isDefaultUUID(typePetID)) {
			messages.add(Message.createErrorMessage("TypePet id is equal to default value"));
			
		}
		
	}

}
