
    <%@ include file="header.jsp" %>

    <div class="container">
            <!-- Main start-->
        <main class="container py-4">
            
            <div class="row">

                <h1>Add a property</h1>
                
                <form:form action="/owner/properties/add" method="post" modelAttribute="newProperty">
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
                            <form:label class="form-label" path="propertyType">Property Type</form:label>
                            <select class="form-select" aria-label="select-property-type" name="propertyType">
                                <option value="house">House</option>
                                <option value="townhouse">TownHouse</option>
                                <option value="appartment">Appartment</option>
                                <option value="condo">Condo</option>
                            </select>
                            <form:errors path="propertyType" class="errors"/>
                        </div>
                        <div class="col">
                            <form:label class="form-label" path="surface">Sqt Ft</form:label>
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
                            <form:label class="form-label" path="description">Description</form:label>
                            <form:textarea path="description" class="form-control" style="height:150px"/>
                            <form:errors path="description" class="errors"/>
                        </div>
                        <div>
                            <form:hidden path="owner" value="${loggedUser.landlord.id}" />
                        
                        </div>
                        
                    </div>
                    <div class="mb-3 row">
                        <div class="col">
                            <form:label class="form-label" path="numBed">Number of Bed</form:label>
                            <form:input class="form-control" path="numBed"/>
                            <form:errors path="numBed" class="errors"/>
                        </div>
                        <div class="col">
                            <form:label class="form-label" path="numBath">Number of Bath</form:label>
                            <form:input class="form-control" path="numBath"/>
                            <form:errors path="numBath" class="errors"/>
                        </div>
                    </div>
                    
                    <div class="mb-3">
                        <input type="submit" class="btn btn-dark" value="Add" />
                        <a class="text-secondary mx-3" href="/owner">Cancel</a>
                    </div>
            
            </form:form>
            
            
            </div>

        </main>
        <!-- Main end-->
    </div>
    <script src="https://kit.fontawesome.com/d20aaabaac.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>