
    <%@ include file="header.jsp" %>

    <div class="container-fluid d-flex">
        <!-- Main start-->
        <main class="container py-4">
        <div class="d-flex mb-3 justify-content-end">
                <a href="/owner" class="nav-link text-primary" aria-current="page">
                        <i class="fa-solid fa-house-user fa-lg"></i>
                        Dashboard
                </a>
        </div>

        <div class="row">
            <h1>Edit a property</h1>

            <form:form action="/owner/properties/${property.id}/edit" method="put" modelAttribute="property">
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
                                <option value="house" <c:if test="${propertyType=='house'}"> selected</c:if>>House</option>
                                <option value="townhouse" <c:if test="${propertyType=='townhouse'}"> selected</c:if>>TownHouse</option>
                                <option value="appartment" <c:if test="${propertyType=='appartment'}"> selected</c:if>>Appartment</option>
                                <option value="condo" <c:if test="${propertyType=='condo'}"> selected</c:if>>Condo</option>
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
                        <div class="col">
                            <form:label class="form-label" path="description">Description<span class="text-danger"> *</span></form:label>
                            <form:textarea path="description" class="form-control" style="height:150px"/>
                            <form:errors path="description" class="errors"/>
                        </div>
                        <div class="col">
                            <form:label class="form-label" path="amenities">Amenities<span class="text-danger"> *</span></form:label>
                            <form:textarea path="amenities" class="form-control" style="height:150px"/>
                            <form:errors path="amenities" class="errors"/>
                        </div>
                        <div>
                            <form:hidden path="id" />
                            <form:hidden path="owner"/>
                            <input type="hidden" value="PUT" name="_method">
                        
                        </div>
                        
                    </div>
                    <div class="mb-3 row">
                       
                        <div class="col">
                            <form:label class="form-label" path="numBed">Number of Bed<span class="text-danger"> *</span></form:label>
                            <form:input type="number" path="numBed" class="form-control"/>
                            <form:errors path="numBed" class="errors"/>
                        </div>
                        <div class="col">
                            <form:label class="form-label" path="numBath">Number of Bath</form:label>
                            <form:input type="number" placeholder="1" path="numBath" class="form-control"/>
                            <form:errors path="numBed" class="errors"/>
                        </div>
                    </div>
                    
                    <div class="mb-3">
                        <input type="submit" class="btn btn-danger btn-lg" value="Edit" />
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