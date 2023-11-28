@import gg.jte.Content
@import org.example.hexlet.NamedRoutes
@param Content content 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
<header>
    <div>
        <ul class="nav justify-content-center">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${NamedRoutes.coursesPath()}">Courses</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${NamedRoutes.usersPath()}">Users</a>
            </li>
        </ul>
    </div>
</header>

<main>
    ${content}
</main>

<footer>
    <p class="lead">
        <a href="https://github.com/piafson">My github profile</a>
    </p>
</footer>
</body>
</html>