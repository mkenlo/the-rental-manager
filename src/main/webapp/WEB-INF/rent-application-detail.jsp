    <%@ include file="header.jsp" %>

    <!-- Main start-->
    <main class="container py-4">

    <div class="row">  
        <h3 class="my-3">About the application</h3>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">Submitted on: <fmt:formatDate value="${application.createdOn}" type ="date"/></li>
            <li class="list-group-item">Deposit: <fmt:formatNumber value="${application.deposit}" type = "currency" maxFractionDigits="0"/></li>
            <li class="list-group-item">Rent : <fmt:formatNumber value="${application.rentPrice}" type = "currency" maxFractionDigits="0"/></li>
            <li class="list-group-item">Lease length : ${application.leaseLength}months</li>
            <li class="list-group-item">Status : 
            <c:choose>
                <c:when test = "${application.status == 'approved'}">
                    <span class="badge text-bg-success">${application.status}</span>
                    <c:if test="${controllerPath=="applicant"}">
                        <a href="#" class="btn btn-outline-success btn-sm">Sign Lease</a>
                    </c:if> 
                </c:when>
                
                <c:when test = "${application.status == 'rejected'}">
                    <span class="badge text-bg-danger">${application.status}</span>
                </c:when>
                
                <c:otherwise>
                    <span class="badge text-bg-warning">${application.status}</span>
                </c:otherwise>
            </c:choose>
            
            </li>

        </ul>
        
        <h3 class="my-3">Property Details</h3>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">Name: ${application.property.name}</li>
            <li class="list-group-item">Address: ${application.property.address}</li>
        </ul>

        <h3 class="my-3">Applicant Detail</h3>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">Name:  ${application.applicant.firstname} ${applicant.lastname}</li>
            <li class="list-group-item">Current Address: ${application.applicant.currentAddress}</li>
            <li class="list-group-item">Income : <fmt:formatNumber value="${application.applicant.annualSalary}" type = "currency" maxFractionDigits="0"/>/annually</li>
            <li class="list-group-item">Employer : ${application.applicant.employerName}</li>
            <li class="list-group-item">Has vehicules?  yes</li>
        </ul>
        

    </div>
    <c:if test="${application.property.owner.profile.id == loggedUser.id}">
        <div class="row my-3">
            <div class="d-flex">
                <a href="/owner/${loggedUser.id}/applications/${application.id}/status?status=1" class="btn btn-outline-primary">Approve </a>       
                <a href="/owner/${loggedUser.id}/applications/${application.id}/status?status=0" class="btn btn-danger mx-3">Reject</a>
                <a href="/owner" class="btn btn-light">Cancel</a>
            </div>
            
        </div>
    </c:if>
    </main>
</body>
</html>