<%-- 
    Document   : weblink
    Created on : Jan 3, 2017, 11:30:57 AM
    Author     : Duncan
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<div style="z-index: -1" class="col-xm-12 col-sm-12 text-center footer navbar-fixed-bottom">
        <p>Copyright &copy; <a>www.inmobia.com</a> <%
            Date date = new Date(System.currentTimeMillis());
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            out.print(cal.get(Calendar.YEAR));
            %></p>
        <!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

    </div>
