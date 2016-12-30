<%-- 
    Document   : Home
    Created on : Nov 30, 2016, 3:25:00 PM
    Author     : Duncan
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <%@ include file="include/header.jsp" %>
        <title>Classifieds Home</title>
    </head>

    <body>

        <!-- Navigation -->

        <%@include file="include/navigation-bar.jsp"  %>


        <!-- Header Carousel -->
        <header id="myCarousel" class="carousel slide">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
                <li data-target="#myCarousel" data-slide-to="3"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner">
                <div class="item active">
                    <div class="fill" style="background-image:url('<c:url value="/resources/img/classified-carousel/classified-house.jpeg"/>');"></div>
                    <div class="carousel-caption">
                        <h2>Make your house available for a large clientele</h2>
                    </div>
                </div>
                <div class="item">
                    <div class="fill" style="background-image:url('<c:url value="/resources/img/classified-carousel/classified-job.jpg"/>');"></div>
                    <div class="carousel-caption">
                        <h2>Need a new position filled, put it on Inmobia classified</h2>
                    </div>
                </div>
                <div class="item">
                    <div class="fill" style="background-image:url('<c:url value="/resources/img/classified-carousel/classified-rent.jpg"/>');"></div>
                    <div class="carousel-caption">
                        <h2>Got a vacant rental house? This is the place to be</h2>
                    </div>
                </div>

                <div class="item">
                    <div class="fill" style="background-image:url('<c:url value="/resources/img/classified-carousel/classified-buy-sell.jpeg"/>');"></div>
                    <div class="carousel-caption">
                        <h2>Buy and Sell anything on Inmobia classified</h2>
                    </div>
                </div>
            </div>

            <!-- Controls -->
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                <span class="icon-prev"></span>
            </a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="icon-next"></span>
            </a>
        </header>

        <!-- Page Content -->
        <div class="container">
            
            <!-- Marketing Icons Section -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">
                        Welcome to Inmobia Classified
                    </h1>
                </div>
                <div class="col-md-3">
                    <div class="panel panel-default">
                        <div style="background-color: #39ac39;" class="panel-heading">  
                            <!--#269abc;-->
                            <h4><i class="fa fa-fw fa-building"></i> House For Sale</h4>
                        </div>
                        <div class="panel-body">
                            <p>With inmobia classified, you can post that house that you need sold out as soon as possible, and we will do the rest. 
                                You are guaranteed that your ad will reach a large base of clientele who will start ringing you soon. </p>
                            <a href="classified-upload" class="btn btn-default">Learn More</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="panel panel-default">
                        <div style="background-color: #269abc;"  class="panel-heading">
                            <h4><i class="fa fa-fw fa-briefcase"></i>Job advert</h4>
                        </div>
                        <div  class="panel-body">
                            <p>With inmobia classified, you can post that new position in your company that needs filling out, and we will do the rest. 
                                You are guaranteed that your ad will reach a large base of clientele who will start ringing you soon. </p>
                            <a href="classified-upload" class="btn btn-default">Learn More</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="panel panel-default">
                        <div style="background-color: #39ac39;" class="panel-heading">
                            <h4><i class="fa fa-fw fa-home"></i> House for rent</h4>
                        </div>
                        <div class="panel-body">
                            <p>With inmobia classified, you can post that vacant house that you need filled out, and we will do the rest. 
                                You are guaranteed that your ad will reach a large base of clientele who will start ringing you soon. </p>
                            <a href="classified-upload" class="btn btn-default">Learn More</a>
                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div  class="panel panel-default">
                        <div style="background-color: #269abc;" class="panel-heading">
                            <h4><i class="fa fa-fw fa-money"></i> Buy and Sell</h4>
                        </div>
                        <div class="panel-body">
                            <p>With inmobia classified, You can sell anything, just post it for free and we will do the rest. 
                                You are guaranteed that your ad will reach a large base of clientele who will start ringing you soon. </p>
                            <a href="classified-upload" class="btn btn-default">Learn More</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.row -->

            <!-- Portfolio Section -->
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-header">Sample Ads</h2>
                </div>
                <div class="col-md-4 col-sm-6">
                    <a href="portfolio-item.html">
                        <img class="img-responsive img-portfolio img-hover"  src="<c:url value="/resources/img/ai.png"/>" alt="">
                    </a>
                </div>
                <div class="col-md-4 col-sm-6">
                    <a href="portfolio-item.html">
                        <img class="img-responsive img-portfolio img-hover" src="<c:url value="/resources/img/ai.png"/>" alt="">
                    </a>
                </div>
                <div class="col-md-4 col-sm-6">
                    <a href="portfolio-item.html">
                        <img class="img-responsive img-portfolio img-hover" src="<c:url value="/resources/img/ai.png"/>" alt="">
                    </a>
                </div>
                <div class="col-md-4 col-sm-6">
                    <a href="portfolio-item.html">
                        <img class="img-responsive img-portfolio img-hover" src="<c:url value="/resources/img/ai.png"/>" alt="">
                    </a>
                </div>
                <div class="col-md-4 col-sm-6">
                    <a href="portfolio-item.html">
                        <img class="img-responsive img-portfolio img-hover" src="<c:url value="/resources/img/ai.png"/>" alt="">
                    </a>
                </div>
                <div class="col-md-4 col-sm-6">
                    <a href="portfolio-item.html">
                        <img class="img-responsive img-portfolio img-hover" src="<c:url value="/resources/img/ai.png"/>" alt="">
                    </a>
                </div>
            </div>
        </div>
            <!-- Footer -->
            <%@ include file="include/footer.jsp" %>

    </body>

</html>
