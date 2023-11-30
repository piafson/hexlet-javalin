package gg.jte.generated.ondemand.sessions;
import org.example.hexlet.NamedRoutes;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "sessions/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,2,2,3,3,4,4,4,4,4,4,4,4,4,9,9,9,11,11,11,11,11,11};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n<form");
				var __jte_html_attribute_0 = NamedRoutes.sessionsPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\n    <input type=\"text\" placeholder=\"Nickname\" name=\"nickname\" />\n    <input type=\"password\" placeholder=\"Password\" name=\"password\" />\n    <input type=\"submit\" />\n</form>\n");
			}
		});
		jteOutput.writeContent("\n\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
