<%--
  Created by IntelliJ IDEA.
  User: Аделя
  Date: 30.11.2018
  Time: 2:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="main" tagdir="/WEB-INF/tags/layouts" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation -->
<main:main>
    <head>
        <link rel="stylesheet" href="<c:url value="/css/modal_window.css"/>">
    </head>
    <!-- Page Header -->
    <header class="masthead" style="background-image: url('img/img_brain.jpg')">
        <div class="overlay"></div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-10 mx-auto">
                    <div class="site-heading">
                        <h1>Мои статьи</h1>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Main Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <p id="name">username: ${user}</p>
                <button id="editBtn" onclick="editUsername()">Редактировать имя пользователя</button>
                <form id="formForUsername" style="display: none;">
                    <input type="text" name="editText" id="editText">
                    <input type="submit">
                </form>
                <c:forEach items="${articles}" var="article">
                    <div class="post-preview" id="post">
                        <h2 class="post-title">
                                ${article.getTitle()}
                        </h2>
                        <p class="post-subtitle">
                                ${article.getText()}
                        </p>
                        <span class="open-all">показать полностью</span>
                        <div class="more" style="display: none">дополнительный текст<br>
                            <span class="close">скрыть</span>
                        </div>
                        <p class="post-meta">Posted by
                                ${article.getUsername()}</p>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    </div>
    <button id="deleteUser">Удалить аккаунт</button>
    <form>
        <p>Удалить акаунт?</p>
        <input type="submit" onclick="deleteUser()">
    </form>


</main:main>
<script>
    function editUsername() {
        document.getElementById("name").style.display = 'none';
        document.getElementById("formForUser").style.display = 'inline-block';
    }
    function deleteUser() {
        document.getElementById("deleteUser").style.display = 'none';
        document.getElementById("forDelete").style.display = 'inline-block';
    }
</script>

</html>

