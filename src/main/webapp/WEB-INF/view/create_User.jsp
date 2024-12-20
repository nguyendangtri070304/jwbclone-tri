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

<div class="container_signup_signin" id="container_signup_signin" style="height: 800px; width: 1080px">
    <div class="form-container2 sign-up-container2">
        <form:form method="post" name="sign-up-form" action="${action}" onsubmit="return signUpValidateForm()"
                   modelAttribute="Register">
            <h1 style="color: black; padding-top: 25px;">${title}</h1>
            <span style="font-size: 32px; color: green;">${description}</span>
            <input type="hidden" name="formType" value="Create_User"/>
            <div class="form-group d-flex " style="display: inline-flex; width: 100%;align-items: center;">
                <label style="margin-left: 0px;width: 180px; justify-self: start; text-align: left;">Name:</label>
                <form:input path="customer_name" name="sign-up-name" type="text"
                            style=""
                            placeholder="${customer_placeholder.customer_name}"
                            value="${customer_value.customer_name}"/>
            </div>
            <div class="form-group d-flex " style="display: inline-flex; width: 100%;align-items: center;">
                <label style="margin-left: 0px;width: 180px; justify-self: start; text-align: left;">Email:</label>
                <form:input path="customer_email" name="sign-up-email" type="email"
                            placeholder="${customer_placeholder.customer_email}"
                            value="${customer_value.customer_email}"/>
            </div>
            <div class="form-group d-flex " style="display: inline-flex; width: 100%;align-items: center;">
                <label style="margin-left: 0px;width: 180px; justify-self: start; text-align: left;">PassWord:</label>
                <form:input path="customer_password" name="sign-up-passwd" type="text"
                            placeholder="${customer_placeholder.customer_password}"
                            value="${customer_value.customer_password}"/>
            </div>
            <div class="form-group d-flex " style="display: inline-flex; width: 100%;align-items: center;">

                <label style="margin-left: 0px;width: 180px; justify-self: start; text-align: left;">Number
                    Phone:</label>
                <form:input path="customer_phone" name="sign-up-phone" type="text"
                            placeholder="${customer_placeholder.customer_phone}"
                            value="${customer_value.customer_phone}"/>
            </div>
            <div class="form-group d-flex " style="display: inline-flex; width: 100%;align-items: center;">
                <label style="margin-left: 0px;width: 180px; justify-self: start; text-align: left;">Date Of
                    Birth:</label>
                <form:input path="customer_date_of_birth" name="sign-up-date-of-birth" type="date"
                            placeholder="${customer_placeholder.customer_date_of_birth}"
                            value="${customer_value.customer_date_of_birth}"/>
            </div>
            <div class="form-group d-flex " style="display: inline-flex; width: 100%;align-items: center;">
                <label style="margin-left: 0px;width: 180px; justify-self: start; text-align: left;">Gender:</label>
                <form:input path="customer_gender" name="sign-up-gender" type="text"
                            placeholder="${customer_placeholder.customer_gender}"
                            value="${customer_value.customer_gender}"/>
            </div>
            <div class="form-group d-flex " style="display: inline-flex; width: 100%;align-items: center;">
                <label style="margin-left: 0px;width: 180px; justify-self: start; text-align: left;">Active:</label>
                <form:input path="customer_is_active" name="sign-up-isActive" type="text"
                            placeholder="${customer_placeholder.customer_is_active}"
                            value="${customer_value.customer_is_active}"/>
            </div>
            <button>${title}</button>
        </form:form>
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

<!-- disable body scroll which navbar is in active -->
<!--/MENU-JS-->

<script src="assets/js/bootstrap.min.js"></script>

<script type="text/javascript" src="assets/js/sign-in.js"></script>

</body>

</html>