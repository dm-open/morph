package config
import morph.plugins.MorphPluginManager;
import morph.view.MorphRequestToViewNameTranslator;
import morph.view.MorphViewResolver;

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import sample.controllers.Greeter;
import morph.*
import morph.taglibs.*

@Configuration
class App {

	@Bean
	def morphInfo() {
		new Greeter()
	}		
	
	@Bean
	def pluginManager() {
		new MorphPluginManager(tagLibs: [new EchoTagLib()])
	}
	
	/*
	def pluginList() {
		scanner.scan(Plugin.class)
	}
	*/
	
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
