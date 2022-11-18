package edu.uco.budget.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uco.budget.controller.response.Response;
import edu.uco.budget.controller.validator.Validator;
import edu.uco.budget.controller.validator.budget.CreateBudgetValidator;
import edu.uco.budget.crosscutting.customException.BudgetCustomException;
import edu.uco.budget.crosscutting.messages.Message;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.service.command.CreateBudgetCommand;
import edu.uco.budget.service.command.implementation.CreateBudgetCommandImpl;

@RestController
@RequestMapping("/api/budget")

public class BudgetController {

	private CreateBudgetCommand createBudgetCommand = new CreateBudgetCommandImpl();

	@GetMapping("/dummy")
	public BudgetDTO holaMundo() {
		return new BudgetDTO();
	}

	@PostMapping
	public ResponseEntity<Response<BudgetDTO>> create(@RequestBody BudgetDTO budget) {

		final Response<BudgetDTO> response = new Response<>();
		HttpStatus httpStatus = HttpStatus.OK;

		try {

			Validator<BudgetDTO> validator = new CreateBudgetValidator();
			List<Message> messages = validator.validate(budget);

			if (messages.isEmpty()) {

				createBudgetCommand.execute(budget);
				List<BudgetDTO> data = new ArrayList<>();
				data.add(budget);
				response.addSuccessMessage("The budget has been created succesfully ");
				response.setData(data);
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
				response.setMessages(messages);
			}

			// OK 200
		} catch (final BudgetCustomException exception) {
			// Errores 400
			httpStatus = HttpStatus.BAD_REQUEST;
			if (exception.isTechnicalException()) {
				response.addErrorMessage("There was an error trying to create the budget. Please try again.. ");
			} else {
				response.addErrorMessage(exception.getMessage());
			}
			// Imprimiendo traza excepción
			exception.printStackTrace();// da carcel ojo con este

		} catch (final Exception exception) {
			// Errores 500
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.addFatalMessage("There was an unexpected error trying to create the budget. Please try again.. ");

			// Imprimiendo traza excepción
			exception.printStackTrace();// da carcel ojo con este
		}

		// createBudgetCommand.execute(budget);
		return new ResponseEntity<>(response, httpStatus);
	}

}
