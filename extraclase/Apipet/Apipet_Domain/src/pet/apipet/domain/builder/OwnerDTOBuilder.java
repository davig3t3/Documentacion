package pet.apipet.domain.builder;

import java.util.UUID;

import pet.apipet.domain.OwnerDTO;

public class OwnerDTOBuilder {
	
	private UUID id;
	private String nameOwner;
	private String email;
	private String phoneNumber;
	private String address;
	private String password;
	private short birthDate;
	
	
	private OwnerDTOBuilder() {
		super();
	}
	
	public static final OwnerDTOBuilder getOwnerDTOBuilder() {
		return new OwnerDTOBuilder();
	}
	
	public final OwnerDTOBuilder setId(final UUID id) {
		this.id = id;
		return this;
	}
	
	public final OwnerDTOBuilder setName(final String nameOwner) {
		this.nameOwner = nameOwner;
		return this;
	}
	
	public final OwnerDTOBuilder setEmail(final String email) {
		this.email = email;
		return this;
	}
	
	public final OwnerDTOBuilder setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}
	
	public final OwnerDTOBuilder setAddress(final String address) {
		this.address = address;
		return this;
	}
	
	public final OwnerDTOBuilder setPassword(final String password) {
		this.password = password;
		return this;
	}
	
	public final OwnerDTOBuilder setBirthDate(final short birthDate) {
		this.birthDate = birthDate;
		return this;
	}
	
	public final OwnerDTO build() {
		return OwnerDTO.create(id,nameOwner,email,phoneNumber,address,password,birthDate);
	}
	
	
	

}
