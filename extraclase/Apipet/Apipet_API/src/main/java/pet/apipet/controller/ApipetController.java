package pet.apipet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pet.apipet.controller.response.Response;
import pet.apipet.controller.validator.Validator;
import pet.apipet.controller.validator.apipet.CreateApipetValidator;
import pet.apipet.crosscutting.customException.ApipetCustomException;
import pet.apipet.crosscutting.messages.Message;
import pet.apipet.domain.OwnerDTO;
import pet.apipet.service.command.CreateOwnerCommand;
import pet.apipet.service.command.implementation.CreateOwnerCommandImpl;

@RestController
@RequestMapping("/api/apipet")
public class ApipetController {
	
	public CreateOwnerCommand createOwnerCommand = new CreateOwnerCommandImpl();
	
	 @GetMapping("/dummy")
	 public OwnerDTO holaMundo() {
		 return new OwnerDTO();
	 }
	 
	 @PostMapping("/createe")
	 public ResponseEntity<Response<OwnerDTO>> create(@RequestBody OwnerDTO owner) {

			final Response<OwnerDTO> response = new Response<>();
			HttpStatus httpStatus = HttpStatus.OK;

			try {

				Validator<OwnerDTO> validator = new CreateApipetValidator();
				List<Message> messages = validator.validate(owner);

				if (messages.isEmpty()) {

					createOwnerCommand.execute(owner);
					List<OwnerDTO> data = new ArrayList<>();
					data.add(owner);
					response.addSuccessMessage("The owner has been created succesfully ");
					response.setData(data);
				} else {
					httpStatus = HttpStatus.BAD_REQUEST;
					response.setMessages(messages);
				}

				// OK 200
			} catch (final ApipetCustomException exception) {
				// Errores 400
				httpStatus = HttpStatus.BAD_REQUEST;
				if (exception.isTechnicalException()) {
					response.addErrorMessage("There was an error trying to create the owner. Please try again.. ");
				} else {
					response.addErrorMessage(exception.getMessage());
				}
				// Imprimiendo traza excepción
				exception.printStackTrace();// da carcel ojo con este

			} catch (final Exception exception) {
				// Errores 500
				httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
				response.addFatalMessage("There was an unexpected error trying to create the owner. Please try again.. ");

				// Imprimiendo traza excepción
				exception.printStackTrace();// da carcel ojo con este
			}

			
			return new ResponseEntity<>(response, httpStatus);
		}	

	 
}
