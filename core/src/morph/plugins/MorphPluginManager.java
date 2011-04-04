package morph.plugins;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Component
public class MorphPluginManager implements PluginManager, ApplicationContextAware, InitializingBean {
	private ApplicationContext applicationContext;
	private List<Plugin> plugins = new ArrayList<Plugin>();
	
	@Override
	public List<Plugin> configuredPlugins() {
		return plugins;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		for (Plugin plugin : applicationContext.getBeansOfType(Plugin.class).values()) {
			plugins.add(plugin);
		}
	}
}
