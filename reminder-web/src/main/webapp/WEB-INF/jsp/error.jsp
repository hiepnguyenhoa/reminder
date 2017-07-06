<%-- 
    Document   : index
    Created on : Jul 4, 2017, 1:58:49 PM
    Author     : HiepNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Reminder project</title>
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.99.0/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.99.0/js/materialize.min.js"></script>

        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    </head>

    <body>
        <div id="container">
            <nav>
                <nav>
                    <div class="nav-wrapper" style="padding: 0 20px;">
                        <a href="./" class="brand-logo">Reminder App</a>
                        <ul id="nav-mobile" class="right hide-on-med-and-down">
                            <li><a href="list">List of reminders</a></li>
                            <li><a href="search">Search</a></li>
                        </ul>
                    </div>
                </nav>
            </nav>
            
            <div class="row s12" style="padding-top: 50px;">
                <div class="col s2"></div>
                <div class="col s8">
                    Error - ${message}
                </div>
            </div>

            <div class="row s12">
                <div class="col s2"></div>
                <div class="col s8">
                    <div class ="row s12">
                        <div class="progress">
                            <div class="indeterminate"></div>
                        </div>
                    </div>
                    <div class="col s2"></div>
                </div>
            </div>
    </body>
</html>
