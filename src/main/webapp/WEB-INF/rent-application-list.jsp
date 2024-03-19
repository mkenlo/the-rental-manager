
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
            
            <div class="row my-3 properties-list">
                <div class="col-xl-12 grid-margin stretch-card">
                    <div class="card mb-3">
                        <div class="card-header d-flex justify-content-between">
                            <h4 class="card-title text-purple">Rent Applications </h4>
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
                                            <th scope="col"> Submitted on</th>
                                            <th scope="col"> Deposit</th>
                                            <th scope="col"> Rent</th>
                                            <th scope="col"> Lease Length</th>
                                            <th scope="col"> Status</th>
                                            <th scope="col"> Actions</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="item" items="${applications}">
                                            <tr>
                                                <th scope="row"></th>
                                                <td><a href="/owner/properties/applications/${item.id}">${item.property.name}</a></td>
                                                <td>${item.property.address}</td>
                                                <td>${item.property.propertyType}</td>
                                                <td><fmt:formatDate type="date" value="${item.createdOn}"/></td>
                                                <td><fmt:formatNumber type="currency" value="${item.deposit}" maxFractionDigits="0"/></td>
                                                <td><fmt:formatNumber value="${item.rentPrice}" type = "currency" maxFractionDigits="0"/></td>
                                                <td>${item.leaseLength} months</td>
                                                <td><c:choose>
                                                        <c:when test = "${item.status == 'approved'}">
                                                            <span class="badge text-bg-success">${item.status}</span>
                                                        </c:when>
                                                        
                                                        <c:when test = "${item.status == 'rejected'}">
                                                            <span class="badge text-bg-danger">${item.status}</span>
                                                        </c:when>
                                                        
                                                        <c:otherwise>
                                                            <span class="badge text-bg-warning">${item.status}</span>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                                <td> <a href="/owner/${loggedUser.id}/applications/${item.id}/status?status=1" class="btn btn-outline-success btn-sm">Approve</a>  <a href="/owner/${loggedUser.id}/applications/${item.id}/status?status=0" class="btn btn-outline-danger btn-sm">Reject</a></td>

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