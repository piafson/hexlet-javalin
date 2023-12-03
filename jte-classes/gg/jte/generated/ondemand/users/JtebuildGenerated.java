package gg.jte.generated.ondemand.users;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.users.BuildUserPage;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,6,6,7,7,9,9,10,10,12,12,12,14,14,15,15,17,17,19,19,19,19,19,19,19,19,19,23,23,23,23,23,23,23,23,23,29,29,29,29,29,29,29,29,29,35,35,35,35,35,35,35,35,35,52,52,52,53,53,53,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildUserPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    ");
				if (page.getErrors() != null) {
					jteOutput.writeContent("\n        <ul>\n            ");
					for (var validator : page.getErrors().values()) {
						jteOutput.writeContent("\n                ");
						for (var error : validator) {
							jteOutput.writeContent("\n                    <div class=\"alert alert-danger\" role=\"alert\">\n                        <li>");
							jteOutput.setContext("li", null);
							jteOutput.writeUserContent(error.getMessage());
							jteOutput.writeContent("</li>\n                    </div>\n                ");
						}
						jteOutput.writeContent("\n            ");
					}
					jteOutput.writeContent("\n        </ul>\n    ");
				}
				jteOutput.writeContent("\n\n    <form");
				var __jte_html_attribute_0 = NamedRoutes.usersPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\n        <div class=\"input-group mb-3\">\n            <label>\n                Имя\n                <input type=\"text\" name=\"firstName\"");
				var __jte_html_attribute_1 = page.getFirstName();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent("/>\n            </label>\n        </div>\n        <div class=\"input-group mb-3\">\n            <label>\n                Фамилия\n                <input type=\"text\" name=\"lastName\"");
				var __jte_html_attribute_2 = page.getLastName();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_2);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent("/>\n            </label>\n        </div>\n        <div class=\"input-group mb-3\">\n            <label>\n                Email\n                <input type=\"email\" required name=\"email\"");
				var __jte_html_attribute_3 = page.getEmail();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_3);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent("/>\n            </label>\n        </div>\n        <div class=\"input-group mb-3\">\n            <label>\n                Пароль\n                <input type=\"password\" required name=\"password\" />\n            </label>\n        </div>\n        <div class=\"input-group mb-3\">\n            <label>\n                Подтверждение пароля\n                <input type=\"password\" required name=\"passwordConfirmation\" />\n            </label>\n        </div>\n        <input type=\"submit\" value=\"Зарегистрировать\" />\n    </form>\n");
			}
		});
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildUserPage page = (BuildUserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
