package domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {
	private String id;
	private String name;
	private String greeting;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}	
}
