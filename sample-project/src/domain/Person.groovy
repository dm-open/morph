package domain

import org.springframework.data.mongodb.core.mapping.Document

@Document
class Person {
	String id
	String name
	String greeting
}
