@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.root.MainPage
@param MainPage page

@template.layout.page(
content = @`
    <div class="mb-3">
        <h1>Hello!</h1>
    </div>
    @if(page.getCurrentUser() != null)
        Добро пожаловать, ${page.getCurrentUser()}.
        Чтобы разлогиниться, удалите куку JSESSIONID из браузера
    @else
        <a href="${NamedRoutes.sessionsPath()}">Войти</a>
    @endif
`
)