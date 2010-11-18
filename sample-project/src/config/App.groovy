package config

import morph.plugin.ViewsPlugin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import config.Morph;
import controllers.Greeter;

@Configuration
@Import([Morph,ViewsPlugin])
class App {

	@Bean
	def greeter() {
		new Greeter()
	}
}
