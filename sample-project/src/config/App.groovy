package config

import morph.plugin.ViewsPlugin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource
import org.springframework.data.mongodb.core.MongoTemplate


import com.mongodb.Mongo


@Configuration
@Import([ViewsPlugin])
@ImportResource("classpath:config/mongo.xml")
@ComponentScan("controllers")
class App {

	@Bean
	public Mongo mongo() throws UnknownHostException {
		new Mongo("localhost")
	}

	@Bean
	public MongoTemplate mongoTemplate() throws UnknownHostException {
		new MongoTemplate(mongo(), "sample")
	}
}
