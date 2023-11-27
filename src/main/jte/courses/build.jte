@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
content = @`
    <form action="/courses" method="post">
        <div class="input-group mb-3">
            <label>
                Название
                <input type="text" name="name" />
            </label>
        </div>
        <div class="input-group mb-3">
            <label>
                Описание
                <p><textarea name="description"></textarea></p>
            </label>
        </div>

        <input type="submit" value="Добавить" />
    </form>
`
)