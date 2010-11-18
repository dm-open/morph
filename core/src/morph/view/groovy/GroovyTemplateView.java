package morph.view.groovy;

import groovy.lang.Writable;
import groovy.text.Template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import morph.taglibs.TagLib;

import org.springframework.web.servlet.View;

public class GroovyTemplateView implements View {
	private Template template;
	private List<TagLib> tagLibs;

	public GroovyTemplateView(Template template, List<TagLib> tagLibs) {
		this.template = template;
		this.tagLibs = tagLibs;
	}

	@Override
	public String getContentType() {
		return "text/html";
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> mergedModel = new HashMap<String, Object>();
		if (model != null) {
			mergedModel.putAll(model);
		}

		for (TagLib tagLib : tagLibs) {
			mergedModel.put(tagLib.getPrefix(), tagLib);
		}

		Writable result = template.make(mergedModel);

		result.writeTo(response.getWriter());
	}
}