package pet.apipet.controller.validator.apipet;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import pet.apipet.controller.validator.Validator;
import pet.apipet.crosscutting.helper.UUIDHelper;
import pet.apipet.crosscutting.messages.Message;
import pet.apipet.domain.OwnerDTO;

public class CreateApipetValidator implements Validator<OwnerDTO> {


	@Override
	public List<Message> validate(OwnerDTO dto) {
		List<Message> messages = new ArrayList<>();
		
		validatePersonId(dto.getId(), messages);
		
		return messages;
	}
	
	private void validatePersonId(UUID personId, List<Message> messages) {
		if(UUIDHelper.isDefaultUUID(personId)) {
			messages.add(Message.createErrorMessage("Owner id is equal to default value"));
			
		}
		
	}

}
