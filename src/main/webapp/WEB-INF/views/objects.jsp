<%-- 
    Document   : objects
    Created on : Dec 3, 2017, 5:31:39 PM
    Author     : Mr.Minakov
--%>

<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="label.title" /></title>
    </head>
    <body>
        <c:forEach items="${objectsList}" var="object">
            <p>${object.name}</p>
        </c:forEach>
    </body>
</html>