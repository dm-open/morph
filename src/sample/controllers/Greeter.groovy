package sample.controllers


import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.ui.ModelMap 

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


