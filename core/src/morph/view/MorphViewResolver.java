package morph.view;

import groovy.text.SimpleTemplateEngine;
import groovy.text.Template;

import java.io.File;
import java.util.Locale;

import morph.plugins.PluginManager;
import morph.view.groovy.GroovyTemplateView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractCachingViewResolver;

public class MorphViewResolver extends AbstractCachingViewResolver {
	private SimpleTemplateEngine templateEngine = new SimpleTemplateEngine();
	private PluginManager pluginManager;
	
	@Autowired
	public MorphViewResolver(PluginManager pluginManager) {
		this.pluginManager = pluginManager;
	}
	
	@Override
	public View loadView(String viewName, Locale locale) throws Exception {
		File viewOnDisk = new File(getServletContext().getRealPath("/WEB-INF/views/" + viewName + ".html"));
		
		if (!viewOnDisk.exists()) {
			return null;
		}
		
		Template template = templateEngine.createTemplate(viewOnDisk);
	
		return new GroovyTemplateView(template, pluginManager.tagLibs());
	}
}