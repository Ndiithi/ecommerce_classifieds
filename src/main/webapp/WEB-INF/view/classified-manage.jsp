<%-- 
    Document   : classified-manage
    Created on : Dec 21, 2016, 10:16:43 AM
    Author     : Duncan Ndiithi
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>

        <title>Manage Classifieds</title>
        <%@ include file="include/header.jsp" %>
        <script src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
        <link href="<c:url value="/resources/css/jquery-ui.css"/>" rel="stylesheet" type="text/css">
        <link href="<c:url value="/resources/css/simplePagination.css"/>" rel="stylesheet" type="text/css">
        <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet" type="text/css">
        <script>
            $(function () {
                $(".date").datepicker({
                    dateFormat: "dd/mm/yy",
                    changeYear: true,
                    yearRange: "nn:+2"
                });
            });
        </script>
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

                <div class="alert  alert-dismissible fade in col-sm-12 text-center" id="success-alert" style="display: none">

                    <strong>  
                        <p class="messageFeedback"></p>
                    </strong>
                </div>

                <div class="form-group has-feedback col-sm-9 col-md-10 col-lg-11 col-xs-12">

                    <div class="input-group margin-bottom-sm">
                        <span class="input-group-addon"><i class="fa fa-search fa-fw"></i></span>
                        <input id="searchMsisdn" class="form-control text-center" type="text" placeholder="Enter phone number">

                    </div>

                </div>
                <div class="col-sm-3 col-md-2 col-lg-1 col-xs-12">
                    <button id="searchContentByPhone" class="btn btn-primary btn-block">search</button>
                </div>
                <div class="col-sm-12 text-center" style="display: inline; font-size: 15px; color: red">
                    <p class="generalMessage"></p>
                    <p class="showProgress">
                        <strong>Processing</strong>
                        <i class="fa fa-spinner fa-spin fa-lx fa-fw"></i>
                    </p>
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
                <table class="table table-striped table-hover" id="contentItems">
                    <thead>
                        <tr>
                            <th>Category</th>
                            <th>Sub-category</th>
                            <th>Description</th>
                            <th>Location</th>
                            <th>Price</th>
                            <th>Expiry Date</th>
                            <th>Email</th>
                            <th>Negotiable</th>
                            <th>Control</th>
                        </tr>
                    </thead>

                    <tbody>

                    </tbody>

                </table>

                <div  id="page-nav" style="margin-left: auto;margin-right: auto;width: 30%" class="compact-theme"></div>
            </div>


            <!--Edit content modal-->
            <div  id="contentModal" class="modal fade" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Edit Content</h4>
                        </div>
                        <div class="modal-body">


                            <div class="row form-group">
                                <div class="col-sm-12 text-center" style="display: inline; font-size: 15px; color: red">
                                    <p class="showEditProgress">
                                        <strong>Processing</strong>
                                        <i class="fa fa-spinner fa-spin fa-lx fa-fw"></i>
                                    </p>
                                </div>
                                <div class="col-sm-12">
                                    <label for="contentDesc">Short Description: 

                                        <i class="fa fa-asterisk shortDescription" style="color: #FF0000; visibility: hidden" aria-hidden="true"></i>
                                    </label>

                                    <textarea   id="contentDesc" class="form-control descript" rows="6" name="shortDescription"></textarea>
                                    <span name="shortDescription_validation" class="error"></span>
                                </div>


                                <div class="col-sm-6">
                                    <label for="subCategoryDesc">Category:
                                        <i class="fa fa-asterisk sub-category" style="color: #FF0000;visibility: hidden" aria-hidden="true"></i>
                                    </label>
                                    <select id="subCategoryDesc" class="form-control" name="sub-category" class="form-control">

                                    </select>


                                    <span name="sub-category_validation" class="error"></span>
                                </div>

                                <div class="col-sm-6">
                                    <label for="locationDesc">Location:
                                        <i class="fa fa-asterisk location" style="color: #FF0000; visibility: hidden" aria-hidden="true"></i>
                                    </label>
                                    <select id="locationDesc" class="form-control locat" name="location" class="form-control" >

                                    </select>

                                    
                                    <span name="location_validation" class="error"></span>
                                </div>


                                <div class="col-sm-6">
                                    <label for="priceDesc">Price:
                                        <i class="fa fa-asterisk price" style="color: #FF0000; " aria-hidden="true"></i>
                                    </label>
                                    <div class="input-group">
                                        <div class="input-group-btn">
                                            <button type="button" class="btn btn-default dropdown-toggle currency-symbol" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">USD</button>
                                            <ul class="dropdown-menu">
                                                <li onclick="currencyManager('usd')"><a href="#">USD</a></li>
                                                <li onclick="currencyManager('ke')"><a href="#">KSH</a></li>
                                                <li onclick="currencyManager('zm')"><a href="#">ZMW</a></li>

                                            </ul>
                                        </div><!-- /btn-group -->
                                        <input id="priceDesc" name="price" type="text" class="form-control" aria-label="...">

                                    </div>
                                    <span name="price_validation" class="error"></span>
                                </div>

                                <div class="col-sm-6">
                                    <label for="expirydateDesc">Expiry Date:
                                        <i class="fa fa-asterisk expiryDate" style="color: #FF0000; visibility: hidden" aria-hidden="true"></i>
                                    </label>
                                    <input id="expirydateDesc" class="form-control date" name="expiryDate" type="text" >
                                    <span name="expiryDate_validation" class="error"></span>
                                </div>

                                <div class="col-sm-12">
                                    <label for="emailDesc">Email:
                                        <i class="fa fa-asterisk email" style="color: #FF0000; visibility: hidden" aria-hidden="true"></i>
                                    </label>
                                    <input id="emailDesc" class="form-control" name="email" type="text" >
                                    <span name="email_validation" class="error"></span>
                                </div>





                                <div class="checkbox col-sm-12">

                                    <div class="checkbox">
                                        <label><input id="negotiableCheckbox" name="isNegotiable" type="checkbox"><strong>Negotiable</strong>
                                        </label>
                                    </div>
                                </div>


                            </div>



                        </div>


                        <div class="modal-footer">
                            <button id="submitEditedContent" type="button" class="btn btn-primary">Submit</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        </div>


                    </div>

                </div>
            </div>

            <!--Confirmation modal-->
            <div  id="confirmationModal" class="modal fade" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title  text-center">Delete Selected Content?</h4>

                            <div class="col-sm-12 text-center" style="display: inline; font-size: 15px; color: red">
                                <p class="showDeleteProgress">
                                    <strong>Processing</strong>
                                    <i class="fa fa-spinner fa-spin fa-lx fa-fw"></i>
                                </p>
                            </div>

                        </div>

                        <div class="modal-footer">
                            <button id="deleteSelectedContent" type="button" class="btn btn-primary">Yes</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        </div>

                    </div>





                </div>

            </div>


        </div>
        <!-- Footer -->
        <%@ include file="include/weblink.jsp" %>
        <script src="<c:url value="/resources/js/contentmanager.js"/>"></script>
        <script>
                                                    //script to show and hide image on ajax requests.
                                                    $(".showProgress").hide();
                                                    $(".generalMessage").hide();
                                                    $("p.showEditProgress").hide();
                                                    $("p.showDeleteProgress").hide();
        </script>
        <script src="<c:url value="/resources/js/simplePagination.js"/>"></script>


    </body>
</html>
