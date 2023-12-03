@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <h1>Users</h1>

    <div class="mb-3">
        <a href="${NamedRoutes.buildUserPath()}">Register a new user</a>
    </div>

    <table class="table table-striped">
        @if (page.getFlash() != null)
            <div class="alert alert-success" role="alert">
                <p>${page.getFlash()}</p>
            </div>
        @endif

        @for(var user : page.getUsers())
            <tr>
                <td>
                    ${user.getId()}
                </td>
                <td>
                    ${user.getFirstName()} ${user.getLastName()}
                </td>
            </tr>
        @endfor
    </table>
`
)