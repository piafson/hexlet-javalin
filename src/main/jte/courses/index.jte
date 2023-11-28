@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
content = @`

    <div class="mb-3">
        <a href="${NamedRoutes.buildCoursePath()}">Build a new course</a>
    </div>
    <h1>Список Курсов</h1>
    @if(page.getCourses().isEmpty())
        <p>Пока не добавлено ни одного курса</p>
    @else
        @for(var course : page.getCourses())
            <h2><a href="${NamedRoutes.coursePath(course.getId())}">${course.getName()}</a></h2>

            <p>${course.getDescription()}</p>

        @endfor
    @endif
`
)