<%@ include file="header.jsp" %>

    <main class="container p-4">

        <div class="d-flex justify-content-between my-4">
            <h1>Discover your new rental home</h1>
            <a href="/applicant/my-applications" class="btn btn-outline-dark btn-sm">My applications</a>
        </div>

        <div class="row my-4">

            <form class="d-flex justify-content-center" action="/properties/search" method="post">
                <select class="form-select mx-3" aria-label="select-property-type" name="searchPropertyType">
                    <option value="house" selected>House</option>
                    <option value="townhouse">TownHouse</option>
                    <option value="appartment">Appartment</option>
                    <option value="condo">Condo</option>
                </select>
                <input type="text" placeholder="property id or location" name="searchPropertyId" class="form-control mx-3">
                <button class="btn btn-outline-dark mx-3"><i class="fa-solid fa-sliders"></i> Filter </button>
                <button class="btn btn-dark">Search</button>
            </form>
        
        </div>

        <div class="row py-3">
            <c:forEach var="property" items="${properties}">                
                <div class="col-md-3">
                    <div class="card mb-3 listing">
                        <img class="card-img-top img-fluid"src="https://placehold.co/200x100?text=placeholder"/>                    
                    
                        <div class="card-body">
                            <h5 class="card-title"><a href="/properties/${property.id}">${property.name}</a></h5>
                            <p class="text-secondary"><i class="fa-solid fa-location-dot"></i> ${property.address}<p>                            
                            <div class="d-flex justify-content-between">
                                <p><i class="fa-solid fa-bed"></i> ${property.numBed}</p>
                                <p><i class="fa-solid fa-bath"></i> ${property.numBath}</p>
                                <p><i class="fa-solid fa-car"></i> 1</p>
                                <p><i class="fa-solid fa-hand-holding-dollar"></i> <fmt:formatNumber value = "${property.minLeasePrice}" type = "currency" maxFractionDigits="0"/></p>
                            </div>
                        </div>
                    
                    </div><!--end of card -->            
                </div> <!-- end of col-md-3 -->
                

            </c:forEach>       
        
        </div><!--end of row> -->

        <%@ include file="pagination.jsp" %>       

    </main>