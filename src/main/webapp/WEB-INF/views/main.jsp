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
        <title>Главная</title>
    </head>
    <body class="page">
    <nav class="navbar navbar-inverse navbar-fixed-top" id="navbar">
        <div class="container-fluid">
            <div class="navbar-header">
                <div class="dropdown">
                    <span class="text"><c:out value="${username}" /></span>
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" title="Настройки">
                        <i class="glyphicon glyphicon-cog" style="color: white"></i>
                    </a>
                    <ul class="dropdown-menu" id="navbarList">
                        <li>
                            <a href="${pageContext.request.contextPath}/objects">
                                <i class="glyphicon glyphicon-equalizer" aria-hidden="true"></i> Объекты строительства
                            </a>
                        </li>
                        <li><a href="#"><i class="glyphicon glyphicon-pencil" aria-hidden="true"></i> Редактировать профиль</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-plus" aria-hidden="true"></i> Управление пользователями</a></li>
                        <li><a href="<c:url value="/logout"/>"><i class="glyphicon glyphicon-off" aria-hidden="true"></i> Выход</a></li>
                    </ul>
                </div>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <button type="button" class="btn btn-default btn-sm navbar-btn" onclick="location.href = '/BOtA/logout'" style="margin-right: 15px">
                            <i class="glyphicon glyphicon-off" aria-hidden="true"></i> Выход
                        </button>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container-fluid content text-center">
        <div class="main-label">
            <h1><strong><c:out value="${companyName}" /></strong></h1>
        </div>
        <div class="main-about">
            <h3>О компании</h3>
            <button type="button" class="btn btn-default btn-md" id="addInfoCompBtn" 
                    data-toggle="modal" 
                    data-target="#addInfoCompModal" >Добавить информацию</button> 
        </div>
        <div class="main-about">
            <h3>Основные направления деятельности</h3>
            <button type="button" class="btn btn-default btn-md">Добавить информацию</button> 
        </div>
        <div class="main-about">
            <h3>Контактная информация</h3>
            <button type="button" class="btn btn-default btn-md">Добавить информацию</button> 
        </div>
    </div>

    <div class="modal fade" id="addInfoCompModal" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content text-center">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h4>Добавить описание компании</h4>
                </div>
                <div class="modal-body" style="color: #2D2D30">
                    <form>
                        <p>
                            <textarea class="form-control" rows="8" required style="resize: vertical"></textarea>
                        </p>
                        <p>
                            <button type="submit" class="btn btn-default" id="btnSubmitaddInfoComp" name="btnAction" value="">
                                <spring:message code="label.add" />
                            </button>
                            <button type="reset" class="btn btn-default" data-dismiss="modal">
                                <spring:message code="label.cancel" />
                            </button>
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
<script>
    $('#addInfoCompBtn').click(function () {

    });
</script>
</html>
