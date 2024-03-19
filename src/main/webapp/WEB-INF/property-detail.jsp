    <%@ include file="header.jsp" %>

    <!-- Main start-->
    <main class="container py-4">

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
                <a href="/owner/properties/${property.id}/edit" class="btn btn-dark">Edit </a>       
                <a href="#" class="btn btn-danger mx-3" data-bs-toggle="modal" data-bs-target="#deletion-modal">Delete </a>
                <a href="/owner" class="btn btn-light">Cancel</a>
            </div>
            
        </div>
    </c:if>
    <c:set var="hasApplicantRole" value="false" scope="request" />
    <c:forEach items="${loggedUser.roles}" var="role">
        <c:if test="${role.name == 'ROLE_APPLICANT'}">
            <c:set var="hasApplicantRole" value="true" scope="request" />
        </c:if>
    </c:forEach>
    <c:if test="${hasApplicantRole}">
        <div class="row my-4">
            <a href="/applicant/start/application/${property.id}"  class="btn btn-lg btn-dark">Apply to this property</a>
        </div>
    </c:if>




    <!-- Modal for deletion request -->
    <div class="modal" tabindex="-1" id="deletion-modal">
        <div class="modal-dialog">
            <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Deletion Confirmation</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p>Do you want to delete this property: "<strong class="text-purple">${property.name}</strong>"?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                <form action="/owner/properties/${property.id}/delete" method="post">
                    <input type="hidden" value="delete" name="_method">
                    <button type="submit" class="btn btn-danger">Yes, delete</button>
                </form> 
                
            </div>
            </div>
        </div>
    </div>

    <!-- end of modal-->


    <script src="https://kit.fontawesome.com/d20aaabaac.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
    </main>
</body>
</html>