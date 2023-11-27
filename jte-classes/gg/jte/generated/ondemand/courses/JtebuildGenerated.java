package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursesPage;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "courses/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,5,5,22,22,22,22,22,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <form action=\"/courses\" method=\"post\">\n        <div class=\"input-group mb-3\">\n            <label>\n                Название\n                <input type=\"text\" name=\"name\" />\n            </label>\n        </div>\n        <div class=\"input-group mb-3\">\n            <label>\n                Описание\n                <p><textarea name=\"description\"></textarea></p>\n            </label>\n        </div>\n\n        <input type=\"submit\" value=\"Добавить\" />\n    </form>\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
