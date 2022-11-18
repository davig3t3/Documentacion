package pet.apipet.domain;

import static pet.apipet.crosscutting.helper.UUIDHelper.getUUIDAsString;

import java.util.UUID;

public class CategoryLocationDTO {
	
	private UUID id_categoryLocation; 
	private String category;
	
	public CategoryLocationDTO(final UUID id_categoryLocation, final String category) {
		setId_categoryLocation(id_categoryLocation);
		setCategory(category);
	}
	
	public static final CategoryLocationDTO create(final UUID id_categoryLocation, final String category) {
		return new CategoryLocationDTO(id_categoryLocation,category);
	}
	
	public final UUID getId_categoryLocation() {
		return id_categoryLocation;
	}
	public final String getIdAsString() {
		return getUUIDAsString(getId_categoryLocation());
	}
	public void setId_categoryLocation(UUID id_categoryLocation) {
		this.id_categoryLocation = id_categoryLocation;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory( String category) {
		this.category = category;
	}
	
	
	

}
