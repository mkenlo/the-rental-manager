<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container">
        <a class="navbar-brand" href="/">Rental Manager</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <!--
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
        -->
         <div class="dropdown border-start">
            
            <a href="#" class="d-flex align-items-center justify-content-center p-1 link-dark text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                <img src="https://octodex.github.com/images/welcometocat.png" alt="mdo" width="32" height="32" class="rounded-circle">
                <strong>${loggedUser.firstname} ${loggedUser.lastname}</strong>
            </a>
           
            <ul class="dropdown-menu text-small shadow">
                <li><a class="dropdown-item" href="/myaccount/settings">Settings</a></li>
                <li><a class="dropdown-item" href="/myaccount/profile">Profile</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="/logout">Sign out</a></li>
            </ul>
        </div>

    </div>
</nav>