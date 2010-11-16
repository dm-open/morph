package morph

import org.springframework.web.servlet.View
import org.springframework.web.servlet.view.AbstractCachingViewResolver
import org.springframework.web.context.ServletContextAware
import groovy.text.SimpleTemplateEngine
import javax.servlet.ServletContext
import java.util.Locale

class MorphViewResolver extends AbstractCachingViewResolver implements ServletContextAware {
	SimpleTemplateEngine templateEngine = new SimpleTemplateEngine()
	MorphPluginManager pluginManager

	View loadView(String viewName, Locale locale) {
		def filePath = new File(servletContext.getRealPath("/WEB-INF/views/${viewName}.html"))
		def template = templateEngine.createTemplate(filePath.text)
		
		new GroovyTemplateView(template: template, tagLibs: pluginManager.tagLibs())
	}
}
