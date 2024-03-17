
    <%@ include file="header.jsp" %>

    <div class="container-fluid d-flex">

        <%@ include file="manager-sidebar.jsp" %>

        <!-- Main start-->
        <main class="container py-4">

            <div class="row">
                <c:if test="${message!=null}">
                    <div class="alert alert-primary alert-dismissible fade show col-md-4" role="alert">
                        <p>${message}</p>
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">
                    </div>
                </c:if>

                <div class="col-md-4">
                    <h1>Welcome back ${loggedUser.firstname}</h1>
                </div>
            </div>

            <div class="row my-3 properties-list">
                <div class="col-xl-12 grid-margin stretch-card">
                    <div class="card mb-3">
                        <div class="card-header d-flex justify-content-between">
                            <h4 class="card-title text-purple">My managed Properties </h4>
                            
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
                                            <th scope="col"> Status</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="item" items="${properties}">
                                            <tr>
                                                <td>${item.id}</td>
                                                <td><a href="/properties/${item.id}">${item.name}</a></td>
                                                <td>${item.address}</td>
                                                <td>${item.propertyType}</td>
                                                <td>${item.surface}</td>
                                                <td>${item.minLeasePrice}</td>
                                                <td>Available</td>

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