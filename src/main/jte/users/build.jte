@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.users.BuildUserPage
@param BuildUserPage page

@template.layout.page(
content = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <div class="alert alert-danger" role="alert">
                        <li>${error.getMessage()}</li>
                    </div>
                @endfor
            @endfor
        </ul>
    @endif

    <form action="${NamedRoutes.usersPath()}" method="post">
        <div class="input-group mb-3">
            <label>
                Имя
                <input type="text" name="firstName" value="${page.getFirstName()}"/>
            </label>
        </div>
        <div class="input-group mb-3">
            <label>
                Фамилия
                <input type="text" name="lastName" value="${page.getLastName()}"/>
            </label>
        </div>
        <div class="input-group mb-3">
            <label>
                Email
                <input type="email" required name="email" value="${page.getEmail()}"/>
            </label>
        </div>
        <div class="input-group mb-3">
            <label>
                Пароль
                <input type="password" required name="password" />
            </label>
        </div>
        <div class="input-group mb-3">
            <label>
                Подтверждение пароля
                <input type="password" required name="passwordConfirmation" />
            </label>
        </div>
        <input type="submit" value="Зарегистрировать" />
    </form>
`
)
