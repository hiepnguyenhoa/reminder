<%-- 
    Document   : index
    Created on : Jul 4, 2017, 1:58:49 PM
    Author     : HiepNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
                <div class="nav-wrapper" style="padding: 0 20px;">
                    <a href="./" class="brand-logo">Reminder App</a>
                    <ul id="nav-mobile" class="right hide-on-med-and-down">
                        <li><a href="list">List of reminders</a></li>
                        <li><a href="search">Search</a></li>
                    </ul>
                </div>
            </nav>
            <div class="row s12 m12">
                <div class="col s2 m1"></div>
                <div class="col s8">
                    <div class="row s12"><h2>Welcome to Reminder App</h2></div>
                    <div class="row s12" style="padding-top: 5px;">
                        To start using the application, let's begin with <a href="list"> List of reminders</a>.
                        The page allows you
                            <div style='padding-left: 50px'>- Adding new reminder with its information consisting of content, due date and status,</div>
                            <div style='padding-left: 50px'>- Listing all reminders having in system</div>
                    </div>
                    <div class="row s12" style="padding-top: 5px;">
                        The application also provides a simple <a href="search">search tool</a> which allows you to filter reminders by its due date and/or it status.<br>
                        If there is not any criteria provided, search function will list all reminders in system. 
                    </div>
                    <div class="row s12" style="padding-top: 5px;">
                        There is not paging for listing function.
                    </div>
                    <div class="row s12" style="padding-top: 5px;">
                        Enjoy and Thank you!
                    </div>
                    <div class="row s12" style="padding-top: 10px;">
                        If those functionalities works incorrectly, you have to make sure that the backend server runs at <b>localhost:9090</b> 
                    </div>
                </div>
                <div class="col s2 m1"></div>
            </div>
        </div>
    </body>
</html>
