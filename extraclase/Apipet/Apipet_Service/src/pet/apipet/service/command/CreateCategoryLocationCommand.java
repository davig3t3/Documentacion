package pet.apipet.service.command;

import pet.apipet.domain.CategoryLocationDTO;

public interface CreateCategoryLocationCommand {
	
	void execute(CategoryLocationDTO categoryLocation);

}
