package config

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;

@Configuration
@ImportResource("classpath:config/mongo.xml")
class DataSource {
	@Bean
	Mongo mongo() throws UnknownHostException {
		new Mongo("localhost")
	}

	@Bean
	MongoTemplate mongoTemplate() throws UnknownHostException {
		new MongoTemplate(mongo(), "sample")
	}
}
