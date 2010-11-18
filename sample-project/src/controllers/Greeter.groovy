package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class Greeter {

	@RequestMapping("/greet/{name}")
	Person greet(@PathVariable name) {
		new Person(name: name)
	}
	
}

class Person {
	String name
}