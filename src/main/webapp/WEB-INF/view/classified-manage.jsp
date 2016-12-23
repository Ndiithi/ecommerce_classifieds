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
        <script src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
        <link href="<c:url value="/resources/css/jquery-ui.css"/>" rel="stylesheet" type="text/css">
        <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet" type="text/css">
        <script>
            $(function () {
                $(".date").datepicker({
                    dateFormat: "dd/mm/yy"
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



                <div class="form-group has-feedback col-sm-9 col-md-10 col-lg-11 col-xs-12">

                    <div class="input-group margin-bottom-sm">
                        <span class="input-group-addon"><i class="fa fa-search fa-fw"></i></span>
                        <input id="searchMsisdn" class="form-control text-center" type="text" placeholder="Enter phone number">

                    </div>

                </div>
                <div class="col-sm-3 col-md-2 col-lg-1 col-xs-12">
                    <button id="searchContentByPhone" class="btn btn-primary btn-block">search</button>
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
                            <th>Description</th>
                            <th>Location</th>
                            <th>Expiry Date</th>
                            <th>Email</th>
                            <th>Negotiable</th>
                            <th>Control</th>
                        </tr>
                    </thead>

                    <tbody>

                    </tbody>

                </table>
            </div>



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
                                <div class="col-sm-12">
                                    <label for="contentDesc">Short Description: 

                                        <i class="fa fa-asterisk shortDescription" style="color: #FF0000; visibility: hidden" aria-hidden="true"></i>
                                    </label>

                                    <textarea   id="contentDesc" class="form-control descript" rows="6" name="shortDescription"></textarea>
                                    <span name="shortDescription_validation" class="error"></span>
                                </div>

                                <div class="col-sm-6">
                                    <label for="locationDesc">Location:
                                        <i class="fa fa-asterisk location" style="color: #FF0000; visibility: hidden" aria-hidden="true"></i>
                                    </label>
                                    <input id="locationDesc" class="form-control locat" name="location" type="text" >
                                    <span name="location_validation" class="error"></span>
                                </div>

                                <div class="col-sm-6">
                                    <label for="expirydateDesc">Expiry Date:
                                        <i class="fa fa-asterisk expiryDate" style="color: #FF0000; visibility: hidden" aria-hidden="true"></i>
                                    </label>
                                    <input id="expirydateDesc" class="form-control date" name="expiryDate" type="text" >
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


            <div  id="confirmationModal" class="modal fade" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title  text-center">Delete Selected Content?</h4>
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
        <%@ include file="include/footer.jsp" %>
        <script src="<c:url value="/resources/js/contentmanager.js"/>"></script>
    </body>
</html>
