<%-- 
    Document   : Home
    Created on : Nov 30, 2016, 3:25:00 PM
    Author     : Duncan Ndiithi
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <%@ include file="include/header.jsp" %>
        <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet" type="text/css">
        <link href='//fonts.googleapis.com/css?family=Architects Daughter' rel='stylesheet'>
        <title>Classifieds Home</title>

      
    </style>
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
            <div class="item">
                <div class="fill" style="background-image:url('<c:url value="/resources/img/classified-carousel/classified-house.jpeg"/>');"></div>
                <div class="carousel-caption">
                    <h2 class="banner-tag">Make your house available for a large clientele.</h2>
                </div>
            </div>
            <div class="item active">
                <div class="fill" style="background-image:url('<c:url value="/resources/img/classified-carousel/classified-job.jpg"/>');"></div>
                <div class="carousel-caption">
                    <h2 class="banner-tag">Need a new position filled, put it on Inmobia classified.</h2>
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('<c:url value="/resources/img/classified-carousel/classified-rent.jpg"/>');"></div>
                <div class="carousel-caption">
                    <h2 class="banner-tag"> Got a vacant rental house? This is the place to be.</h2>
                </div>
            </div>

            <div class="item">
                <div class="fill" style="background-image:url('<c:url value="/resources/img/classified-carousel/classified-buy-sell.jpeg"/>');"></div>
                <div class="carousel-caption">
                    <h2 class="banner-tag">Buy and Sell anything on Inmobia classified.</h2>
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
                <h1 style="border-bottom: 0px;" class="page-header text-center">
                    Welcome to Inmobia Classified
                </h1>
            </div>
        </div>
    </div>
    <div style="width: 100%; background-color: #e0e0d1; padding-top: 20px;">
        <div class="container">
            <div class="row" style="padding-bottom: 20px;">
                <div class="col-sm-12 text-center">
                    <h3 style="padding-bottom: 75px; font-size: 18px; ">
                        Post your add and we guarantee it will reach 
                        a wide range of people that  subscribe to  receive that precise item within our system.
                    </h3>
                </div>


                <div class="col-sm-3 frame">
                    <div class="text-center">
                        <img style="margin: 0 auto;" src="<c:url value="/resources/img/housebed.jpg"/>" class="img-responsive img-circle" alt="">
                        <h4 class="frame-header">House For Sale</h4>
                        <p>With inmobia classified, you can post that house that you need sold out as soon as possible, and we will do the rest. 
                            You are guaranteed that your ad will reach a large base of clientele, who anticipate exactly that and will start ringing you soon. </p>
                        <a href="classified-upload" class="btn btn-default">Learn More</a>
                    </div>
                </div>



                <div class="col-sm-3 frame">
                    <div class="text-center">
                        <img style="margin: 0 auto;" src="<c:url value="/resources/img/job-panel.jpg"/>" class="img-responsive img-circle" alt="">
                        <h4 class="frame-header">Job advert</h4>
                        <p>New office position that needs filling urgently? Easy, post that new position in your company here, this is the fastest way to reach 
                            your target employee. 
                            You can provide an email or phone number with which your potential employee will reach out to you. </p>
                        <a href="classified-upload" class="btn btn-default">Learn More</a>
                    </div>
                </div>



                <div class="col-sm-3 frame">
                    <div class="text-center">
                        <img style="margin: 0 auto;" src="<c:url value="/resources/img/rent-panel.jpg"/>" class="img-responsive img-circle" alt="">
                        <h4 class="frame-header">House for rent</h4>
                        <p>Have a house that needs new tenants? You're in the right place. Post details of the same, and we will do the rest. 
                            We have a precise subscriber base that will get the information as soon as we have it on our system.
                            It's robust as will only reach the people interested with this kind of information. </p>
                        <a href="classified-upload" class="btn btn-default">Learn More</a>
                    </div>
                </div>

                <!--<div class="clearfix visible-lg"></div>-->
                <div class="col-sm-3 frame">
                    <div class="text-center">
                        <img style="margin: 0 auto;" src="<c:url value="/resources/img/buy-sell-panel.jpg"/>" class="img-responsive img-circle" alt="">
                        <h4 class="frame-header">Buy and Sell</h4>
                        <p>You can sell anything on this platform, just post it for free and we will ensure it reaches your target market. 
                            You are guaranteed that your ad will reach a large base of clientele who will start ringing you soon. </p>
                        <a href="classified-upload" class="btn btn-default">Learn More</a>
                    </div>
                </div>



            </div>
        </div>
    </div>
                        <div class="container" style=" margin-bottom: 20px;">
        <!-- /.row -->

        <!-- Portfolio Section -->
        <div class="row" >
            <div class="col-lg-12">
                <h2 class="page-header text-center" style="border-bottom: 0px;">Sample Ads</h2>
            </div>
            <div class="col-md-4 col-sm-6 sampleAd">
                <div class="sampleAdDiv" >
                    <img style="height: 80px; background-color: #ccccff;" class="img-responsive pull-left img-circle" src="<c:url value="/resources/img/girl-office.png"/>" alt="">
                    <p class='sampleAdText'>
                        Description: 2 Ha Land on sale on a prime location in Mar suburb in a beautiful terrain.<br/>
                        Price: 2M Rand.<br/>
                        Location: Gale Town.<br/>
                        Negotiable: Yes.<br/>
                        Phone: +xx-xxx-xxx-xxx.<br/>
                        Email: johndoe@kmail.com

                    </p>

                </div>
            </div>
            <div class="col-md-4 col-sm-6 sampleAd">

                <div class="sampleAdDiv" >
                    <img style="height: 80px; background-color: #ccccff" class="img-responsive pull-left img-circle" src="<c:url value="/resources/img/office.png"/>" alt="">
                    <p class='sampleAdText'>
                        Description: Spacious three bedroomed house along hills highway in a gated community.<br/>
                        Rent: 700 USD.<br/>
                        Location: Mave City.<br/>
                        Negotiable: Yes.<br/>
                        Phone: +xx-xxx-xxx-xxx.<br/>
                        Email: johndoe@kmail.com

                    </p>

                </div>


            </div>
            <div class="col-md-4 col-sm-6 sampleAd">

                <div class="sampleAdDiv" >
                    <img style="height: 80px; background-color: #ccccff" class="img-responsive pull-left img-circle" src="<c:url value="/resources/img/man-spects.png"/>" alt="">
                    <p class='sampleAdText'>
                        Description: Located within bankers town, we have a two bedroomed house convinient for your family.<br/>
                        Price: 100, 000 USD.<br/>
                        Location: Towers City.<br/>
                        Negotiable: Yes.<br/>
                        Phone: +xx-xxx-xxx-xxx.<br/>
                        Email: chrismat@kmail.com

                    </p>

                </div>

            </div>
            <div class="col-md-4 col-sm-6 sampleAd">

                <div class="sampleAdDiv" >
                    <img style="height: 80px; background-color: #ccccff" class="img-responsive pull-left img-circle" src="<c:url value="/resources/img/girl.svg"/>" alt="">
                    <p class='sampleAdText'>
                        Description: Chauffer needed immediately for a high end client. Please get in touch sooner.<br/>
                        Salary: 1000 USD.<br/>
                        Location: Nairobi City.<br/>
                        Negotiable: Yes.<br/>
                        Phone: +xx-xxx-xxx-xxx.<br/>
                        Email: johndoe@kmail.com

                    </p>

                </div>

            </div>
            <div class="col-md-4 col-sm-6 sampleAd">

                <div class="sampleAdDiv" >
                    <img style="height: 80px; background-color: #ccccff" class="img-responsive pull-left img-circle" src="<c:url value="/resources/img/man-serious.png"/>" alt="">
                    <p class='sampleAdText'>
                        Description: 2 months old Renault Megane car on sale, in very good condition.<br/>
                        Price: £ 17, 200.<br/>
                        Location: Accra City.<br/>
                        Negotiable: Yes.<br/>
                        Phone: +xx-xxx-xxx-xxx.<br/>
                        Email: johndoe@kmail.com

                    </p>

                </div>



            </div>
            <div class="col-md-4 col-sm-6 sampleAd">

                <div class="sampleAdDiv" >
                    <img style="height: 80px; background-color: #ccccff" class="img-responsive pull-left img-circle" src="<c:url value="/resources/img/uptown.png"/>" alt="">
                    <p class='sampleAdText'>
                        Description: Brand new 72" Plasma TV on sale at a convinient price. Contact me asap.<br/>
                        Price: 7000 Rand.<br/>
                        Location: Johannesburg Town.<br/>
                        Negotiable: Yes.<br/>
                        Phone: +xx-xxx-xxx-xxx.<br/>
                        Email: johndoe@kmail.com

                    </p>

                </div>

            </div>
        </div>
    </div>
    <!-- Footer -->
    <%@ include file="include/footer.jsp" %>

</body>

</html>
