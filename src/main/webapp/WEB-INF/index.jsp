<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Welcome - Yor rental Manager</title>
    <link rel="apple-touch-icon" sizes="180x180" href="images/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="images/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="images/favicon/favicon-16x16.png">
    <link rel="manifest" href="images/favicon/site.webmanifest">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link th:href="css/style.css" rel="stylesheet">
</head>

<body>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container">
            <a class="navbar-brand" href="/">Rental Manager</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/register">Create an account</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/login">Login</a>
                    </li>
                    
                </ul>
            </div>
        </div>
    </nav>

    <main class="container py-4">
        <div class="p-5 mb-4 bg-light rounded-3">
            <div class="container-fluid py-5">
                <h1 class="display-5 fw-bold">Your rental Manager</h1>
                <p class="col-md-8 fs-4">Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugiat earum, ducimus
                    non porro repellendus cupiditate facere labore aperiam nulla saepe nostrum dolores quia illo
                    assumenda tempora velit, aut a distinctio.</p>
                <a href="/login" class="btn btn-primary btn-lg" type="button">Get Started</a>
            </div>
        </div>
    </main>




    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>

</html>