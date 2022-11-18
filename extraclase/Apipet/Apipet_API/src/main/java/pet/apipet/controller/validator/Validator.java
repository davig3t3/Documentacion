package pet.apipet.controller.validator;

import java.util.List;

import pet.apipet.crosscutting.messages.Message;

public interface Validator<T> {

	List<Message> validate(T dto);
}