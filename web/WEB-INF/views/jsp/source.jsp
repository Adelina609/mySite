<%--
  Created by IntelliJ IDEA.
  User: Аделя
  Date: 30.11.2018
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="main" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main:main>
    <!-- Page Header -->
    <header class="masthead" style="background-image: url('img/home-bg.jpg')">
        <div class="overlay"></div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-10 mx-auto">
                    <div class="site-heading">
                        <h1>Источники</h1>
                        <%--<span class="subheading">Список проверенных источников</span>--%>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <div class="container">
    <div class="row">
    <div class="col-lg-8 col-md-10 mx-auto">
    <c:forEach items="${sources}" var="source">
        <div class="post-preview">
            <a href="${source.getLink()}">
            <h2 class="post-title">
                    ${source.getName()}
            </h2>
            </a>
            <p class="post-subtitle">
                    ${source.getDescription()}
            </p>
            <span class="open-all">показать полностью</span>
            <div class="more" style="display: none">дополнительный текст<br>
                <span class="close">скрыть</span>
            </div>
        </div>
    </c:forEach>
    </div>
    </div>
    </div>
    </div>
</main:main>

</body>
</html>
