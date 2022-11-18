package pet.apipet.controller.validator.apipet;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import pet.apipet.controller.validator.Validator;
import pet.apipet.crosscutting.helper.UUIDHelper;
import pet.apipet.crosscutting.messages.Message;
import pet.apipet.domain.MapDTO;
import pet.apipet.domain.TypePetDTO;

public class CreateMapValidator implements Validator<MapDTO>{
	
	
	public List<Message> validate(MapDTO dto) {
		List<Message> messages = new ArrayList<>();
		
		validateMapId(dto.getId(), messages);
		
		return messages;
	}
	
	private void validateMapId(UUID mapID, List<Message> messages) {
		if(UUIDHelper.isDefaultUUID(mapID)) {
			messages.add(Message.createErrorMessage("Map id is equal to default value"));
			
		}
		
	}

}
