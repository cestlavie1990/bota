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
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Регистрация профиля</title>
    </head>
    <body class="page">
        <div class="reg-process text-center">
            <c:if test="${notif ne null}">
                <div class="notif">
                    <span>${notif}</span> 
                </div>
            </c:if>
            <h2 class="text-center">Регистрация профиля</h2>
            <p>Пожалуйста, заполните пустые поля</p>
            <form method="POST" action="registration" class="reg-attr">
                <p>
                    <label for="email">Email:</label>
                    <input type="email" name="email" class="form-control" id="email" placeholder="Введите адрес почты">                                    
                </p>
                <p>
                    <label for="login">Логин:</label>
                    <input type="text" name="login" class="form-control" id="login" placeholder="Введите логин:">                                    
                </p>
                <p>
                    <label for="companyName">Полное название организации:</label>
                    <input type="text" name="companyName" class="form-control" id="companyName-reg" placeholder='ООО "Иван и co"'>                                    
                </p>
                <p>
                    <label for="password">Пароль:</label>
                    <input type="password" name="password" class="form-control" id="password" placeholder="Введите пароль">
                </p>
                <p>
                    <label for="passwordConfirm">Повтор пароля:</label>
                    <input type="password" name="passwordConfirm" class="form-control" id="passwordConfirm" placeholder="Повторите пароль">                                    
                </p>
                <p>
                    <label for="username">Имя:</label>
                    <input type="text" name="username" class="form-control" id="username" placeholder="Иван Петров">                                    
                </p>
                <p>
                    <label for="position">Должность:</label>
                    <input type="text" name="position" class="form-control" id="position" placeholder="Генеральный директор">                                    
                </p>
                <p>
                    <button type="submit" class="btn btn-default">Зарегистрироваться</button>                                    
                </p>
            </form>
        </div>
    </body>
</html>