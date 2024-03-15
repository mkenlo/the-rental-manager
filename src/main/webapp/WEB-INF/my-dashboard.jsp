<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %> 

<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Dashboard - Yor rental Manager</title>
    <link rel="apple-touch-icon" sizes="180x180" href="images/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="images/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="images/favicon/favicon-16x16.png">
    <link rel="manifest" href="images/favicon/site.webmanifest">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
    <link href="css/style.css" rel="stylesheet">
</head>

<body>

    <%@ include file="navbar.jsp" %>

    <main class="container py-4">

        <div class="row">
            <div class="alert alert-secondary alert-dismissible fade show col-md-4" role="alert">
                <p>Welcome back <strong>${loggedUser.firstname} </strong>!!!</p>        
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">
            </div>
            <c:if test="${message!=null}">

                <div class="alert alert-primary alert-dismissible fade show col-md-4" role="alert">
                <p>${message}</p>        
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">
            </div>
            
            </c:if>
        </div>
        <c:if test="${pickARole}">
            <form:form action="/myaccount/addRole" method="post" modelAttribute="role">
                
                <div class="row py-3"> 
                    <h1 class="py-3">How do you want to continue?</h1>
                    <c:forEach var="role" items="${roles}">
                        <c:if test="${role.name!='ROLE_APPLICANT'}">
                        <div class="col-xs-6 col-md-8 mx-1 mb-3 card border-left-info radio-card">
                            <div class="card-body">                            
                                <input name="role" class="radio" type="radio" value="${role.id}"
                                <c:if test="${role.name=='ROLE_LANDLORD'}">checked</c:if>
                                > I'm a ${role.displayName}                            
                            </div>
                        </div>  
                        </c:if>   
                    </c:forEach>
                </div>
                <div class="row">
                    <div class="col-xl-4 col-md-4"><button class="btn btn-primary btn-xs" type="submit">Continue </button></div>            
                </div>
            </form:form>
        </c:if>
        </div>
        

        <div class="row my-3">
            <div class=" card">

                <div class="card-header"><h2>About me</h2></div>
                <div class="card-body">

                    <p>Hi I'm <strong>${loggedUser.firstname} ${loggedUser.lastname}</strong><p>
                    <p><span class="material-symbols-outlined">mail</span> ${loggedUser.email}</p>
                    <p><span class="material-symbols-outlined">call</span>${loggedUser.phoneNum}</p>
                
                    <div class="card-footer d-flex justify-content-between">
                        <a href="#" class="btn btn-primary">Edit my Profile</a>
                        <c:if test="${!pickARole}">
                            <a href="${loggedUser.roles.iterator().next().baseUrl}" class="btn btn-danger">Go to my Dashboard</a>
                        </c:if>
                    
                    </div>
                </div>
            </div>
        </div>

    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>

</html>