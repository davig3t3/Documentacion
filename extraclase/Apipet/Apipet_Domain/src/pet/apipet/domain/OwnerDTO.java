package pet.apipet.domain;

import static pet.apipet.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static pet.apipet.crosscutting.helper.StringHelper.applyTrim;
import static pet.apipet.crosscutting.helper.NumberHelper.isLessThan;
import static pet.apipet.crosscutting.helper.NumberHelper.ZERO;
import static pet.apipet.crosscutting.helper.UUIDHelper.getUUIDAsString;

import java.util.UUID;

import pet.apipet.crosscutting.helper.UUIDHelper;


public class OwnerDTO {

	private UUID id;
	private String nameOwner;
	private String email;
	private String phoneNumber;
	private String address;
	private String password;
	private short birthDate;
	
	
	public OwnerDTO(final UUID id, final String nameOwner, final String email, final String phoneNumber, final String address, final String password, final short birthDate) {
		setId(getDefaultUUID(id));
		setNameOwner(nameOwner);
		setEmail(email);
		setPhoneNumber(phoneNumber);
		setAddress(address);
		setPassword(password);
		setBirthDate(birthDate);
	}

	public static final OwnerDTO create(final UUID id, final String nameOwner, final String email, final String phoneNumber, final String address, final String password, final short birthDate) {
		return new OwnerDTO(id,nameOwner,email,phoneNumber,address,password,birthDate);
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(final UUID id) {
		this.id = getDefaultUUID(id);
	}

	public String getNameOwner() {
		return nameOwner;
	}

	public void setNameOwner(final String nameOwner) {
		this.nameOwner = applyTrim(nameOwner);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = applyTrim(email);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = applyTrim(phoneNumber);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(final String address) {
		this.address = applyTrim(address);
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = applyTrim(password);
	}
	
	public final short getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(final short birthDate) {
		this.birthDate = isLessThan(birthDate,ZERO)? ZERO : birthDate;
	}
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}
	
	public final boolean exist() {
		return !UUIDHelper.isDefaultUUID(id);
	}
	
	public final boolean notExist() {
		return !exist();
	}

}
