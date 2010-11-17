package morph.plugins;

import java.util.List;

import morph.taglibs.TagLib;

public class MorphPluginManager implements PluginManager {
	private List<TagLib> tagLibs;

	public void setTagLibs(List<TagLib> tagLibs) {
		this.tagLibs = tagLibs;
	}
	
	@Override
	public List<TagLib> tagLibs() {
		return tagLibs;
	}
}
