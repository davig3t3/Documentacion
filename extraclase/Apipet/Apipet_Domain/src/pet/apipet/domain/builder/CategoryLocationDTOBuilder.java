package pet.apipet.domain.builder;

import java.util.UUID;
import pet.apipet.domain.CategoryLocationDTO;

public class CategoryLocationDTOBuilder {
	
	private UUID id_categoryLocation; 
	private String category;
	
	private CategoryLocationDTOBuilder() {
		super();
	}
	
	public static final CategoryLocationDTOBuilder getCategoryLocationDTOBuilder(){
		return new CategoryLocationDTOBuilder();
	}

	public final CategoryLocationDTOBuilder setId_categoryLocation(UUID id_categoryLocation) {
		this.id_categoryLocation = id_categoryLocation;
		return this;
	}

	public final CategoryLocationDTOBuilder setCategory(String category) {
		this.category = category;
		return this;
	}
	
	public final CategoryLocationDTO build() {
		return CategoryLocationDTO.create(id_categoryLocation, category);
	}
	

}
