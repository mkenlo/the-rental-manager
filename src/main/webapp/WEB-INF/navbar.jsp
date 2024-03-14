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
         <div class="dropdown border-left">
            <a href="#" class="d-flex align-items-center justify-content-center p-3 link-dark text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                <img src="https://github.com/mdo.png" alt="mdo" width="24" height="24" class="rounded-circle">
            </a>
            <strong>User: ${loggedUser.firstname} ${loggedUser.lastname}</strong>
            <ul class="dropdown-menu text-small shadow">
                <li><a class="dropdown-item" href="#">Settings</a></li>
                <li><a class="dropdown-item" href="#">Profile</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="#">Sign out</a></li>
            </ul>
        </div>

        <form class="d-flex">
            <span class="material-symbols-outlined my-2 ">person</span>
            <label class="px-2 my-2 ">${loggedUser.firstname} ${loggedUser.lastname}</label>
            <a href="/logout" class="btn btn-outline-danger">Logout</a>
      </form>
    </div>
</nav>