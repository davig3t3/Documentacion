package pet.apipet.controller.validator.apipet;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import pet.apipet.controller.validator.Validator;
import pet.apipet.crosscutting.helper.UUIDHelper;
import pet.apipet.crosscutting.messages.Message;
import pet.apipet.domain.LocationDTO;

public class CreateLocationValidator implements Validator<LocationDTO> {

	@Override
	public List<Message> validate(LocationDTO dto) {
		List<Message> messages = new ArrayList<>();
		
		validateIdLocation(dto.getId_location(), messages);
		
		return messages;
		
	}
	
	private void validateIdLocation(UUID locationId, List<Message> messages) {
		if(UUIDHelper.isDefaultUUID(locationId)) {
			messages.add(Message.createErrorMessage("Location id is equal to default value"));
			
		}
		
	}

}
