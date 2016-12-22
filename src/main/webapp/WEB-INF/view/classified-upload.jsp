<%-- 
    Document   : services
    Created on : Nov 30, 2016, 3:29:26 PM
    Author     : Duncan
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <%@ include file="include/header.jsp" %>
        <title>Upload Classifieds</title>
        <script src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
        <link href="<c:url value="/resources/css/jquery-ui.css"/>" rel="stylesheet" type="text/css">
        <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet" type="text/css">
        <script>
            $(function () {
                $(".expirydate").datepicker({
                    dateFormat: "dd/mm/yy"
                });
            });
        </script>
    </head>

    <body>

        <!-- Navigation -->


        <%@include file="include/navigation-bar.jsp"  %>



        <!-- Page Content -->
        <div class="container">

            <!-- Page Heading/Breadchouserumbs -->
            <div class="row">
                <div style="padding-top: 4px;" class="col-lg-12">

                    <ol class="breadcrumb">
                        <li><a href="classified-home.html">Home</a>
                        </li>
                        <li class="active">Services</li>
                    </ol>
                </div>
            </div>

            <div class="alert alert-danger alert-dismissible fade in" id="success-alert" style="display: none">

                <strong>  
                    Kindly review fields marked   <i class="fa fa-asterisk marker" style="color: #FF0000;" aria-hidden="true"></i>
                </strong>
            </div>

            <div class="row classifiedoption">
                <div class="col-lg-12" >
                    <h2 class="page-header">Classifieds</h2>
                </div>
                <div class="col-md-3 col-sm-6" >
                    <div class="panel panel-default text-center">
                        <div class="panel-heading">
                            <span class="fa-stack fa-1x">
                                <i class="fa fa-circle fa-stack-2x text-primary"></i>
                                <i class="fa fa-building fa-stack-1x fa-inverse"></i>
                            </span>
                        </div>
                        <div class="panel-body">
                            <h4>House for sale ad</h4>
                            <p>Add house for sale</p>
                            <a href="#" id="houseforsalebtn" class="btn btn-primary btn-lg house4sale"><span class="fa fa-plus"></span></a>

                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <div class="panel panel-default text-center">
                        <div class="panel-heading">
                            <span class="fa-stack fa-1x">
                                <i class="fa fa-circle fa-stack-2x text-primary"></i>
                                <i class="fa fa-briefcase fa-stack-1x fa-inverse"></i>
                            </span>
                        </div>
                        <div class="panel-body">
                            <h4>Jobs ad</h4>
                            <p>Add job opening</p>
                            <a href="#" id="jobsadbtn" class="btn btn-primary  btn-lg"><span class="fa fa-plus"></span></a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <div class="panel panel-default text-center">
                        <div class="panel-heading">
                            <span class="fa-stack fa-1x">
                                <i class="fa fa-circle fa-stack-2x text-primary"></i>
                                <i class="fa fa-home fa-stack-1x fa-inverse"></i>
                            </span>
                        </div>
                        <div class="panel-body">
                            <h4>House for rent ad</h4>
                            <p>Add an House for rent</p>
                            <a href="#" id="houseforrentbtn" class="btn btn-primary  btn-lg"><span class="fa fa-plus"></span></a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <div class="panel panel-default text-center">
                        <div class="panel-heading">
                            <span class="fa-stack fa-1x">
                                <i class="fa fa-circle fa-stack-2x text-primary"></i>
                                <i class="fa fa-money fa-stack-1x fa-inverse"></i>
                            </span>
                        </div>
                        <div class="panel-body">
                            <h4>Buy and Sell ad</h4>
                            <p>Add an item for sale</p>
                            <a href="#" id="buyandsellbtn" class="btn btn-primary  btn-lg"><span class="fa fa-plus"></span></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row" id="houseforsale" >

                <div class="col-sm-10">
                    <h1 style="margin-top:  0px;">House for sale

                        <p class="showProgress" style="display: inline; font-size: 15px; color: red">
                            <strong>submitting</strong>
                            <i class="fa fa-spinner fa-spin fa-lx fa-fw"></i>
                        </p>

                    </h1>


                </div>
                <div class="col-sm-2">
                    <p class="text-right">
                        <a href="#" class="closeopenform">
                            <span class="fa-stack" style="color: red">
                                <i class="fa fa-circle-thin fa-stack-2x"></i>
                                <i class="fa  fa-times fa-stack-1x"></i>

                            </span>
                        </a>
                    </p>
                </div>
                <div class="col-sm-12" >
                    <!--House for sale form-->

                    <div class="well well-sm">

                        <form id="houseforsaleF" action="/"> 
                            <!--#houseforsaleF div div textarea-->
                            <!--#houseforsaleF div div label i.-->
                            <!--#houseforsaleF div div textarea-->

                            <div class="row form-group">
                                <div class="col-sm-6">
                                    <label for="houseforsale">Short Description: 

                                        <i class="fa fa-asterisk shortDescription" style="color: #FF0000;" aria-hidden="true"></i>
                                    </label>

                                    <textarea value="dhdh"  id="houseforsale" class="form-control descript" rows="6" name="shortDescription"></textarea>
                                    <span name="shortDescription_validation" class="error"></span>
                                </div>
                                <div class="col-sm-6 row">
                                    <div class="col-sm-6">
                                        <label for="houselocation">Location:
                                            <i class="fa fa-asterisk location" style="color: #FF0000;" aria-hidden="true"></i>
                                        </label>
                                        <input id="houselocation" class="form-control locat" type="text" name="location">
                                        <span name="location_validation" class="error"></span>
                                    </div>
                                    <div class="col-sm-6">
                                        <label for="housephone">Phone:
                                            <i class="fa fa-asterisk phone" style="color: #FF0000;" aria-hidden="true"></i>
                                        </label>
                                        <input id="housephone" class="form-control" type="text" name="phone">
                                        <span name="phone_validation" class="error"></span>
                                    </div>
                                    <div class="col-sm-12">
                                        <label for="expirydate">Expiry Date:
                                            <i class="fa fa-asterisk expiryDate" style="color: #FF0000; visibility: hidden" aria-hidden="true"></i>
                                        </label>
                                        <input id="expirydate" class="form-control expirydate" type="text" name="expiryDate">
                                    </div>

                                    <div class="col-sm-12">
                                        <label for="housesaleemail">Email:
                                            <i class="fa fa-asterisk email" style="color: #FF0000; visibility: hidden" aria-hidden="true"></i>
                                        </label>
                                        <input id="housesaleemail" class="form-control" type="text" name="email">
                                        <span name="email_validation" class="error"></span>
                                    </div>
                                </div>




                                <div class="checkbox col-sm-12">

                                    <div class="checkbox">
                                        <label><input id="housesalenego" type="checkbox" value="" name="isNegotiable"><strong>Negotiable</strong>
                                        </label>
                                    </div>
                                </div>

                                <div class="col-sm-1">
                                    <button  type="submit" class="form-control btn-primary">Submit</button>
                                </div>
                            </div>

                        </form>
                    </div>

                </div>

            </div>

            <div class="row" id="jobsad" >
                <div class="col-sm-10">
                    <h1 style="margin-top:  0px;">Jobs Ad
                    
                        <p class="showProgress" style="display: inline; font-size: 15px; color: red">
                            <strong>submitting</strong>
                            <i class="fa fa-spinner fa-spin fa-lx fa-fw"></i>
                        </p>
                        
                    </h1>
                </div>
                <div class="col-sm-2">
                    <p class="text-right">
                        <a href="#" class="closeopenform">
                            <span class="fa-stack" style="color: red">
                                <i class="fa fa-circle-thin fa-stack-2x"></i>
                                <i class="fa  fa-times fa-stack-1x"></i>

                            </span>
                        </a>
                    </p>
                </div>
                <div class="col-sm-12" >
                    <div class="well well-sm">
                        <form id="jobsadF" action="/">
                            <div class="row form-group">

                                <!--#jobsadF div div label i.-->

                                <div class="col-sm-6">
                                    <label for="jobsdesc">Short Description:
                                        <i class="fa fa-asterisk shortDescription" style="color: #FF0000;" aria-hidden="true"></i>
                                    </label>
                                    <textarea id="jobsdesc" class="form-control" rows="6" name="shortDescription"></textarea>
                                    <span name="shortDescription_validation" class="error"></span>

                                </div>
                                <div class="col-sm-6 row">
                                    <div class="col-sm-6">
                                        <label for="jobslocation">Location:
                                            <i class="fa fa-asterisk location" style="color: #FF0000;" aria-hidden="true"></i>
                                        </label>
                                        <input id="jobslocation" class="form-control" name="location" type="text">
                                        <span name="location_validation" class="error"></span>

                                    </div>
                                    <div class="col-sm-6">
                                        <label for="jobphone">Phone:
                                            <i class="fa fa-asterisk phone" style="color: #FF0000;" aria-hidden="true"></i>
                                        </label>
                                        <input id="jobphone" class="form-control" name="phone" type="text">
                                        <span name="phone_validation" class="error"></span>

                                    </div>

                                    <div class="col-sm-12">
                                        <label for="jobexpirydate">Expiry Date:
                                            <i class="fa fa-asterisk expiryDate" style="color: #FF0000; visibility: hidden" aria-hidden="true"></i>
                                        </label>
                                        <input id="jobexpirydate" class="form-control expirydate" name="expiryDate" type="text">


                                    </div>

                                    <div class="col-sm-12">
                                        <label for="jobseemail">Email:
                                            <i class="fa fa-asterisk email" style="color: #FF0000; visibility: hidden" aria-hidden="true"></i>
                                        </label>
                                        <input id="jobseemail" class="form-control" name="email" type="text">

                                        <span name="email_validation" class="error"></span>
                                    </div>

                                </div>

                                <div class="checkbox col-sm-12">

                                    <div class="checkbox">
                                        <label><input  type="checkbox" value=""  name="isNegotiable"><strong>Negotiable</strong></label>
                                    </div>
                                </div>
                                <div class="col-sm-1">
                                    <button type="submit" class="form-control btn-primary">Submit</button>
                                </div>

                            </div>
                        </form>
                    </div>
                </div>

            </div>

            <div class="row" id="houseforrent" >
                <div class="col-sm-10">
                    <h1 style="margin-top:  0px;">House For Rent
                    
                        <p class="showProgress" style="display: inline; font-size: 15px; color: red">
                            <strong>submitting</strong>
                            <i class="fa fa-spinner fa-spin fa-lx fa-fw"></i>
                        </p>
                        
                    </h1>
                </div>
                <div class="col-sm-2">
                    <p class="text-right">
                        <a href="#" class="closeopenform">
                            <span class="fa-stack" style="color: red">
                                <i class="fa fa-circle-thin fa-stack-2x"></i>
                                <i class="fa  fa-times fa-stack-1x"></i>

                            </span>
                        </a>
                    </p>
                </div>
                <div class="col-sm-12" >
                    <div class="well well-sm">
                        <form id="houseforrentF" action="/">
                            <div class="row form-group">



                                <div class="col-sm-6">
                                    <label for="houserentdesc">Short Description:
                                        <i class="fa fa-asterisk shortDescription" style="color: #FF0000;" aria-hidden="true"></i>
                                    </label>
                                    <textarea id="houserentdesc" class="form-control" name="shortDescription" rows="6"></textarea>
                                    <span name="shortDescription_validation" class="error"></span>

                                </div>

                                <div class="col-sm-6 row">
                                    <div class="col-sm-6">
                                        <label for="houserentloc">Location:
                                            <i class="fa fa-asterisk location" style="color: #FF0000;" aria-hidden="true"></i>
                                        </label>
                                        <input id="houserentloc" class="form-control" name="location" type="text">
                                        <span name="location_validation" class="error"></span>

                                    </div>
                                    <div class="col-sm-6">
                                        <label for="houserentphone">Phone:
                                            <i class="fa fa-asterisk phone" style="color: #FF0000;" aria-hidden="true"></i>
                                        </label>
                                        <input id="houserentphone" class="form-control" name="phone" type="text">
                                        <span name="phone_validation" class="error"></span>

                                    </div>

                                    <div class="col-sm-12">
                                        <label for="houserentexpiry">Expiry Date:
                                            <i class="fa fa-asterisk expiryDate" style="color: #FF0000; visibility: hidden" aria-hidden="true"></i>
                                        </label>
                                        <input id="houserentexpiry" class="form-control expirydate" name="expiryDate" type="text">
                                    </div>

                                    <div class="col-sm-12">
                                        <label for="houserentemail">Email:
                                            <i class="fa fa-asterisk email" style="color: #FF0000; visibility: hidden" aria-hidden="true"></i>
                                        </label>
                                        <input id="houserentemail" class="form-control" name="email" type="text">
                                        <span name="email_validation" class="error"></span>
                                    </div>




                                </div>
                                <div class="checkbox col-sm-12">
                                    <div class="checkbox">
                                        <label><input  type="checkbox" value=""  name="isNegotiable"><strong>Negotiable</strong></label>
                                    </div>
                                </div>
                                <div class="col-sm-1">
                                    <button type="submit" class="form-control btn-primary">Submit</button>
                                </div>

                            </div>
                        </form>
                    </div>
                </div>

            </div>


            <div class="row" id="buyandsell" >
                <div class="col-sm-10">
                    <h1 style="margin-top:  0px;">Buy And Sell
                    
                        <p class="showProgress" style="display: inline; font-size: 15px; color: red">
                            <strong>submitting</strong>
                            <i class="fa fa-spinner fa-spin fa-lx fa-fw"></i>
                        </p>
                        
                    </h1>
                </div>
                <div class="col-sm-2">
                    <p class="text-right">
                        <a href="#" class="closeopenform">
                            <span class="fa-stack" style="color: red">
                                <i class="fa fa-circle-thin fa-stack-2x"></i>
                                <i class="fa  fa-times fa-stack-1x"></i>

                            </span>
                        </a>
                    </p>
                </div>
                <div class="col-sm-12" >
                    <div class="well well-sm">
                        <form id="buyandsellF" action="/">
                            <div class="row form-group">



                                <div class="col-sm-6">
                                    <label for="buyselldesc">Short Description:
                                        <i class="fa fa-asterisk shortDescription" style="color: #FF0000;" aria-hidden="true"></i>
                                    </label>
                                    <textarea id="buyselldesc" class="form-control" rows="6" name="shortDescription"></textarea>

                                    <span name="shortDescription_validation" class="error"></span>

                                </div>

                                <div class="col-sm-6 row">
                                    <div class="col-sm-6">
                                        <label for="buysellloc">Location:
                                            <i class="fa fa-asterisk location" style="color: #FF0000; " aria-hidden="true"></i>
                                        </label>
                                        <input id="buysellloc" class="form-control" name="location" type="text">
                                        <span name="location_validation" class="error"></span>

                                    </div>
                                    <div class="col-sm-6">
                                        <label for="buysellphone">Phone:
                                            <i class="fa fa-asterisk phone" style="color: #FF0000;" aria-hidden="true"></i>
                                        </label>
                                        <input id="buysellphone" class="form-control" name="phone" type="text">
                                        <span name="phone_validation" class="error"></span>

                                    </div>

                                    <div class="col-sm-12">
                                        <label for="buysellexpiry">Expiry Date:
                                            <i class="fa fa-asterisk expiryDate" style="color: #FF0000; visibility: hidden" aria-hidden="true"></i>
                                        </label>
                                        <input id="buysellexpiry" class="form-control expirydate" name="expiryDate" type="text">
                                    </div>

                                    <div class="col-sm-12">
                                        <label for="buysellmail">Email:
                                            <i class="fa fa-asterisk email" style="color: #FF0000; visibility: hidden" aria-hidden="true"></i>
                                        </label>
                                        <input id="buysellmail" class="form-control" name="email" type="text">
                                        <span name="email_validation" class="error"></span>
                                    </div>

                                </div>


                                <div class="checkbox col-sm-12">

                                    <div class="checkbox">
                                        <label><input  type="checkbox" value=""  name="isNegotiable"><strong>Negotiable</strong></label>
                                    </div>
                                </div>
                                <div class="col-sm-1">
                                    <button type="submit" class="form-control btn-primary">Submit</button>
                                </div>

                            </div>
                        </form>
                    </div>
                </div>

            </div>

            <!-- Service Tabs -->
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-header">Tips on how best to post add</h2>
                </div>
                <div class="col-lg-12">

                    <ul id="myTab" class="nav nav-tabs nav-justified">
                        <li class="active"><a href="#service-one" data-toggle="tab"><i class="fa fa-tree"></i> House for Sale</a>
                        </li>
                        <li class=""><a href="#service-two" data-toggle="tab"><i class="fa fa-car"></i> Jobs</a>
                        </li>
                        <li class=""><a href="#service-three" data-toggle="tab"><i class="fa fa-support"></i> Housing for rent</a>
                        </li>
                        <li class=""><a href="#service-four" data-toggle="tab"><i class="fa fa-database"></i> Buy and sell</a>
                        </li>
                    </ul>

                    <div id="myTabContent" class="tab-content">
                        <div class="tab-pane fade active in" id="service-one">
                            <h4>Service One</h4>
                            <p>Tip tip tip</p>
                            <p>Tip tip tip</p>
                        </div>
                        <div class="tab-pane fade" id="service-two">
                            <h4>Service Two</h4>
                            <p>Tip tip tip</p>
                            <p>Tip tip tip</p>
                        </div>
                        <div class="tab-pane fade" id="service-three">
                            <h4>Service Three</h4>
                            <p>Tip tip tip</p>
                            <p>Tip tip tip</p>
                        </div>
                        <div class="tab-pane fade" id="service-four">
                            <h4>Service Four</h4>
                            <p>Tip tip tip</p>
                            <p>Tip tip tip</p>
                        </div>
                    </div>

                </div>
            </div>


            <hr>

            <!-- Footer -->
            <%@ include file="include/footer.jsp" %>
            <script src="<c:url value="/resources/js/contentuploader.js"/>"></script>


            <script>
            //script to show and hide image on ajax requests.
            $(".showProgress").hide();

            $(document).ajaxStart(function () {
               
                $(".showProgress").show();
            });

            $(document).ajaxComplete(function () {
                $(".showProgress").hide();
            });

            </script>

    </body>

</html>

