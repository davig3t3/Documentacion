package pet.apipet.controller.validator.apipet;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import pet.apipet.crosscutting.helper.UUIDHelper;
import pet.apipet.crosscutting.messages.Message;
import pet.apipet.domain.CategoryLocationDTO;
import pet.apipet.domain.MapDTO;
import pet.apipet.controller.validator.Validator;

public class CreateCategoryLocationValidator implements Validator<CategoryLocationDTO>{
	
	public List<Message> validate(CategoryLocationDTO dto) {
		List<Message> messages = new ArrayList<>();
		
		validateCategoryLocationId(dto.getId_categoryLocation(), messages);
		
		return messages;
	}
	
	private void validateCategoryLocationId(UUID categoryLocationID, List<Message> messages) {
		if(UUIDHelper.isDefaultUUID(categoryLocationID)) {
			messages.add(Message.createErrorMessage("Map id is equal to default value"));
			
		}
		
	}

}
