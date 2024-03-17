    <%@ include file="header.jsp" %>

    <!-- Main start-->
    <main class="container py-4">

        <div class="d-flex mb-3 justify-content-end">
            <a href="/manager" class="nav-link text-primary" aria-current="page">
                    <i class="fa-solid fa-house-user fa-lg"></i>
                    Dashboard
            </a>
        </div>

        <div class="row">

            <form:form action="/applicant/start/application/${property.id}" method="post">
            
            <h3>New Rental Application</h3>
            <ul class="nav nav-fill nav-tabs" role="tablist">
                <li class="nav-item" role="presentation">
                    <a class="nav-link active" id="fill-tab-0" data-bs-toggle="tab" href="#fill-tabpanel-0" role="tab" aria-controls="fill-tabpanel-0" aria-selected="true"><i class="fa-solid fa-id-card"></i> Applicant </a>
                </li>
                <li class="nav-item" role="presentation">
                    <a class="nav-link" id="fill-tab-1" data-bs-toggle="tab" href="#fill-tabpanel-1" role="tab" aria-controls="fill-tabpanel-1" aria-selected="false"> <i class="fa-solid fa-file-contract"></i> Lease Information </a>
                </li>
                <li class="nav-item" role="presentation">
                    <a class="nav-link" id="fill-tab-2" data-bs-toggle="tab" href="#fill-tabpanel-2" role="tab" aria-controls="fill-tabpanel-2" aria-selected="false"><i class="fa-regular fa-rectangle-list"></i> Summary </a>
                </li>
            </ul>
            <div class="tab-content pt-5" id="tab-content">
                <div class="tab-pane active" id="fill-tabpanel-0" role="tabpanel" aria-labelledby="fill-tab-0">Tab 1 selected</div>
                <div class="tab-pane" id="fill-tabpanel-1" role="tabpanel" aria-labelledby="fill-tab-1">Tab Tab 2 selected</div>
                <div class="tab-pane" id="fill-tabpanel-2" role="tabpanel" aria-labelledby="fill-tab-2">Tab Tab 3 selected</div>
            </div>
            
            
            
            </form:form>    
        
        </div>


    </main>



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>

</html>