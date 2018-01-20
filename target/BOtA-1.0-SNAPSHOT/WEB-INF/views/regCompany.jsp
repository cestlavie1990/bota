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
        <title>Регистрация профиля</title>
    </head>
    <body class="page">
        <div class="reg-process text-center">
            <h2 class="text-center">Регистрация компании</h2>
            <p>Пожалуйста, заполните пустые поля</p>
            <form:form commandName="company" action="check-company" method="POST" cssClass="reg-form">
                <p>
                    <form:label path="email">Email:<br>
                        <form:input path="email" /><br>
                        <form:errors path="email" cssClass="errorText" id="errorEmail" />
                        <c:if test="${error == 'ERR_EMAIL_USED'}">
                            <span style="color: red">Такой email уже существует</span>
                        </c:if>
                    </form:label>
                </p>
                <p>
                    <form:label path="name">Полное название организации:<br>
                        <form:input path="name" /><br>
                        <form:errors path="name" cssClass="errorText" id="errorCompanyName" />
                    </form:label>
                </p>
                <p>
                    <form:label path="companyLogin">Уникальный логин организации:<br>
                        <form:input path="companyLogin" /><br>
                        <form:errors path="companyLogin" cssClass="errorText" id="errorCompanyLogin" />
                        <c:if test="${error == 'ERR_COMPANY_LOGIN_USED'}">
                            <span style="color: red">Такой login уже существует</span>
                        </c:if>
                    </form:label>
                </p>
                <p>
                    <button type="submit" class="btn btn-default confirm" id="btnConfirm">Продолжить</button>                                    
                </p>
            </form:form>
        </div>
    </body>
</html>