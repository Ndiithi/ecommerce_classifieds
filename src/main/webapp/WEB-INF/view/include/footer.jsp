<%-- 
    Document   : footer
    Created on : Nov 30, 2016, 4:24:03 PM
    Author     : Duncan
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.sql.Date"%>




<div class="row" style="background-color: #e0e0d1; padding-left: 40px;padding-right: 40px;padding-top: 10px">
<!--
    <div class="col-sm-12 text-center" style="border-bottom: 1px solid #898888; padding-top: 5px;">
       
        <h3>Classifieds</h3>
    </div>
    -->

    <div class="col-xm-12 col-sm-4 " style="margin-bottom: 0; margin-top: 0;" >
        
        <ul style="list-style-type: none; display: inline;">
            <li class="footer-list">
                <a class="foot" href="classified-upload">Classifieds Upload |</a>
            </li>
            <li class="footer-list">
                <a class="foot" href="classified-manage">Classifieds Manager |</a>
            </li>
            <li class="footer-list">
                <a class="foot" href="classified-manage">Classifieds Tips</a>
            </li>
         
         
        </ul>
        
        
    </div>

    <div class="col-xm-12 col-sm-4 text-center">
        <p style="">Connect</p>
        <a href="https://www.facebook.com/pages/Inmobia/117874904906974" targt="_blank"><img src="<c:url value="/resources/img/fb.png"/>" alt="facebook"/></a>
        <a href="https://twitter.com/Inmobia" target="_blank"><img src="<c:url value="/resources/img/tw.png"/>" alt="twitter"/></a>
        <a href="http://ke.linkedin.com/pub/inmobia-mobile-technology/44/2a4/990" target="_blank"><img src="<c:url value="/resources/img/in.png"/>" alt="linkedin"/></a>
    </div>



    

    <div class="col-xm-12 col-sm-4 ">
        <p>Copyright &copy; <a>www.inmobia.com</a> <%
            Date date = new Date(System.currentTimeMillis());
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            out.print(cal.get(Calendar.YEAR));
            %></p>
    </div>



</div>



<!-- /.container -->



<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/classifiedforms.js"/>"></script>
<!-- Script to Activate the Carousel -->
<script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    });
    </script>

