package gg.jte.generated.ondemand.users;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.users.UsersPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,6,6,10,10,10,10,10,10,10,10,10,14,14,17,17,17,20,20,20,20,20,20,23,23,25,25,25,25,25,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <h1>Users</h1>\n\n    <div class=\"mb-3\">\n        <a");
				var __jte_html_attribute_0 = NamedRoutes.buildUserPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Register a new user</a>\n    </div>\n\n    <table class=\"table table-striped\">\n        ");
				for (var user : page.getUsers()) {
					jteOutput.writeContent("\n            <tr>\n                <td>\n                    ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(user.getId());
					jteOutput.writeContent("\n                </td>\n                <td>\n                    ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(user.getFirstName());
					jteOutput.writeContent(" ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(user.getLastName());
					jteOutput.writeContent("\n                </td>\n            </tr>\n        ");
				}
				jteOutput.writeContent("\n    </table>\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
