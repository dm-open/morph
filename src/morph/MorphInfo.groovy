package morph

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.ui.ModelMap 

@Controller
class MorphInfo {

	@RequestMapping("/info/{name}")
	void info(OutputStream response, @PathVariable name) {
		response << "<h1>Welcome to morph, $name - how are you today?</h1>"
	}

	@RequestMapping("/greet/{name}")
	String greet(@PathVariable name, ModelMap model) {
		model.addAttribute("name", name)

		"test"
	}
}

/*
@Controller
class ProductController {

	@RequestMapping("/products/{name}/{code}/view")	
	Product view(@PathVariable name, @PathVariable code) {
		productService.get(code)
	}
	
}

*/



