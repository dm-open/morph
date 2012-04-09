package controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import repository.PersonRepository;

import domain.Person

@Controller
class Greeter {
	@Autowired
	PersonRepository personRepository 

	@RequestMapping("/greet/{name}")
	Person greet(@PathVariable name) {
		personRepository.findByName(name)
	}
	
}