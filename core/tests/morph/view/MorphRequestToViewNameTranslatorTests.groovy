package morph.view

import javax.servlet.http.HttpServletRequest;

import org.junit.runner.RunWith;
import org.spockframework.runtime.Sputnik;

@RunWith(Sputnik.class)
class MorphRequestToViewNameTranslatorTests extends spock.lang.Specification {

	def "getViewName should translate controller and method names to appropriate view"() {
		given:
			def translator = new MorphRequestToViewNameTranslator()
			
		expect:
			translator.getViewName(request(controllerName, methodName)) == view
		
		where:
			controllerName			| methodName	| view
			'Product'						| 'view'			| 'product/view'					
			'ProductController'	| 'view'			| 'product/view'					
			'LoginController'		| 'login'			| 'login/login'					
	}

	private def request(String controller, String method) {
		[getAttribute: { key ->
			key == MorphRequestToViewNameTranslator.CONTROLLER_NAME_ATTRIBUTE ? controller : method
		}] as HttpServletRequest
	}
}

