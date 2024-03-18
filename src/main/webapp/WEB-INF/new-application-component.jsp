<div class="row">
    <form:form action="/applicant/start/application/${property.id}/step2?applicant=${applicant.id}" modelAttribute="newApplication" method="post">
        <div class="row">
            <div class="col-8">
                <h3 class="my-3">Property Details</h3>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Name: ${property.name}</li>
                    <li class="list-group-item">Address: ${property.address}</li>
                    <li class="list-group-item">Rent starting at:<fmt:formatNumber value="${property.minLeasePrice}" type = "currency" maxFractionDigits="0"/></li>
                </ul> 
            </div>
        </div>
        <div class="row">
            <div class="col-8">
                <h3 class="my-3">Applicant Details</h3>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Name: ${applicant.firstname} ${applicant.lastname}</li>
                    <li class="list-group-item">Current Address: ${applicant.currentAddress}</li>
                    <li class="list-group-item">Annual Salary: <fmt:formatNumber value="${applicant.annualSalary}" type = "currency" maxFractionDigits="0"/></li>
                    <li class="list-group-item">Employer Name: ${applicant.employerName}</li>
                </ul> 
            </div>
        </div>
        <h3 class="my-5">Aditional Information</h3>
        <div class="row mb-3">
            <div class="col-3">
                
                <form:label path="deposit">Deposit <span class="text-danger"> *</span></form:label>
                <form:input type="number" path="deposit" class="form-control"/>
                <form:errors path="deposit" class="errors"/>
            </div>
        
        </div>
        <div class="mb-3 row">
            <div class="col">
                <form:label class="form-label" path="potentialMoveInDate">Potential Move-In Date<span class="text-danger"> *</span></form:label>
                <form:input  type="date" path="potentialMoveInDate" class="form-control"/>
                <form:errors path="potentialMoveInDate" class="errors"/>
            </div>
            <div class="col">
                <form:label class="form-label" path="leaseLength">Lease Length<span class="text-danger"> *</span></form:label>
                <div>
                <c:set var="i" scope="page"/>
                <c:set var="j" scope="page"/>
                <c:forEach var="months" items="${[3,6,12,18,24]}" varStatus="loop">
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="leaseLength" id="inlineRadio-${loop.count}" value="${months}">
                        <label class="form-check-label" for="inlineRadio-${loop.count}">${months}</label>
                    </div>  
                </c:forEach>
                </div>                
                <form:errors path="leaseLength" class="errors"/>
            </div>
        </div>
        
        <div class="row mb-3">
            <div class="col">
                <form:label class="form-label" path="personalReferences">Have any references?</form:label>
                <form:textarea path="personalReferences" class="form-control" placeholder="Name, Phone Num"/>
                <form:errors path="personalReferences" class="errors"/>
            </div> 
            <div class="col">
                <form:label class="form-label" path="housingHistory">Housing History</form:label>
                <form:textarea path="housingHistory" class="form-control" placeholder="Address, LandLord Name, Landlord Phone Num"/>
                <form:errors path="housingHistory" class="errors"/>
            </div>   
        
        </div>
        
        <div class="mb-3">
            <form:hidden path="rentPrice" value="${property.minLeasePrice}" />
            <form:hidden path="applicant" value="${applicant.id}"/>
            <form:hidden path="property" value="${property.id}" />
            <a href="/applicant/start/application/${property.id}" class="btn btn-secondary"> Previous </a>
            <input type="submit" class="btn btn-dark" value="Submit" />
        </div>
    </form:form>
</div>