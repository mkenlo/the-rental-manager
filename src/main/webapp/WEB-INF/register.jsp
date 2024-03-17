<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Register - Your rental Manager</title>
    <link rel="apple-touch-icon" sizes="180x180" href="/images/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/images/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/images/favicon/favicon-16x16.png">
    <link rel="manifest" href="/images/favicon/site.webmanifest">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
</head>

<body>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container">
            <a class="navbar-brand" href="/">Rental Manager</a>
        </div>
    </nav>

    <main class="container py-4">
        <div class="row">
            <div class="col-md-8">
                <h1>Create an Account</h1>
                <form:form action="/register" modelAttribute="newUser" method="post">
                    <div class="mb-3 row">
                        <div class="col">
                            <form:label class="form-label" path="firstname">Firstname<span class="text-danger"> *</span></form:label>
                            <form:input type="text" class="form-control" path="firstname"/>
                            <form:errors path="firstname" class="errors"/>
                        </div>
                        <div class="col">
                            <form:label class="form-label" path="lastname">Lastname<span class="text-danger"> *</span></form:label>
                            <form:input type="text" class="form-control" path="lastname"/>
                            <form:errors path="lastname" class="errors"/>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <div class="col">
                            <form:label class="form-label" path="username">Username<span class="text-danger"> *</span></form:label>
                            <form:input type="text" placeholder="username" path="username" class="form-control"/>
                            <form:errors path="username" class="errors"/>
                        </div>
                        <div class="col">
                            <form:label class="form-label" path="email">Email<span class="text-danger"> *</span></form:label>
                            <form:input type="email" placeholder="email" path="email" class="form-control"/>
                            <form:errors path="email" class="errors"/>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <div class="col">
                            <form:label class="form-label" path="password">Password<span class="text-danger"> *</span></form:label>
                            <form:input type="password" path="password" class="form-control"/>
                            <form:errors path="password" class="errors"/>
                        </div>
                        <div class="col">
                            <form:label class="form-label" path="passwordConfirm">Confirm Password<span class="text-danger"> *</span></form:label>
                            <form:input type="password" path="passwordConfirm" class="form-control"/>
                            <form:errors path="passwordConfirm" class="errors"/>
                        </div>
                    </div>
                    
                    <div class="mb-3">
                        <input type="submit" class="btn btn-danger btn-lg" value="Create an account" />
                        <span>or <a href="/login">Login</a></span>
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