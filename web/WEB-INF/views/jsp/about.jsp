<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="main" tagdir="/WEB-INF/tags/layouts" %>

<main:main>
<!-- Page Header -->
<header class="masthead" style="background-image: url('img/write.jpg')">
    <!--style="background-image: url('../../../../../../Desktop/startbootstrap-clean-blog-gh-pages/img/contact-bg.jpg')">-->
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <div class="page-heading">
                    <span class="subheading">Есть что сказать? Добро пожаловать!</span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Main Content -->
<div class="container">
    <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
            <p>Указывайте источники и будьте критичны к своему мышлению.</p>
            <!-- Contact Form - Enter your email address on line 19 of the mail/contact_me.php file to make this form work. -->
            <!-- WARNING: Some web hosts do not allow emails to be sent through forms to common mail hosts like Gmail or Yahoo. It's recommended that you use a private domain email address! -->
            <!-- To use the contact form, your site must be on a live web host with PHP! The form will not work locally! -->
            <form name="sentMessage" id="contactForm"
                  action="/createarticle"
                  method="post" novalidate>
                <div class="control-group">
                    <div class="form-group floating-label-form-group controls">
                        <label>Заголовок</label>
                        <input type="text" class="form-control"
                               name="title" placeholder="Заголовок" id="name" required data-validation-required-message="Please enter your name.">
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <div class="control-group">
                    <div class="form-group floating-label-form-group controls">
                        <label>Текст</label>
                        <textarea rows="5" class="form-control"
                                  name="text" placeholder="Текст" id="message" required data-validation-required-message="Please enter a message."></textarea>
                        <p class="help-block text-danger"></p>
                    </div>
                </div>
                <br>
                <div id="success"></div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary" id="sendMessageButton">Send</button>
                </div>
            </form>
        </div>
    </div>
</div>

</main:main>
