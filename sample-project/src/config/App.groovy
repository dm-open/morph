package config

import morph.plugin.ThymeLeafPlugin;
import morph.support.ViewSupport;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource
import org.springframework.data.mongodb.core.MongoTemplate


import com.mongodb.Mongo


@Import([ThymeLeafPlugin, ViewSupport, DataSource]) 
@ComponentScan(["controllers", "repository"])
@Configuration 
class App {

}
