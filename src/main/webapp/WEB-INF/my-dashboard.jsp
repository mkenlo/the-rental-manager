   <%@ include file="header.jsp" %>
    <main class="container py-4">

        <div class="row">
            <div class="alert alert-success alert-dismissible fade show col-md-4" role="alert">
                <p>Welcome back <strong>${loggedUser.firstname} </strong>!!!</p>        
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">
            </div>
            <c:if test="${message!=null}">
                <div class="alert alert-primary alert-dismissible fade show col-md-4" role="alert">
                    <p>${message}</p>        
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">
                </div>            
            </c:if>
        </div>     

        <div class="row my-3">
            <div class="col-md-6">
                <div class="card">

                    <div class="card-header"><h2>About me</h2></div>
                    <div class="card-body">
                        <p>Hi I'm <strong>${loggedUser.firstname} ${loggedUser.lastname}</strong><p>
                        <p><i class="fa-solid fa-at"></i> ${loggedUser.email}</p>
                        <p><i class="fa-solid fa-phone"></i>${loggedUser.phoneNum}</p>
                    
                        <div class="card-footer d-flex justify-content-between">
                            <a href="#" class="btn btn-primary">Edit my Profile</a>
                            <a href="${loggedUser.roles.iterator().next().baseUrl}" class="btn btn-danger">Go to my Dashboard</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>

</html>