<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Main Layout Tag" pageEncoding="UTF-8" %>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<!Doctype html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Clean Blog - Start Bootstrap Theme</title>

    <!-- Bootstrap core CSS -->
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="/css/clean-blog.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/css/modal_window.css"/>">
    <script>
        function pageLoad() {
            var x = get_cookie ( "username" );
            if (x) {
                var y = document.getElementById("login");
                y.style.display ="none";
            }
        }

        function get_cookie(name) {
            var matches = document.cookie.match(new RegExp(
                "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
            ));
            return matches;
        }
    </script>
</head>
<body>
<div class="main-wrapper">
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
        <div class="container">
            <a class="navbar-brand" href="/home">Scitopus</a>
            <button class="navbar-toggler navbar-toggler-right" type="button"
                    data-toggle="collapse" data-target="#navbarResponsive"
                    aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                Menu
                <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/home">Главная</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/createarticle">Создать</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/sources">Источники</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/myarea">Личный Кабинет</a>
                    </li>
                    <li class="nav-item" id="login">
                        <a class="nav-link" href="#openModal">Войти</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div id="openModal" class="modalDialog">
        <div>
            <a href="#close" title="Закрыть" class="close">X</a>
            <form action="/auth"  method="post">
            <div class="form-container">
                <div class="form-title">
                    <h2>Войти</h2>
                </div>
                <div class="form-title">Email</div>
                <input class="form-field"
                       name="email" type="text"
                        <c:if test="${not empty emailValue}">
                            value=${emailValue}
                        </c:if>/><br />
                <div class="form-title">Пароль</div>
                <input class="form-field"
                       type="password" name="pass"
                <c:if test="${not empty pass_error}">
                    <td class="Errors">${pass_error}</td>
                </c:if><br />
                <div class="submit-container">
                    <input class="submit-button" type="submit" value="OK" />
                </div>
                <div align="center">
                <a style="font-size: medium;" href="/registration">Регистрация</a>
                </div>
            </form>
        </div>
    </div>
</div>
<jsp:doBody/>

<!-- Footer -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <ul class="list-inline text-center">
                    <li class="list-inline-item">
                        <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fas fa-circle fa-stack-2x"></i>
                    <i class="fab fa-twitter fa-stack-1x fa-inverse"></i>
                  </span>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fas fa-circle fa-stack-2x"></i>
                    <i class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
                  </span>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fas fa-circle fa-stack-2x"></i>
                    <i class="fab fa-github fa-stack-1x fa-inverse"></i>
                  </span>
                        </a>
                    </li>
                </ul>
                <p class="copyright text-muted">Copyright &copy; Your Website 2018</p>
            </div>
        </div>
    </div>
</footer>
<script>pageLoad()</script>

<!-- Bootstrap core JavaScript -->
<script src="../../../../../../Desktop/startbootstrap-clean-blog-gh-pages/vendor/jquery/jquery.min.js"></script>
<script src="../../../../../../Desktop/startbootstrap-clean-blog-gh-pages/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Contact Form JavaScript -->
<script src="../../../../../../Desktop/startbootstrap-clean-blog-gh-pages/js/jqBootstrapValidation.js"></script>
<script src="../../../../../../Desktop/startbootstrap-clean-blog-gh-pages/js/contact_me.js"></script>

<!-- Custom scripts for this template -->
<script src="../../../../../../Desktop/startbootstrap-clean-blog-gh-pages/js/clean-blog.min.js"></script>
</body>
</html>