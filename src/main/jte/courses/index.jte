@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
content = @`
    <form action="/courses" method="get">
        <input type="search" name="term" value="${page.getTerm()}"/>
        <input type="submit" value="Search"/>
    </form>
    <h1>Courses</h1>
    <table class="table table-striped">
        @for(var course : page.getCourses())
            <tr>
                <td>
                    ${course.getId()}
                </td>
                <td>
                    <a href="/courses/${course.getId()}">${course.getName()} ${course.getDescription()}</a>
                </td>
            </tr>
        @endfor
    </table>
`
)