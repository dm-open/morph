package config
import morph.plugins.MorphPluginManager;
import morph.view.MorphRequestToViewNameTranslator;
import morph.view.MorphViewResolver;

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import;

import sample.controllers.Greeter;
import morph.*
import morph.taglibs.*

@Configuration
@Import([MyPlugin])
class App {

	@Bean
	def morphInfo() {
		new Greeter()
	}		
	
	@Bean
	def pluginManager() {
		new MorphPluginManager(tagLibs: [new EchoTagLib()])
	}
	
	@Bean
	def viewNameTranslator() {
		new MorphRequestToViewNameTranslator()
	}
	
	@Bean
	def viewResolver() {
		def resolver = new MorphViewResolver(pluginManager())
		resolver.cache = false
		resolver
	}
}

@Configuration
class MyPlugin {
	
	
}
/*
@Plugin(dependencies=['core'])
class ProductPlugin {
	def pluginManager

}

@Taglib(prefix='p')
class ProductTagLib {

	def view(attrs) {	
	
	}
}

@TagLib(prefix='p', wrap:ProductTagLib.class)
class EnhancedProductTagLib {

	def view(attrs) {
		
	}

}
*/ 
