package edu.uco.budget.controller.validator;

import java.util.List;

import edu.uco.budget.crosscutting.messages.Message;

public interface Validator<T> {

	List<Message> validate(T dto);
}
