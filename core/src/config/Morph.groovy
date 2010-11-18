package config
import morph.plugins.MorphPluginManager;

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import morph.*
import morph.taglibs.*

@Configuration
class Morph {

	@Bean
	def pluginManager() {
		new MorphPluginManager()
	}
}
