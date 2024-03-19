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
    <title>Dashboard - Your rental Manager</title>
    <link rel="apple-touch-icon" sizes="180x180" href="/images/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/images/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/images/favicon/favicon-16x16.png">
    <link rel="manifest" href="images/favicon/site.webmanifest">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/d20aaabaac.js" crossorigin="anonymous"></script>
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
                    <ul class="navbar-nav">
                        <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="${loggedUser.roles.iterator().next().baseUrl}">Dashboard</a>
                        </li>
                    </ul>
                    <div class="d-flex align-items-center ms-auto border-start">
                        <a href="/myaccount" class="d-flex align-items-center justify-content-center p-1 text-decoration-none" >
                            <i class="fa-regular fa-circle-user fa-lg px-3"></i>
                            <strong>${loggedUser.firstname} ${loggedUser.lastname}</strong>
                        </a>
                        
                        <a href="/logout" class="text-decoration-none btn btn-dark mx-2 px-3 pt-1"><i class="fa-solid fa-right-from-bracket fa-xl"></i></a>
                        
                    </div>   
                </div>
            </div>
            </nav>
    </header>