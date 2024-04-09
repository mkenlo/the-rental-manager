<!-- pagination start-->
<c:if test="${totalPages>1}">
    <nav aria-label="page navigation">
        <ul class="pagination justify-content-center">
            <c:if test="${currentPage>1}">
                <li class="page-item">
                    <a class="page-link" href="${controllerPath}?page=${currentPage - 1}" tabindex="-1">Previous</a>
                </li>
            </c:if>
            
            <li class="page-item"><a class="page-link" href="#">${currentPage}</a></li>

            <c:if test="${currentPage<totalPages}">
                <li class="page-item">
                    <a class="page-link" href="${controllerPath}?page=${currentPage + 1}">Next</a>
                </li>
            </c:if>
        </ul>
    </nav>
</c:if>
<!-- pagination end-->