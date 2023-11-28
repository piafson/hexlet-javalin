@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.courses.BuildCoursePage
@param BuildCoursePage page

@template.layout.page(
content = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

    <form action="${NamedRoutes.coursesPath()}" method="post">
        <div class="input-group mb-3">
            <label>
                Название
                <input type="text" name="name" value="${page.getName()}"/>
            </label>
        </div>
        <div class="input-group mb-3">
            <label>
                Описание
                <p><textarea name="description">${page.getDescription()}</textarea></p>
            </label>
        </div>

        <input type="submit" value="Добавить" />
    </form>
`
)