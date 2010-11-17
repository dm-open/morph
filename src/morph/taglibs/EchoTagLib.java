package morph.taglibs;

public class EchoTagLib implements TagLib {

	@Override
	public String getPrefix() {
		return "e";
	}

	public String alert(String message) {
		return "<h2>" + message + "</h2>";
	}
}
