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
        <h3 class="my-3">About the application</h3>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">Submitted on: Mar 14, 2024</li>
            <li class="list-group-item">Deposit: 50$</li>
            <li class="list-group-item">Rent : 1200$</li>
            <li class="list-group-item">Lease length : 12months</li>
            <li class="list-group-item">Status : 1200$</li>

        </ul>
        
        <h3 class="my-3">Property Details</h3>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">Name: Adriana View</li>
            <li class="list-group-item">Address: 123 Somewhere St, City, State, 1345</li>
        </ul>

        <h3 class="my-3">Applicant Detail</h3>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">Name: Love Powell</li>
            <li class="list-group-item">Current Address: 987 EveryWere St, ValleyCity, State, 1345</li>
            <li class="list-group-item">Income : 52000$/annually</li>
            <li class="list-group-item">Employer : Self-employed</li>
            <li class="list-group-item">Has vehicules?  yes</li>
        </ul>
        

    </div>
    <c:if test="${applicant.property.owner.profile.id == loggedUser.id}">
        <div class="row my-3">
            <div class="d-flex">
                <a href="#" class="btn btn-outline-primary">Approve </a>       
                <a href="#" class="btn btn-danger mx-3">Reject</a>
                <a href="/owner" class="btn btn-light">Cancel</a>
            </div>
            
        </div>
    </c:if>
    </main>
</body>
</html>