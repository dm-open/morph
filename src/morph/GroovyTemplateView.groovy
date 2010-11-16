package morph

import org.springframework.web.servlet.View
import javax.servlet.http.HttpServletRequest 
import javax.servlet.http.HttpServletResponse 
import javax.servlet.ServletContext
import groovy.text.Template

class GroovyTemplateView implements View {
	Template template
	Map<String, ?> tagLibs
	
	String getContentType() {
		"text/html"
	}
	
	void render(Map<String,?> model, HttpServletRequest request, HttpServletResponse response)  {
		def binding = tagLibs
		binding << model
		
		def result = template.make(binding)
		
		result.writeTo response.writer
	}
}