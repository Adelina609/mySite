<%--
  Created by IntelliJ IDEA.
  User: Аделя
  Date: 27.11.2018
  Time: 1:13
  To change this template use File | Settings | File Templates.
--%>
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
                    <h1>Scitopus</h1>
                    <span class="subheading">Блог о популярной науке</span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Main Content -->
<div class="container">
    <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
            <c:forEach items="${articles}" var="article">
            <div class="post-preview">
                <h2 class="post-title">
                    ${article.getTitle()}
                </h2>
                <p class="post-subtitle">
                    ${article.getText()}
                </p>
                <p class="post-meta">Posted by
                    ${article.getUsername()}</p>
            </div>
            </c:forEach>
            </div>
        </div>
    </div>
</div>
</main:main>

</html>

