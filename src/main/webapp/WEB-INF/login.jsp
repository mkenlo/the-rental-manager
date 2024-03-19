<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login - Your rental Manager</title>
    <link rel="apple-touch-icon" sizes="180x180" href="/images/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/images/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/images/favicon/favicon-16x16.png">
    <link rel="manifest" href="/images/favicon/site.webmanifest">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="/css/style.css" rel="stylesheet">
</head>

<body>
     <header>
        <nav class="navbar navbar-expand-lg bg-body-tertiary shadow" >
            <div class="container">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarButtonsExample" aria-expanded="false" >
                    <span class="navbar-toggler-icon"></span>
                </button>
                <a class="navbar-brand" href="/">   <img src="/images/favicon/favicon-32x32.png" width="36" /> Rental Manager </a>
                <div class="collapse navbar-collapse" id="navbarButtonsExample">
                    
                    <div class="ms-auto">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="/register">Create an account</a>
                            </li>
                            
                        </ul> 
                    </div>   
                </div>
            </div>
            </nav>
    </header>
    <main class="container py-4">
        <div class="row">
            <c:if test='${error}'>
                <div class="alert alert-danger" role="alert">${error}</div>
            </c:if>
            <div class="col-md-6">
                <h1>Login</h1>
                <form:form action="/login" modelAttribute="newLogin" method="post">

                    <div class="mb-3">
                        <label class="form-label">Username</label>
                        <form:input type="text" path="username" class="form-control"/>
                        <form:errors path="username" class="errors"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Password</label>
                        <form:input type="password" path="password" class="form-control"/>
                        <form:errors path="password" class="errors"/>  
                    </div>
                    <div class="mb-3">
                        <input type="submit" class="btn btn-dark" value="Submit" />
                        <span>or <a href="/register">Create an account</a></span>
                    </div>
                </form:form>
            </div>
        </div>
    </main>




    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>

</html>