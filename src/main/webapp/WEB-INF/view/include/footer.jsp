<%-- 
    Document   : footer
    Created on : Nov 30, 2016, 4:24:03 PM
    Author     : Duncan
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.sql.Date"%>
<footer>
    <div class="row">
        <div class="col-lg-12">
            <p>Copyright &copy; www.inmobia.com <%
                Date date=new Date(System.currentTimeMillis());
                Calendar cal=Calendar.getInstance();
                cal.setTime(date);
                out.print(cal.get(Calendar.YEAR));
                %></p>
        </div>
    </div>
</footer>

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