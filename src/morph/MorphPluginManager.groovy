package morph

class MorphPluginManager {
	
	def tagLibs() {
		[t: [echo: { attrs -> attrs.message }, go: { out, attrs -> out << attrs.message }]]
	}

}