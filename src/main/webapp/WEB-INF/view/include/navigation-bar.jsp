<%-- 
    Document   : navigation-bar
    Created on : Dec 1, 2016, 4:13:43 PM
    Author     : Duncan
--%>
<%@page import="java.util.Enumeration"%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" style=" padding-top: 2px;"  href="classified-home.html"><img  src="<c:url value="/resources/img/inmobia-logo.png"/>" alt="Inmobia"></a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">

                <li>
                    <a href="classified-home.html" style="color: #ffffff">Home</a>
                </li>
               
                 <li class="dropdown">
                        <a href="classified-upload.html" class="dropdown-toggle" data-toggle="dropdown" style="color: #ffffff">Classifieds <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="classified-upload.html">upload classified</a>
                            </li>
                            <li>
                                <a href="#">manage classified</a>
                            </li>
                           
                            
                        </ul>
                    </li>
                
                
            </ul>




            </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>