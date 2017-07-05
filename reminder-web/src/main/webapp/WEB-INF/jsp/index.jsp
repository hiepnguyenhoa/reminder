<%-- 
    Document   : index
    Created on : Jul 4, 2017, 1:58:49 PM
    Author     : HiepNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                $("#datepicker").datepicker();
            });

        </script>

    </head>

    <body>
        <div id="container">
            <nav>
                <div class="nav-wrapper">
                    <a href="#" class="brand-logo">Logo</a>
                    <ul id="nav-mobile" class="right hide-on-med-and-down">
                        <li><a href="./search">Search</a></li>
                    </ul>
                </div>
            </nav>

            <div class="row">
                <div class="col s2"></div>
                <div class="col s8">
                    <div class="card blue-grey darken-1">
                        <form id="addReminder" action="./add" class="row s12" type="POST">
                            <div class="input-field col s12">
                                <div class="col s6" style="padding-top:40px;">
                                    <input placeholder="Content" name="remindContent" type="text" class="validate">
                                </div>
                                <div class="input-field col s2" style="padding-top:25px;">
                                    <input placeholder="Due Date" type="text" id="datepicker" name="dueDate" class="validate"/>
                                </div>
                                <div class="col s2">
                                    <div class="row">
                                        <input name="status" type="radio" id="test1" value="DONE"/>
                                        <label for="test1">DONE</label>
                                    </div>
                                    <div class="row">
                                        <input name="status" type="radio" id="test2" value="NOT_DONE"/>
                                        <label for="test2">NOT DONE</label>
                                    </div>
                                </div>
                                <div class="col s2" style="padding-top:20px;">
                                    <a href="javascript:{}" onclick="document.getElementById('addReminder').submit();" class="waves-effect waves-light btn-large">Add</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col s2"></div>
            </div>

        </div>
    </body>
</html>
