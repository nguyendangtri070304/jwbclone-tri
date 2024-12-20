<!DOCTYPE html>
<html lang="en">
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signin</title>
    <!-- Logo -->
    <link href="assets/images/logo.png" rel="icon"/>
    <link href="assets/images/logo.png" rel="apple-touch-icon"/>
    <link rel="stylesheet" type="text/css" href="assets/css/as-alert-message.min.css">
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style-starter.css">
    <link rel="stylesheet" type="text/css" href="assets/css/sign-in.css">
</head>

<body>
<header id="site-header" class="w3l-header fixed-top">
    <!--/nav-->
    <nav class="navbar navbar-expand-lg navbar-light fill px-lg-0 py-0 px-3">
        <div class="container">
            <h1><a class="navbar-brand" href="/home"><span class="fa fa-play icon-log"
                                                           aria-hidden="true"></span>
                MyShowz </a></h1>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
            </div>
            <div class="Login_SignUp" id="login_s">
                <!-- style="font-size: 2rem ; display: inline-block; position: relative;" -->
                <!-- <li class="nav-item"> -->
                <a class="nav-link" href="/sign"><i class="fa fa-user-circle-o"></i></a>
                <!-- </li> -->
            </div>
            <!-- toggle switch for light and dark theme -->
            <div class="mobile-position">
                <nav class="navigation">
                    <div class="theme-switch-wrapper">
                        <label class="theme-switch" for="checkbox">
                            <input type="checkbox" id="checkbox">
                            <div class="mode-container">
                                <i class="gg-sun"></i>
                                <i class="gg-moon"></i>
                            </div>
                        </label>
                    </div>
                </nav>
            </div>
        </div>
    </nav>
</header>

<div class="container_signup_signin" id="container_signup_signin">
    <div class="form-container sign-up-container">
        <form:form method="post" name="sign-up-form" action="/register" onsubmit="return signUpValidateForm()" modelAttribute="SignUp">
            <h1 style="color: black;">Create Account</h1>
            <div class="social-container">
                <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
            </div>
            <span>or use your email for registration</span>
            <input type="hidden" name="formType" value="signUp"/>
            <form:input path="customer_name" name="sign-up-name" type="text" placeholder="Name"/>
            <form:input path="customer_email" name="sign-up-email" type="email" placeholder="Email"/>
            <form:input path="customer_password" name="sign-up-passwd" type="password" placeholder="Password"/>
            <form:input path="customer_Confirm_password" name="sign-up-cfpasswd" type="password" placeholder="Confirm Password"/>
            <button>Sign Up</button>
        </form:form>
    </div>
    <div class="form-container sign-in-container">
        <form:form method="post" name="sign-in-form" action="/login" style="color: var(--theme-title);"
                   onsubmit="return signInValidateForm()" modelAttribute="SignIn">
            <h1>Sign in</h1>
            <div class="social-container">
                <a href="#" class="social" style="color: var(--theme-title);"><i
                        class="fab fa-facebook-f"></i></a>
                <a href="#" class="social" style="color: var(--theme-title);"><i
                        class="fab fa-google-plus-g"></i></a>
                <a href="#" class="social" style="color: var(--theme-title);"><i
                        class="fab fa-linkedin-in"></i></a>
            </div>
            <span>or use your account</span>
            <input type="hidden" name="formType" value="signIn"/>
            <form:input path="customer_email" name="sign-in-email" type="email" placeholder="Email"/>
            <form:input path="customer_password" name="sign-in-passwd" type="password"
                        placeholder="Password"/>
            <a href="#">Forgot your password?</a>
            <button>Sign In</button>
        </form:form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Welcome Back!</h1>
                <p>To keep connected with us please login with your login details</p>
                <button class="ghost" id="signIn">Sign In</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Hello, Friend!</h1>
                <p>Register and book your tickets now!!!</p>
                <button class="ghost" id="signUp">Sign Up</button>
            </div>
        </div>
    </div>
</div>
<!-- Hiển thị thông báo lỗi nếu có -->
<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>
<script type="text/javascript" src="assets/js/as-alert-message.min.js"></script>
<script src="assets/js/jquery-3.3.1.min.js"></script>
<!--/theme-change-->
<script src="assets/js/theme-change.js"></script>
<!-- disable body scroll which navbar is in active -->
<script>
    $(function () {
        $('.navbar-toggler').click(function () {
            $('body').toggleClass('noscroll');
        })
    });
</script>
<!-- disable body scroll which navbar is in active -->
<!--/MENU-JS-->
<script>
    $(window).on("scroll", function () {
        var scroll = $(window).scrollTop();

        if (scroll >= 80) {
            $("#site-header").addClass("nav-fixed");
        } else {
            $("#site-header").removeClass("nav-fixed");
        }
    });

    //Main navigation Active Class Add Remove
    $(".navbar-toggler").on("click", function () {
        $("header").toggleClass("active");
    });
    $(document).on("ready", function () {
        if ($(window).width() > 991) {
            $("header").removeClass("active");
        }
        $(window).on("resize", function () {
            if ($(window).width() > 991) {
                $("header").removeClass("active");
            }
        });
    });
</script>
<script src="assets/js/bootstrap.min.js"></script>

<script type="text/javascript" src="assets/js/sign-in.js"></script>

</body>

</html>