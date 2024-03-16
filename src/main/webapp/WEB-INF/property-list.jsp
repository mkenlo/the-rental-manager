<div class="col-xl-12 grid-margin stretch-card">
<div class="card">
    <div class="card-header d-flex justify-content-between">
        <h4 class="card-title text-purple">List of Properties </h4>
        <a href="/properties/new?redirect=manager" class="btn btn-purple">+ new property</a>
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
                            <td>${item.adress}</td>
                            <td>${item.type}</td>
                            <td>${item.surface}</td>  
                            <td>${item.minLeasePrice}</td>  
                            <td>Available</td>                  
                        
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>  <!-- end of card-->
</div>