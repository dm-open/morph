package morph

class MorphInfoTests extends spock.lang.Specification {

	def "Should write some text to response"() {
		given:
			def morphInfo = new MorphInfo()
			def out = new ByteArrayOutputStream()
			
		when:
			morphInfo.info(out, 'James')
		
		then:
			out.toString() == '<h1>Welcome to morph, James - how are you today?</h1>'
	}

}
