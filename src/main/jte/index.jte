@import org.example.hexlet.dto.root.MainPage
@param MainPage page

@template.layout.page(
content = @`
    <div class="mb-3">
        <h1>Hello!</h1>
    </div>
    @if(!page.isVisited())
        Это сообщение показывается только один раз. Если вы хотите увидеть его снова, сотрите куки
    @endif
`
)