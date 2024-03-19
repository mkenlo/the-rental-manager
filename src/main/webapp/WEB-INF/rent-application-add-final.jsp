    <%@ include file="header.jsp" %>

    <!-- Main start-->
    <main class="container py-4">

        <c:if test="${message}">
            <div class="row">
                <div class="alert alert-success" role="alert">${message}</div>
            </div>
        </c:if>

        <div class="row">
            <h3>New Rental Application</h3>

            <div class="row mb-4 mt-4 border-bottom" >
                <div class="col step-tabs p-2 disabled">
                    <p><i class="fa-solid fa-id-card"></i> Applicant</p>
                </div>
                <div class="col step-tabs p-2 disabled">
                    <p><i class="fa-solid fa-file-contract"></i> Lease Infos</p>
                </div>
                <div class="col step-tabs p-2 active bg-purple-subtle rounded-top">
                    <p><i class="fa-solid fa-rectangle-list"></i> Summary </p>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-8 col-md-4">
                    <h3 class="my-3">Property Details</h3>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Name: ${application.property.name}</li>
                        <li class="list-group-item">Address: ${application.property.address}</li>
                        <li class="list-group-item">Rent Price <span class="badge text-bg-info"><fmt:formatNumber value="${application.property.minLeasePrice}" type = "currency" maxFractionDigits="0"/></span></li>
                    </ul> 
                </div>
            
                <div class="col-xs-8 col-md-4">
                    <h3 class="my-3">Applicant Details</h3>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Name: ${application.applicant.firstname} ${applicant.lastname}</li>
                        <li class="list-group-item">Current Address: ${application.applicant.currentAddress}</li>
                        <li class="list-group-item">Annual Salary: <fmt:formatNumber value="${application.applicant.annualSalary}" type = "currency" maxFractionDigits="0"/></li>
                        <li class="list-group-item">Employer Name: ${application.applicant.employerName}</li>
                    </ul> 
                </div>
                <div class="col-xs-8 col-md-4">
                    <h3 class="my-3">Lease Details</h3>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Lease Length: ${application.leaseLength}</li>
                        <li class="list-group-item">Rent Price <fmt:formatNumber value="${application.rentPrice}" type = "currency" maxFractionDigits="0"/></li>
                        <li class="list-group-item">Move-In Date ${application.potentialMoveInDate}</li>
                        <li class="list-group-item">Status
                            <span class="badge text-bg-info">Submitted</span>
                            <span class="badge text-bg-warning">Pending</span></li>
                    </ul> 
                </div>
            </div>

            <a href="/applicant/my-applications" class="fs-3 test">See all my Applications</a>
            
            
        </div>


    </main>



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>

</html>