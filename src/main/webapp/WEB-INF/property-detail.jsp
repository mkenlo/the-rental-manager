    <%@ include file="header.jsp" %>

    <!-- Main start-->
    <main class="container py-4">

    <div class="d-flex mb-3 justify-content-end">
        <a href="/manager" class="nav-link text-primary" aria-current="page">
                <i class="fa-solid fa-house-user fa-lg"></i>
                Dashboard
        </a>
    </div>

    <div class="row">  
        <h1 class="my-3">${property.address}</h1>
        <div class="col-md-8">
        <img class="img-fluid" src="https://via.placeholder.com/750x500" alt="">
        </div>

        <div class="col-md-4">
        <h3 class="my-3">Property Description</h3>
        <p>${property.description}</p>
        <h3 class="my-3">Property Details</h3>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">Name: ${property.name}</li>
            <li class="list-group-item">Address: ${property.address}</li>
            <li class="list-group-item">Rent starting at: ${property.minLeasePrice}</li>
            <li class="list-group-item">Num of Beds: ${property.numBed}</li>
            <li class="list-group-item">Num of Bath: ${property.numBath}</li>
        </ul>
        </div>

    </div>
    <c:if test="${property.owner.profile.id == loggedUser.id}">
        <div class="row my-3">
            <div class="d-flex">
                <a href="/owner/properties/${property.id}/edit" class="btn btn-outline-primary">Edit </a>       
                <a href="#" class="btn btn-danger mx-3">Delete </a>
                <a href="/owner" class="btn btn-light">Cancel</a>
            </div>
            
        </div>
    </c:if>
    </main>
</body>
</html>