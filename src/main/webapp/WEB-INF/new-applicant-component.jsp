<div class="row">
    <form:form action="/applicant/start/application/${property.id}" modelAttribute="newApplicant" method="post">
        <h4>About you</h4>
        <div class="mb-3 row">
            <div class="col">
                <form:label class="form-label" path="firstname">Firstname<span class="text-danger"> *</span></form:label>
                <form:input type="text" class="form-control" path="firstname" value="${loggedUser.firstname}"/>
                <form:errors path="firstname" class="errors"/>
            </div>
            <div class="col">
                <form:label class="form-label" path="lastname">Lastname<span class="text-danger"> *</span></form:label>
                <form:input type="text" class="form-control" path="lastname" value="${loggedUser.lastname}"/>
                <form:errors path="lastname" class="errors"/>
            </div>
        </div>
        <div class="mb-3 row">
            <div class="col">
                <form:label class="form-label" path="dob">Date of Birth<span class="text-danger"> *</span></form:label>
                <form:input  type="date" path="dob" class="form-control"/>
                <form:errors path="dob" class="errors"/>
            </div>
            <div class="col">
                <form:label class="form-label" path="ssn">SSN<span class="text-danger"> *</span></form:label>
                <form:input type="passwod" placeholder="999999999" path="ssn" class="form-control"/>
                <form:errors path="ssn" class="errors"/>
            </div>
        </div>
        <div class="mb-3 row">
            <div class="col">
                <form:label class="form-label" path="currentAddress">Current Address<span class="text-danger"> *</span></form:label>
                <form:input type="address" path="currentAddress" class="form-control"/>
                <form:errors path="currentAddress" class="errors"/>
            </div>
        </div>
        <div class="row mb-3">
            <div class="col">
                <form:label class="form-label" path="vehiculeInfos">Please enter vehicule information if you have one/multiple? </form:label>
                <form:textarea path="vehiculeInfos" class="form-control" placeholder="Make, Model, Year, Color"/>
                <form:errors path="vehiculeInfos" class="errors"/>
            </div>   
        
        </div>
        <h4>About your Job</h4>
        <div class="mb-3 row">
            <div class="col">
                <form:label class="form-label" path="occupation">Occupation<span class="text-danger"> *</span></form:label>
                <form:input path="occupation" class="form-control"/>
                <form:errors path="occupation" class="errors"/>
            </div>                            
            <div class="col">
                <form:label class="form-label" path="annualSalary">Annual Salary<span class="text-danger"> *</span></form:label>
                <form:input type="number" path="annualSalary" class="form-control"/>
                <form:errors path="annualSalary" class="errors"/>
            </div>
        </div>
        <div class="row mb-3">
            <div class="col">
                <form:label class="form-label" path="employerName">Employer Name<span class="text-danger"> *</span></form:label>
                <form:input path="employerName" class="form-control"/>
                <form:errors path="employerName" class="errors"/>
            </div>   
            <div class="col">
                <form:label class="form-label" path="employerAddress">Employer Address<span class="text-danger"> *</span></form:label>
                <form:input path="employerAddress" class="form-control"/>
                <form:errors path="employerAddress" class="errors"/>
            </div> 
            <div class="col">
                <form:label class="form-label" path="employerPhoneNum">Employer Phone Num</form:label>
                <form:input path="employerPhoneNum" class="form-control"/>
                <form:errors path="employerPhoneNum" class="errors"/>
            </div>                          
        </div>       
        
        <div class="mb-3">
            <c:if test="${newApplicant.id !=null}" >
                <form:hidden path="id" />
            </c:if>
            <form:hidden path="profile" value="${loggedUser.id}"/>
            <input type="submit" class="btn btn-dark" value="Save and Continue" />
        </div>
    </form:form>
</div>