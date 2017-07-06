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

        <script>

            $(function () {
                $("#datepicker1").datepicker();
                $("#datepicker2").datepicker();
            });

        </script>

    </head>

    <body>
        <div id="container">
            <nav>
                <div class="nav-wrapper">
                    <a href="./" class="brand-logo">Reminder App</a>
                    <ul id="nav-mobile" class="right hide-on-med-and-down">
                        <li><a href="list">List of reminders</a></li>
                        <li><a href="search">Search</a></li>
                    </ul>
                </div>
            </nav>

            <div class="row">
                <div class="col s2"></div>
                <div class="col s8">
                    <div class="card blue-grey darken-1">
                        <form id="search" action="searchPost" type="POST">
                            <div class="row col s12">
                                <div class="input-field col s3" style="padding-top:25px;">
                                    <input placeholder="Start date" type="text" id="datepicker1" name="start" class="validate"/>
                                </div>
                                <div class="input-field col s3" style="padding-top:25px;">
                                    <input placeholder="End date" type="text" id="datepicker2" name="end" class="validate"/>
                                </div>
                                <div class="input-field col s2">
                                    <div class="row s12">
                                        <input type="checkbox" id="check1" name="status" value="DONE" />
                                        <label for="check1">Done</label>
                                    </div>
                                    <div class="row s12">
                                        <input type="checkbox" id="check2" name="status" value="NOT_DONE" />
                                        <label for="check2">Not Done</label>
                                    </div>
                                </div>
                                <div class="col s2" style="padding-top:25px">
                                    <a href="javascript:{}" onclick="document.getElementById('search').submit();" class="waves-effect waves-light btn-large">Search</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col s2"></div>
            </div>

            <div class="row s12">
                <div class="col s2"></div>
                <div class="col s8">
                    <div class="panel s12">
                        <c:if test="${not empty reminderModels}">
                            <c:forEach var="reminder" items="${reminderModels}">
                                <div class="col s4 m4">
                                    <div class="card">
                                        <div class="card-content">
                                            ${reminder.remindContent}
                                            ${reminder.dueDate}
                                            ${reminder.status}
                                            <div class="card-action">
                                                <a href="get/1">Details</a>
                                                <a href="update/1">Update</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
                <div class="col s2"></div>
            </div>
        </div>
    </body>
</html>
