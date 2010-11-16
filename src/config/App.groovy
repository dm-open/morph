package config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import morph.*

@Configuration
class App {

	@Bean
	def morphInfo() {
		new MorphInfo()
	}		
	
	@Bean
	def pluginManager() {
		new MorphPluginManager() // plugins: pluginList())
	}
	
	/*
	def pluginList() {
		scanner.scan(Plugin.class)
	}
	*/
	
	@Bean
	def viewResolver() {
		new MorphViewResolver(pluginManager:pluginManager(),cache:false)
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

http://forum.springsource.org/showthread.php?t=86329

RequestToViewNameTranslator
*/ 
