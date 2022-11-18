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
import pet.apipet.controller.validator.apipet.CreateLocationValidator;
import pet.apipet.crosscutting.customException.ApipetCustomException;
import pet.apipet.crosscutting.messages.Message;
import pet.apipet.crosscutting.messages.Messages;
import pet.apipet.domain.LocationDTO;
import pet.apipet.service.command.CreateLocationCommand;

import pet.apipet.service.command.implementation.CreateLocationCommandImpl;


@RestController
@RequestMapping("/api/apipet")
public class LocationController {
	public CreateLocationCommand createLocationCommand = new CreateLocationCommandImpl();
	
	 @GetMapping("/dummy")
	 public LocationDTO holaMundo() {
		 return new LocationDTO();
	 }
	 
	 @PostMapping("/createlocation")
	 public ResponseEntity<Response<LocationDTO>> create(@RequestBody LocationDTO location) {

			final Response<LocationDTO> response = new Response<>();
			HttpStatus httpStatus = HttpStatus.OK;

			try {

				Validator<LocationDTO> validator = new CreateLocationValidator();
				List<Message> messages = validator.validate(location);

				if (messages.isEmpty()) {

					createLocationCommand.execute(location);
					List<LocationDTO> data = new ArrayList<>();
					data.add(location);
					response.addSuccessMessage(Messages.RequestMessage.REQUEST_CREATED);
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
					response.addErrorMessage(Messages.RequestMessage.REQUEST_CREATED_ERROR);
				} else {
					response.addErrorMessage(exception.getMessage());
				}
				// Imprimiendo traza excepción
				exception.printStackTrace();// da carcel ojo con este

			} catch (final Exception exception) {
				// Errores 500
				httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
				response.addFatalMessage(Messages.RequestMessage.REQUEST_CREATED_ERROR_UNEXPECTED);

				// Imprimiendo traza excepción
				exception.printStackTrace();
			}

			
			return new ResponseEntity<>(response, httpStatus);
		}	

}
