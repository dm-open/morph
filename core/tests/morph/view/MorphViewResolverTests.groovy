package morph.view

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import morph.plugins.PluginManager;

import org.junit.runner.RunWith;
import org.spockframework.runtime.Sputnik;

@RunWith(Sputnik.class)
class MorphViewResolverTests extends spock.lang.Specification {

	def "resolver should return null if view not on disk"() {
		given:
			def resolver = new MorphViewResolver()
			resolver.servletContext = [getRealPath: { path -> 'some/path'} ] as ServletContext

		expect:
			resolver.loadView("view/that/doesnt/exist", null) == null
	}

	def "resolver should return valid view if view is on disk"() {
		given:
			PluginManager pluginManager = Mock()

		and:
			def tempView = File.createTempFile('morph_', '.html')
			def resolver = new MorphViewResolver(pluginManager)
			resolver.servletContext = [getRealPath: { path -> tempView.path} ] as ServletContext

		expect:
			resolver.loadView("view/that/doesnt/exist", null) != null
	}
}

