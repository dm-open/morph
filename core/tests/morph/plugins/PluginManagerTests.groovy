package morph.plugins

import org.junit.runner.RunWith
import org.spockframework.runtime.Sputnik
import org.springframework.context.ApplicationContext

@RunWith(Sputnik.class)
class PluginManagerTests extends spock.lang.Specification {
	MorphPluginManager pluginManager
	ApplicationContext applicationContext

	def "plugin manager should initialise with any plugins found in the spring context"() {
		given:
			applicationContext.getBeansOfType(Plugin.class) >> [one: plugin("one"), two: plugin("two")]
			pluginManager.afterPropertiesSet()
			
		expect: "the instance to be returned"
			pluginManager.configuredPlugins().size() == 2
	}
	
	private def plugin(name) {
		new SimplePlugin(name: name)
	}
	
	def setup() {
		applicationContext = Mock()

		pluginManager = new MorphPluginManager()
		pluginManager.applicationContext = applicationContext
	}
}

class SimplePlugin implements Plugin {
	String name
	
	@Override
	String name() {
		name
	}

	@Override
	String version() {
		"1.0"
	}

	@Override
	String description() {
		null
	}
}
