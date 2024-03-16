
    <%@ include file="header.jsp" %>

    <div class="container-fluid d-flex">

        <%@ include file="sidebar.jsp" %>

        <!-- Main start-->
        <main class="container py-4">

            <div class="row">
                <c:if test="${message!=null}">
                    <div class="alert alert-primary alert-dismissible fade show col-md-4" role="alert">
                        <p>${message}</p>
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">
                    </div>
                </c:if>

                <div class="col-md-6">
                    <h3>Welcome back ${loggedUser.firstname}</h3>
                </div>
            </div>

            <div class="row my-3 properties-list">
                <div class="col-xl-12 grid-margin stretch-card">
                    <div class="card mb-3">
                        <div class="card-header d-flex justify-content-between">
                            <h4 class="card-title text-purple">My Properties </h4>
                            
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
                                            <th scope="col"> owner</th>
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
                                                <td><fmt:formatNumber value = "${item.minLeasePrice}" type = "currency" maxFractionDigits="0"/>$</td>
                                                <td>${item.owner.profile.firstname}</td>

                                            </tr>
                                        </c:forEach>                                    
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div> <!-- end of card-->

                    <!-- pagination start-->
                    <c:if test="${totalPages>1}">
                        <nav aria-label="page navigation">
                            <ul class="pagination justify-content-center">
                                <c:if test="${currentPage>1}">
                                    <li class="page-item">
                                        <a class="page-link" href="/owner?page=${currentPage - 1}" tabindex="-1">Previous</a>
                                    </li>
                                </c:if>
                                
                                <li class="page-item"><a class="page-link" href="#">${currentPage}</a></li>

                                <c:if test="${currentPage<totalPages}">
                                    <li class="page-item">
                                        <a class="page-link" href="/owner?page=${currentPage + 1}">Next</a>
                                    </li>
                                </c:if>
                            </ul>
                        </nav>
                    </c:if>
                    <!-- pagination end-->
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