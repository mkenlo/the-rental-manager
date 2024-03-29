
    <%@ include file="header.jsp" %>

    <div class="container">
        <!-- Main start-->
        <main class="container py-4">

            <div class="row">
                <c:if test="${message!=null}">
                    <div class="alert alert-primary alert-dismissible fade show col-md-4" role="alert">
                        <p>${message}</p>
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">
                    </div>
                </c:if>
            </div>
            
            <div class="row justify-content-end">
                <div class="col-2">
                    <a href="/owner/rented">
                    <div class="card card-summary">
                        <div class="card-body">
                            <h5 class="card-title">Rented</h5>
                            <p class="card-text">${rented}</p>
                        </div>
                    </div>
                    </a>
                </div>
                <div class="col-2 mx-3">
                    <a href="/owner/${loggedUser.id}/applications">
                        <div class="card card-summary">
                            <div class="card-body">
                                <h5 class="card-title">Applications</h5>
                                <p class="card-text">${countApplications}</p>
                                
                            </div>
                        </div>
                    </a>
                </div>   
                <div class="col-2 mx-3">
                    <a href="#">
                    <div class="card card-summary">
                        <div class="card-body">
                            <h5 class="card-title">Tenants</h5>
                            <p class="card-text">0</p>
                            
                        </div>
                    </div>  
                    </a>
                </div>  
                
            
            </div>

            <div class="row my-3 properties-list">
                <div class="col-xl-12 grid-margin stretch-card">
                    <div class="card mb-3">
                        <div class="card-header d-flex justify-content-between">
                            <h4 class="card-title text-purple">My Properties </h4>
                            <a href="/owner/properties/add" class="btn btn-outline-primary">+ new property</a>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col"> # </th>
                                            <th scope="col"> Property Name</th>
                                            <th scope="col"> Address</th>
                                            <th scope="col"> Type</th>
                                            <th scope="col"> Sqt ft</th>
                                            <th scope="col"> Min lease Price</th>
                                        </tr>
                                    </thead>
                                    <tbody class="table-striped">
                                        <c:forEach var="item" items="${properties}">
                                            <tr>
                                                <th scope="row">${item.id}</th>
                                                <td><a href="/properties/${item.id}">${item.name}</a></td>
                                                <td>${item.address}</td>
                                                <td>${item.propertyType}</td>
                                                <td>${item.surface}</td>
                                                <td><fmt:formatNumber value = "${item.minLeasePrice}" type = "currency" maxFractionDigits="0"/></td>

                                            </tr>
                                        </c:forEach>                                    
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div> <!-- end of card-->

                    <%@ include file="pagination.jsp" %>
                </div>
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