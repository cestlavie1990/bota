<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/registration.js" />"></script>
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="login.signIn"/></title>
    </head>
    <body class="page">        
        <div class="auth text-center">
            <form method="POST" action="<c:url value="/j_spring_security_check" />">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <p>
                    <label for="user_login"><spring:message code="label.login"/></label>
                    <input type="text" name="user_login" class="form-control" placeholder="<spring:message code="login.inputLogin"/>">
                </p>                        
                <p>
                    <label for="user_password"><spring:message code="label.password"/></label>
                    <input type="password" name="user_password" class="form-control" placeholder="<spring:message code="login.inputPassword"/>">
                </p>
                <c:if test="${not empty error}">
                    <p style="color: red; font-weight: bold;"><spring:message code="login.error"/></p>
                </c:if>
                <p>
                    <input name="remember-me" type="checkbox"> <spring:message code="login.remember"/></label>
                </p> 
                <button type="submit" class="btn btn-default"><spring:message code="login.signIn"/></button>
                <button type="button" class="btn btn-default" onclick="location.href = '/BOtA/registration'">
                    <spring:message code="label.registration"/>
                </button>
            </form>
            <a href="#"><spring:message code="login.forgotPass"/></a>            
        </div>
    </body>
</html>
