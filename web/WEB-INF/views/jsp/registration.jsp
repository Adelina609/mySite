<%--
  Created by IntelliJ IDEA.
  User: Аделя
  Date: 27.11.2018
  Time: 1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link href="/css/registration.css" type="text/css" rel="stylesheet">
    </head>
        <body>
            <form class="form-container" action="/registration" method="post">
                <div class="form-title">
                    <h2>Регистрация</h2>
                </div>
                <div class="form-title">Email</div>
                <input class="form-field"
                       type="text"
                       name="email" required
                <c:if test="${not empty emailValue}">
                       value=${emailValue}
                </c:if>>
                <c:if test="${not empty email_error}">
                    <small>${email_error}</small>
                </c:if><br />
                <div class="form-title">Имя пользователя</div>
                <input class="form-field"
                       type="text"
                       name="username" required
                <c:if test="${not empty nameValue}">
                       value=${nameValue}
                </c:if>>
                <div class="form-title">Пароль</div>
                <input class="form-field"
                       type="password"
                       name="password1" required
                <c:if test="${not empty pass_error}">
                    <small>${pass_error}</small>
                </c:if><br />
                <div class="form-title">Подтвердите пароль</div>
                <input class="form-field"
                       type="password"
                       name="password2" required >
                <c:if test="${not empty equals_error}">
                    <small>${equals_error}</small>
                </c:if>
                <div class="submit-container">
                    <input class="submit-button" type="submit" value="Зарегистрироваться" />
                </div>
            </form>
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

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/clean-blog.min.js"></script>

    </body>
</html>