    <%@ include file="header.jsp" %>

    <!-- Main start-->
    <main class="container py-4">

        <div class="d-flex mb-3 justify-content-end">
            <a href="/${controllerPath}" class="nav-link text-primary" aria-current="page">
                    <i class="fa-solid fa-house-user fa-lg"></i>
                    Dashboard
            </a>
        </div>

        <div class="row">
            <h3>New Rental Application</h3>

            <div class="row mb-4 mt-4 border-bottom" >
                <div class="col step-tabs p-2 disabled">
                    <p><i class="fa-solid fa-id-card"></i> Applicant</p>
                </div>
                <div class="col step-tabs p-2 active bg-purple-subtle rounded-top">
                    <p><i class="fa-solid fa-file-contract"></i> Lease Infos</p>
                </div>
                <div class="col step-tabs p-2 disabled">
                    <p><i class="fa-solid fa-rectangle-list"></i> Summary </p>
                </div>
            </div>
            <%@ include file="new-application-component.jsp" %>
            
        </div>


    </main>



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>

</html>