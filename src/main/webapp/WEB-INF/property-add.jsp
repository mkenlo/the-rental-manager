
    <%@ include file="header.jsp" %>

    <div class="container-fluid d-flex">

        <%@ include file="sidebar.jsp" %>

        <!-- Main start-->
        <main class="container py-4">
            <h1>Add a property</h1>

            <form:form action="/owner/add-property" method="post" modelAttribute="newProperty">
                   <div class="mb-3 row">
                        <div class="col">
                            <form:label class="form-label" path="name">Name<span class="text-danger"> *</span></form:label>
                            <form:input class="form-control" path="name"/>
                            <form:errors path="name" class="errors"/>
                        </div>
                        <div class="col">
                            <form:label class="form-label" path="address">Address<span class="text-danger"> *</span></form:label>
                            <form:input class="form-control" path="address"/>
                            <form:errors path="address" class="errors"/>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <div class="col">
                            <form:label class="form-label" path="propertyType">Property Type<span class="text-danger"> *</span></form:label>
                            <select class="form-select" aria-label="select-property-type" name="propertyType">
                                <option selected>Open menu</option>
                                <option value="house">House</option>
                                <option value="townhouse">TownHouse</option>
                                <option value="appartment">Appartment</option>
                                <option value="condo">Condo</option>
                            </select>
                            <form:errors path="propertyType" class="errors"/>
                        </div>
                        <div class="col">
                            <form:label class="form-label" path="surface">Sqt Ft<span class="text-danger"> *</span></form:label>
                            <form:input type="number" placeholder="2540" path="surface" class="form-control"/>
                            <form:errors path="surface" class="errors"/>
                        </div>
                        <div class="col">
                            <form:label class="form-label" path="minLeasePrice">Minimum Lease Price</form:label>
                            <form:input type="number" placeholder="900" path="minLeasePrice" class="form-control"/>
                            <form:errors path="minLeasePrice" class="errors"/>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <div>
                            <form:label class="form-label" path="description">Description<span class="text-danger"> *</span></form:label>
                            <form:textarea path="description" class="form-control" style="height:150px"/>
                            <form:errors path="description" class="errors"/>
                        </div>
                        <div>
                            <form:hidden path="owner" value="${loggedUser.landlord.id}" />
                        
                        </div>
                        
                    </div>
                    
                    <div class="mb-3">
                        <input type="submit" class="btn btn-primary btn-lg" value="Add" />
                    </div>
            
            </form:form>

        </main>
        <!-- Main end-->
    </div>
    <script src="https://kit.fontawesome.com/d20aaabaac.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>