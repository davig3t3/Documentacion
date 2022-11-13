package pet.apipet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pet.apipet.domain.OwnerDTO;

@RestController
@RequestMapping("/api/apipet")
public class ApipetController {
	
	 @GetMapping
	 public String holaMundo() {
		 return "Hola Mundo";
	 }
	 
	 @PostMapping
		public void create(OwnerDTO owner) {
			
		}

	 
}
