package controllers;


import javax.servlet.ServletContext

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

import domain.Person

import repository.PersonRepository;


@Controller
class Greeter {
	@Autowired
	PersonRepository personRepository 
	
	@RequestMapping("/greet/{name}")
	Person greet(@PathVariable name) {
		personRepository.findByName(name)
	}
}