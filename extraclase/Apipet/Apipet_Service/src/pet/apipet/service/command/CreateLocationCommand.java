package pet.apipet.service.command;
import pet.apipet.domain.LocationDTO;

public interface CreateLocationCommand {
	
	void execute(LocationDTO location);
	
}
