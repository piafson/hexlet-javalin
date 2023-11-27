package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursesPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,5,5,7,15,15,18,18,18,21,21,21,21,21,21,21,24,24,24,24,24,24,24,27,27,29,29,29,29,29,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <form action=\"/courses\" method=\"get\">\n        ");
				jteOutput.writeContent("\n    </form>\n    <div class=\"mb-3\">\n        <a href=\"/courses/build\">Build a new course</a>\n    </div>\n    <h1>Courses</h1>\n    <table class=\"table table-striped\">\n        ");
				for (var course : page.getCourses()) {
					jteOutput.writeContent("\n            <tr>\n                <td>\n                    ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(course.getId());
					jteOutput.writeContent("\n                </td>\n                <td>\n                    <a href=\"/courses/");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(course.getId());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\">");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(course.getName());
					jteOutput.writeContent("</a>\n                </td>\n                <td>\n                    <a href=\"/courses/");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(course.getId());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\">");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(course.getDescription());
					jteOutput.writeContent("</a>\n                </td>\n            </tr>\n        ");
				}
				jteOutput.writeContent("\n    </table>\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
