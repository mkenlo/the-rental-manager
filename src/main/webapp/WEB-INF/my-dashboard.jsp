   <%@ include file="header.jsp" %>
    <main class="container py-4">

        <div class="row my-3">
            <h1 class="mt-4">Account Details</h1>
            <div class="col-xl-12">
                <form:form action="/myaccount/edit" modelAttribute="loggedUser" method="put">
                <div class="card">
                    <div class="card-body">    
                            <div class="mb-3 row">
                                <div class="col">
                                    <form:label class="form-label" path="firstname">Firstname<span class="text-danger"> *</span></form:label>
                                    <form:input type="text" class="form-control" path="firstname" value="${editUser.firstname}"/>
                                    <form:errors path="firstname" class="errors"/>
                                </div>
                                <div class="col">
                                    <form:label class="form-label" path="lastname">Lastname<span class="text-danger"> *</span></form:label>
                                    <form:input type="text" class="form-control" path="lastname" value="${editUser.lastname}"/>
                                    <form:errors path="lastname" class="errors"/>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col">
                                    <label class="form-label" for="disabled-username" >Username<span class="text-danger"> *</span></label>
                                    <input type="text" class="form-control" aria-label="Disabled input example" value="${editUser.username}" disabled id="disabled-username"/>                                
                                    
                                </div>
                                <div class="col">
                                    <label class="form-label" for="disabled-pwd">Password<span class="text-danger"> *</span></label>
                                    <input type="password" class="form-control" aria-label="Disabled input example" disabled  value="${editUser.password}" id="disabled-pwd"/>                                
                                    
                                </div>                            
                            </div>
                            <div class="mb-3 row">
                                <div class="col">
                                    <form:label class="form-label" path="email">Email<span class="text-danger"> *</span></form:label>
                                    <form:input class="form-control" path="email"/>
                                    <form:errors path="email" class="errors"/>
                                </div>
                                <div class="col">
                                    <form:label class="form-label" path="phoneNum">Phone Num</form:label>
                                    <form:input class="form-control" path="phoneNum" />
                                    <form:errors path="phoneNum" class="errors"/>
                                </div>
                            </div>
                            <div class="row">
                                <form:hidden path="id"/>
                                <form:hidden path="username"/>
                                <form:hidden path="password"/>
                                <form:hidden path="roles"/>
                                <p><i class="fa-solid fa-calendar-days"></i> Joined on <u><fmt:formatDate type="date" value="${editUser.createdOn}"/></u></p>
                            
                            </div>
                            
                        
                    </div>
                    
                    <div class="card-footer d-flex justify-content-between">
                        <button type="submit" class="btn btn-primary">Edit my Profile</button>
                        <a href="${controllerPath}" class="btn btn-dark">Go to my Dashboard</a>
                    </div>
                    
                </div>
                </form:form>
            </div>
        </div>

    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>

</html>