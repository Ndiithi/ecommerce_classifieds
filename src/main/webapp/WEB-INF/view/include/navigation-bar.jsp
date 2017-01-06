<%-- 
    Document   : navigation-bar
    Created on : Dec 1, 2016, 4:13:43 PM
    Author     : Duncan
--%>
<%@page import="java.util.Enumeration"%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container" >
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" style=" padding-top: 2px;"  href="classified-home"><img  src="<c:url value="/resources/img/inmobia-logo.png"/>" alt="Inmobia"></a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="position: relative">
            <ul class="nav navbar-nav navbar-right">

                <li>
                    <a href="classified-home" style="color: #ffffff">Home</a>
                </li>

                <li class="dropdown" onclick="closeCountryNav()">
                    <a href="classified-upload" class="dropdown-toggle" data-toggle="dropdown" style="color: #ffffff">Classifieds <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="classified-upload">upload classified</a>
                        </li>
                        <li>
                            <a href="classified-manage">manage classified</a>
                        </li>


                    </ul>
                </li>

                <li class="dropdown" >
                    <a href="#" onclick="openCountryNav()" style="color: #ffffff">
                       <span id="countryMenu" class="flag-icon flag-icon-ke"></span><span id="countryName"> Kenya</span>
                        </a>

                </li>

                <br/>


            </ul>





        </div>
        <!-- /.navbar-collapse -->
    </div>

    <div  style="display: none;  position: absolute; right: 0; left: 0;" id="countryChooser">
        <div class="row" id="contry-list-drop-down">
            <div class="col-lg-12 col-lg-offset-9 col-sm-12 col-sm-offset-7" style="background-color: #ffffff;border-radius: 2px;">

                <p style="margin-top: 10px;">
                    <a onclick="setUserCountry('zm')" class="anchor"><span class="flag-icon flag-icon-gr"></span> <span class="countryList">Zambia</span></a>
                    <a onclick="setUserCountry('ke')" class="anchor"><span class="flag-icon flag-icon-ke"></span> Kenya</a>


                </p>
            </div>
        </div>


    </div>

    <!-- /.container -->
</nav>

