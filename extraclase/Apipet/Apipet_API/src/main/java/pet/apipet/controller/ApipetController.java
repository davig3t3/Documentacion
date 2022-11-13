package pet.apipet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pet.apipet.domain.OwnerDTO;
import pet.apipet.service.command.CreateOwnerCommand;
import pet.apipet.service.command.implementation.CreateOwnerCommandImpl;

@RestController
@RequestMapping("/api/apipet/dummy")
public class ApipetController {
	
	private CreateOwnerCommand createOwnerCommand = new CreateOwnerCommandImpl();
	
	 @GetMapping("/dummy")
	 public OwnerDTO holaMundo() {
		 return new OwnerDTO();
	 }
	 
	 @PostMapping
		public String create(@RequestBody OwnerDTO owner) {
		 createOwnerCommand.execute(owner);
		 return "Creación exitosa";
		}

	 
}
