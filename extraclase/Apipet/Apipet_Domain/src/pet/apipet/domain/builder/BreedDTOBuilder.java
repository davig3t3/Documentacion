package pet.apipet.domain.builder;

import java.util.UUID;
import pet.apipet.domain.BreedDTO;

public class BreedDTOBuilder {
	
	private UUID id_breed;
	private String name;
	private String origin;
	private String description;
	private String temper;
	private String colors;
	private float height;
	private float weight;
	
	private BreedDTOBuilder() {
		super();
	}

	public static final BreedDTOBuilder getBreedDTOBuilder() {
		return new BreedDTOBuilder();
	}
	

	public final BreedDTOBuilder  setId_breed(UUID id_breed) {
		this.id_breed = id_breed;
		return this;
	}

	public final BreedDTOBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public final BreedDTOBuilder setOrigin(String origin) {
		this.origin = origin;
		return this;
	}

	public final BreedDTOBuilder setDescription(String description) {
		this.description = description;
		return this;
	}

	public final BreedDTOBuilder setTemper(String temper) {
		this.temper = temper;
		return this;
	}

	public final BreedDTOBuilder setColors(String colors) {
		this.colors = colors;
		return this;
	}

	public final BreedDTOBuilder setHeight(float height) {
		this.height = height;
		return this;
	}

	public final BreedDTOBuilder setWeight(float weight) {
		this.weight = weight;
		return this;
	}
	
	public final BreedDTO build() {
		return BreedDTO.create(id_breed, name, origin, description, temper, colors, height, weight);
	}
	 
	
	
}
