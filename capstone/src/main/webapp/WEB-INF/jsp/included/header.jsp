<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>


    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="/pub/css/global.css">

</head>
<body class="body">

<nav class="navbar navbar-expand-lg navbar-light " style="background: linear-gradient(180deg, rgba(209,186,255,1) 0%, rgba(252,224,234,0) 75%);
">
    <div class="container-fluid">

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse flex-grow-0" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/product/search">Product Search</a>
                </li>

                <%--                Employee Actions dropdown--%>

                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1"
                            data-bs-toggle="dropdown" aria-expanded="false">
                        Employee Actions
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">

                        <li class="nav-item">
                            <a class="nav-link" href="/employee/search">Employee Search</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/employee/create">Employee Create</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/employee/edit?employeeId=">Employee Edit</a>
                        </li>
                    </ul>
                </div>


                <%--                customer actions dropdown--%>

                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton2"
                            data-bs-toggle="dropdown" aria-expanded="false">
                        Customer Actions
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">

                        <li class="nav-item">
                            <a class="nav-link" href="/customer/search">Customer Search</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/customer/create">Customer Create</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/customer/edit?customerId=">Customer Edit</a>
                        </li>
                    </ul>
                </div>

                <li class="nav-item">
                    <a class="nav-link" href="/orders/search">Order Search</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/fileUpload">Upload File</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/account/create-account">Create User</a>
                </li>
                <sec:authorize access="!isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="/account/login">LogIn</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="/account/logout">LogOut</a>
                    </li>
                </sec:authorize>

                <sec:authorize access="hasAnyAuthority('ADMIN')">
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton2"
                            data-bs-toggle="dropdown" aria-expanded="false">
                        Admin
                    </button>
                    <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton1">
                        <li class="nav-item">
                            <span class="nav-link"><sec:authentication property="name"/></span>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/dashboard">Dashboard</a>
                        </li>

                    </ul>

                    </sec:authorize>

                    <sec:authorize access="hasAnyAuthority('USER')">
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton2"
                                data-bs-toggle="dropdown" aria-expanded="false">
                            User
                        </button>
                        <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton1">
                            <li class="nav-item">
                                <span class="nav-link"><sec:authentication property="name"/></span>
                            </li>

                        </ul>

                        </sec:authorize>

                        <%--                <li class="nav-item">--%>
                        <%--                    <a class="nav-link" href="/another-page">2nd Page</a>--%>
                        <%--                </li>--%>


            </ul>
        </div>
    </div>
</nav>