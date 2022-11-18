package pet.apipet.domain;

import static pet.apipet.crosscutting.helper.UUIDHelper.getUUIDAsString;

import java.util.UUID;

public class BreedDTO {
	
	private UUID id_breed;
	private String name;
	private String origin;
	private String description;
	private String temper;
	private String colors;
	private float height;
	private float weight;
	
	public BreedDTO(final UUID id_breed, final String name, final String origin, final String description, 
		final String temper, final String colors,final float height, final float weight) {
		setId_breed(id_breed);
		setName(name);
		setOrigin(origin);
		setDescription(description);
		setTemper(temper);
		setColors(colors);		
		setHeight(height);
		setWeight(weight);
	}
	
	public static final BreedDTO create(final UUID id_breed, final String name, final String origin, final String description, 
			final String temper, final String colors,final float height, final float weight) {
		return new BreedDTO(id_breed,name,origin,description,temper,colors,height,weight);
	}
	
	
	public final UUID getId_breed() {
		return id_breed;
	}
	public final String getIdAsString() {
		return getUUIDAsString(getId_breed());
	}
	
	public final void setId_breed(final UUID id_breed) {
		this.id_breed = id_breed;
	}
	public  String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTemper() {
		return temper;
	}
	public void setTemper(String temper) {
		this.temper = temper;
	}
	public String getColors() {
		return colors;
	}
	public void setColors(String colors) {
		this.colors = colors;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	

}
