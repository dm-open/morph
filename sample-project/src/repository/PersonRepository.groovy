package repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

import domain.Person

@Repository
interface PersonRepository extends MongoRepository<Person, String> {
	Person findByName(String name)
}
