<%-- 
    Document   : classified-manage
    Created on : Dec 21, 2016, 10:16:43 AM
    Author     : Duncan
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>

        <title>Manage Classifieds</title>
        <%@ include file="include/header.jsp" %>
    </head>
    <body>
        <div class="container">
            <!-- Navigation -->
            <%@include file="include/navigation-bar.jsp"  %>

            <!-- Page Heading/Breadchouserumbs -->
            <div class="row" >
                <div style="padding-top: 4px;" class="col-sm-12">

                    <ol class="breadcrumb">
                        <li><a href="classified-home.html">Home</a>
                        </li>
                        <li class="active">Classified manage</li>
                    </ol>
                </div>



                <div class="form-group has-feedback col-sm-11">

                    <div class="input-group margin-bottom-sm">
                        <span class="input-group-addon"><i class="fa fa-search fa-fw"></i></span>
                        <input class="form-control text-center" type="text" placeholder="Enter phone number">

                    </div>

                </div>
                <div class="col-sm-1">
                    <button class="btn btn-primary">Search</button>
                </div>
            </div>
            
            
                <div class="row">



                    <div class="col-sm-3 text-center">

                        <div class="checkbox" style="background-color: #337ab7; color: #ffffff; border-radius: 3px;">
                            <label><input type="checkbox">Show
                            </label>
                        </div>

                        <span class="fa-stack fa-lg">

                            <i class="fa fa-circle fa-stack-2x" style="color: #ff33cc;"></i>
                            <i class="fa fa-building fa-stack-1x fa-inverse"></i>

                        </span>
                        House For Sale
                    </div>


                    <div class="col-sm-3 text-center">

                        <div class="checkbox" style="background-color: #337ab7; color: #ffffff; border-radius: 3px;">
                            <label><input type="checkbox">Show
                            </label>
                        </div>

                        <span class="fa-stack fa-lg">

                            <i class="fa fa-circle fa-stack-2x" style="color: #ccff33;"></i>
                            <i class="fa fa-briefcase fa-stack-1x fa-inverse"></i>

                        </span>
                        Jobs Ad
                    </div>



                    <div class="col-sm-3 text-center">

                        <div class="checkbox" style="background-color: #337ab7; color: #ffffff; border-radius: 3px;">
                            <label><input type="checkbox">Show
                            </label>
                        </div>

                        <span class="fa-stack fa-lg">

                            <i class="fa fa-circle fa-stack-2x" style="color: #ff7800;"></i>
                            <i class="fa fa-home fa-stack-1x fa-inverse"></i>

                        </span>
                        House For Rent Ad
                    </div>



                    <div class="col-sm-3 text-center">
                        <div class="checkbox" style="background-color: #337ab7; color: #ffffff; border-radius: 3px;">
                            <label><input type="checkbox">Show
                            </label>
                        </div>

                        <span class="fa-stack fa-lg">

                            <i class="fa fa-circle fa-stack-2x text-primary"></i>
                            <i class="fa fa-money fa-stack-1x fa-inverse"></i>

                        </span>
                        Buy And Sell Ad
                    </div>

                </div>

                <!--results table-->

                <div class="row" style="margin-top: 10px;background-color: #f5f5f0">
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>Firstname</th>
                                <th>Lastname</th>
                                <th>Email</th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr>
                                <td>John</td>
                                <td>Doe</td>
                                <td>john@example.com</td>
                            </tr>
                            <tr>
                                <td>Mary</td>
                                <td>Moe</td>
                                <td>mary@example.com</td>
                            </tr>
                            <tr>
                                <td>July</td>
                                <td>Dooley</td>
                                <td>july@example.com</td>
                            </tr>
                        </tbody>

                    </table>
                </div>

            




        </div>


    <!-- Footer -->
    <%@ include file="include/footer.jsp" %>
</body>
</html>
