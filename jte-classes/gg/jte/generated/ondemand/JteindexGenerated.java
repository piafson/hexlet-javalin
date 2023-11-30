package gg.jte.generated.ondemand;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.root.MainPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,6,6,10,10,11,11,11,13,13,14,14,14,14,14,14,14,14,14,15,15,16,16,16,16,16,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div class=\"mb-3\">\n        <h1>Hello!</h1>\n    </div>\n    ");
				if (page.getCurrentUser() != null) {
					jteOutput.writeContent("\n        Добро пожаловать, ");
					jteOutput.setContext("html", null);
					jteOutput.writeUserContent(page.getCurrentUser());
					jteOutput.writeContent(".\n        Чтобы разлогиниться, удалите куку JSESSIONID из браузера\n    ");
				} else {
					jteOutput.writeContent("\n        <a");
					var __jte_html_attribute_0 = NamedRoutes.sessionsPath();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_0);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">Войти</a>\n    ");
				}
				jteOutput.writeContent("\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
