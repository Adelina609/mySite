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
    <script>
        $(".open-all").click(
            function () {
                alert("func")
                $(this).next(".more").slideToggle("fast");
                //$(this).slideToggle("fast");
                $(this).style.display = "none"
            });

        $(".close").click(
            function () {
                $(this).parent().slideToggle("fast");
                //$(".open-all-block").slideToggle("fast");
                $(this).parent().prev(".open-all").style.display = "inline-block"
                //$(".open-all").css("display", "block");
            });
    </script>
    <style>
        .opisanie {
            width: 400px;
            margin: auto;
        }
        .more {
            display:none
        }
        .open-all, .close {
            display: inline-block;
            border: 1px grey solid;
            border-radius: 20px;
            padding: 0.5em 1em;
        }
    </style>
</head>
<!-- Page Header -->
<header class="masthead" style="background-image: url('img/img_brain.jpg')">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <div class="site-heading">
                    <h1>Clean Blog</h1>
                    <span class="subheading">A Blog Theme by Start Bootstrap</span>
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
                <span class="open-all">показать полностью</span>
                <div class="more" style="display: none">дополнительный текст<br>
                    <span class="close">скрыть</span>
                </div>
                <p class="post-meta">Posted by
                    ${article.getUsername()}</p>
            </div>
            </c:forEach>

                <div class="opisanie">
                    <h2>Краткое описание</h2>
                    <p>При установке ксенонового оборудования на современные автомобили, оснащенные бортовым компьютером, часто можно столкнуться с тем, что компьютер выдает ошибку в работе системы освещения (загорается соответствующая лампочка на панели приборов). На целом ряде автомобилей это приводит к автоматическому отключению подачи питания на фары. </p>
                    <button class="open-all" id="open-all" style="display: block">показать полностью</button>
                    <div class="more" id="more">дополнительный текст<br>
                        <button class="close" id="close">скрыть</button>
                    </div>
                </div>

            <!-- Pager -->
            <%--<div class="clearfix">--%>
                <%--<a class="btn btn-primary float-right" href="#">Older Posts &rarr;</a>--%>
            <%--</div>--%>
            </div>
        </div>
    </div>
</div>
</main:main>

</html>

