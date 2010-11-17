package morph.view;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.RequestToViewNameTranslator;
import org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator;

public class MorphRequestToViewNameTranslator implements RequestToViewNameTranslator {
	public static final String CONTROLLER_NAME_ATTRIBUTE = "controllerClass";
	public static final String CONTROLLER_METHOD_ATTRIBUTE = "controllerMethod";

	@Override
	public String getViewName(HttpServletRequest request) throws Exception {
		String controllerClassName = (String) request.getAttribute(CONTROLLER_NAME_ATTRIBUTE);
		String controllerMethodName = (String) request.getAttribute(CONTROLLER_METHOD_ATTRIBUTE);

		if (controllerClassName == null || controllerMethodName == null) {
			return new DefaultRequestToViewNameTranslator().getViewName(request);
		}
		
		String controller = controllerClassName.replace("Controller", "").toLowerCase();
		String method = controllerMethodName.toLowerCase();
		
		return controller + "/" + method;
	}

}
