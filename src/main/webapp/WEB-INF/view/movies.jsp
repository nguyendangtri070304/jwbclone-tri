<!doctype html>
<html lang="zxx">
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Movies</title>
    <!-- Logo -->
    <link href="assets/images/logo.png" rel="icon"/>
    <link href="assets/images/logo.png" rel="apple-touch-icon"/>
    <link rel="stylesheet" href="assets/css/style-starter.css">
    <link
            href="//fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;1,600&display=swap"
            rel="stylesheet">

</head>

<body>
<!-- header -->
<header id="site-header" class="w3l-header fixed-top">
    <!--/nav-->
    <nav class="navbar navbar-expand-lg navbar-light fill px-lg-0 py-0 px-3">
        <div class="container">
            <h1><a class="navbar-brand" href="/home"><span class="fa fa-play icon-log"
                                                           aria-hidden="true"></span>
                MyShowz </a></h1>
            <!-- if logo is image enable this
                <a class="navbar-brand" href="#/home">
                    <img src="image-path" alt="Your logo" title="Your logo" style="height:35px;" />
                </a> -->
            <button class="navbar-toggler collapsed" type="button" data-toggle="collapse"
                    data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <!-- <span class="navbar-toggler-icon"></span> -->
                <span class="fa icon-expand fa-bars"></span>
                <span class="fa icon-close fa-times"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/home">Home</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/movies">Movies</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/about">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/Contact_Us">Contact</a>
                    </li>
                </ul>

                <!--/search-right-->
                <!--/search-right-->
                <div class="search-right">
                    <a href="#search" class="btn search-hny mr-lg-3 mt-lg-0 mt-4" title="search">Search
                        <span class="fa fa-search ml-3" aria-hidden="true"></span></a>
                    <!-- search popup -->
                    <div id="search" class="pop-overlay">
                        <div class="popup">
                            <form action="/movies/movie_title" method="GET" class="search-box">
                                <input type="search" placeholder="Search your Keyword" name="title"
                                       required="required" autofocus="">
                                <button type="submit" class="btn"><span class="fa fa-search"
                                                                        aria-hidden="true"></span></button>
                            </form>
                            <div class="browse-items">
                                <h3 class="hny-title two mt-md-5 mt-4">Browse all:</h3>
                                <ul class="search-items">
                                    <li><a href="/movies">Action</a></li>
                                    <li><a href="/movies">Drama</a></li>
                                    <li><a href="/movies">Family</a></li>
                                    <li><a href="/movies">Thriller</a></li>
                                    <li><a href="/movies">Commedy</a></li>
                                    <li><a href="/movies">Romantic</a></li>
                                    <li><a href="/movies">Tv-Series</a></li>
                                    <li><a href="/movies">Horror</a></li>
                                    <li><a href="/movies">Action</a></li>
                                    <li><a href="/movies">Drama</a></li>
                                    <li><a href="/movies">Family</a></li>
                                    <li><a href="/movies">Thriller</a></li>
                                    <li><a href="/movies">Commedy</a></li>
                                    <li><a href="/movies">Romantic</a></li>
                                    <li><a href="/movies">Tv-Series</a></li>
                                    <li><a href="/movies">Horror</a></li>
                                </ul>
                            </div>
                        </div>
                        <a class="close" href="#close">×</a>
                    </div>
                    <!-- /search popup -->
                    <!--/search-right-->
                </div>
                <div class="Login_SignUp" id="login"
                     style="font-size: 2rem ; display: inline-block; position: relative;">
                    <!-- <li class="nav-item"> -->
                    <a class="nav-link" href="/sign"><i class="fa fa-user-circle-o"></i></a>
                    <!-- </li> -->
                </div>

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
<!--/breadcrumbs -->
<div class="w3l-breadcrumbs">
    <nav id="breadcrumbs" class="breadcrumbs">
        <div class="container page-wrapper">
            <a href="/home">Home</a> » <span class="breadcrumb_last" aria-current="page">movies</span>
        </div>
    </nav>
</div>
<!--/movies -->
<!--grids-sec1-->
<
<section class="w3l-grids">
    <div class="grids-main py-4">
        <div class="container py-lg-4">
            <div class="headerhny-title">
                <h3 class="hny-title">Popular Movies</h3>
            </div>
            <div class="owl-four owl-carousel owl-theme">
                <c:forEach var="itemMovieRating" items="${firstHalf}" varStatus="status">
                    <div class="item vhny-grid">
                        <div class="box16">
                            <a href="#">
                                <figure>
                                    <img class="img-fluid"
                                         src="assets/images/banner-slide/${itemMovieRating.movie_poster_url}"
                                         alt="">
                                </figure>
                                <div class="box-content">
                                    <h3 class="title">${itemMovieRating.movie_title}</h3>
                                    <h4><span class="post"><span
                                            class="fa fa-clock-o"> </span>${itemMovieRating.movie_duration} minutes</span>
                                        <span class="post fa fa-heart text-right"></span>
                                    </h4>
                                </div>
                                <span class="fa fa-play video-icon" aria-hidden="true"></span>
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="owl-four owl-carousel owl-theme">
                <c:forEach var="itemMovieRating" items="${secondHalf}" varStatus="status">
                    <div class="item vhny-grid">
                        <div class="box16">
                            <a href="#">
                                <figure>
                                    <img class="img-fluid"
                                         src="assets/images/banner-slide/${itemMovieRating.movie_poster_url}"
                                         alt="">
                                </figure>
                                <div class="box-content">
                                    <h3 class="title">${itemMovieRating.movie_title}</h3>
                                    <h4><span class="post"><span
                                            class="fa fa-clock-o"> </span>${itemMovieRating.movie_duration} minutes</span>
                                        <span class="post fa fa-heart text-right"></span>
                                    </h4>
                                </div>
                                <span class="fa fa-play video-icon" aria-hidden="true"></span>
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</section>
<!--grids-sec1-->
<section class="w3l-grids">
    <div class="grids-main py-5">
        <div class="container py-lg-4">
            <div class="headerhny-title">
                <div class="w3l-title-grids">
                    <div class="headerhny-left">
                        <h3 class="hny-title">Latest Movies</h3>
                    </div>
                    <div class="headerhny-right text-lg-right">
                        <h4><a class="show-title" href="/movies">Show all</a></h4>
                    </div>
                </div>
            </div>
            <div class="w3l-populohny-grids">
                <c:forEach var="itemMovieByLatest" items="${moviesMovieByLatestMovies}" varStatus="status">
                    <div class="item vhny-grid">
                        <div class="box16 mb-0" style="height: 400px; width: 265px;">
                            <figure>
                                <img class="img-fluid"
                                     src="assets/images/banner/${itemMovieByLatest.movie_poster_url}" alt="">
                            </figure>
                            <a href=".id${itemMovieByLatest.movie_id}" data-toggle="modal">`
                                <div class="box-content">
                                    <h3 class="title">${itemMovieByLatest.movie_title}</h3>
                                    <h4><span class="post"><span
                                            class="fa fa-clock-o"> </span>${itemMovieByLatest.movie_duration} minutes</span>
                                        <span class="post fa fa-heart text-right"></span>
                                    </h4>
                                </div>
                            </a>
                            <!-- Modal -->
                            <div class="modal fade id${itemMovieByLatest.movie_id}" id="myModal" tabindex="-1"
                                 role="dialog"
                                 aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content" id="mymodalcontent">
                                        <div class="modal-header">
                                            <h4 class="modal-title" id="exampleModalLongTitle">DETAILS</h4>
                                            <button type="button" class="closebtn" data-dismiss="modal"
                                                    aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body" id="dynamic-content">
                                            <img src="assets/images/banner/${itemMovieByLatest.movie_poster_url}"
                                                 class="img-fluid modalimg"
                                                 alt=""/>
                                            <p>
                                            <h3>Release Date&nbsp;:${itemMovieByLatest.movie_release_date}</h3>
                                            <h3>Venue:${itemMovieByLatest.movie_country} </h3>
                                            </p>
                                            <h4>About Movie</h4>
                                            <p>
                                                    ${itemMovieByLatest.movie_description}
                                            </p>
                                            <h4>Star Cast</h4>
                                            <p>
                                                Main actor: ${itemMovieByLatest.movie_main_actor}<br/>
                                                Audio: ${itemMovieByLatest.movie_studio}<br/>
                                            </p>
                                        </div>
                                        <div class="bookbtn">
                                            <button type="button" class="btn btn-success"
                                                    onclick="location.href='/ticket-booking?movie_id=${itemMovieByLatest.movie_id}';">
                                                Book
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- modal end -->
                        </div>
                    </div>
                </c:forEach>
            </div>
            <!-- ***********************************Adults Section ************************************** -->
            <div class="w3l-title-grids">
                <div class="headerhny-left">
                    <h3 class="hny-title">Adults</h3>
                </div>
                <div class="headerhny-right text-lg-right">
                    <h4><a class="show-title" href="/movies">Show all</a></h4>
                </div>
            </div>
            <div class="w3l-populohny-grids">
                <c:forEach var="moviesMovieByAdult" items="${moviesMovieByAdults}" varStatus="status">
                    <div class="item vhny-grid">
                        <div class="box16 mb-0" style="height: 400px; width: 265px;">
                            <figure>
                                <img class="img-fluid"
                                     src="assets/images/banner/${moviesMovieByAdult.movie_poster_url}" alt="">
                            </figure>
                            <a href=".id${moviesMovieByAdult.movie_id}" data-toggle="modal">
                                <div class="box-content">
                                    <h3 class="title">${moviesMovieByAdult.movie_title}</h3>
                                    <h4><span class="post"><span
                                            class="fa fa-clock-o"> </span>${moviesMovieByAdult.movie_duration} minutes</span>
                                        <span class="post fa fa-heart text-right"></span>
                                    </h4>
                                </div>
                            </a>
                            <!-- Modal -->
                            <div class="modal fade id${moviesMovieByAdult.movie_id}" id="myModal" tabindex="-1"
                                 role="dialog"
                                 aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content" id="mymodalcontent">
                                        <div class="modal-header">
                                            <h4 class="modal-title" id="exampleModalLongTitle">DETAILS</h4>
                                            <button type="button" class="closebtn" data-dismiss="modal"
                                                    aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body" id="dynamic-content">
                                            <img src="assets/images/banner/${moviesMovieByAdult.movie_poster_url}"
                                                 class="img-fluid modalimg" alt=""/>
                                            <p>
                                            <h3>Release Date&nbsp;:${moviesMovieByAdult.movie_release_date}</h3>
                                            <h3>Venue&nbsp;:${moviesMovieByAdult.movie_country} </h3>
                                            </p>
                                            <h4>About Movie</h4>
                                            <p>
                                                    ${moviesMovieByAdult.movie_description}
                                            </p>
                                            <h4>Star Cast</h4>
                                            <p>
                                                Main actor: ${moviesMovieByAdult.movie_main_actor}<br/>
                                                Audio: ${moviesMovieByAdult.movie_studio}<br/>
                                            </p>
                                        </div>
                                        <div class="bookbtn">
                                            <!-- window.open('/ticket-booking','_blank'); -->
                                            <button type="button" class="btn btn-success"
                                                    onclick="location.href='/ticket-booking?movie_id=${moviesMovieByAdult.movie_id}'">
                                                Book
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- modal end -->
                        </div>
                    </div>
                </c:forEach>
            </div>
            <%--            <!-- ***********************************kids Section ************************************** -->--%>
            <div class="w3l-title-grids">
                <div class="headerhny-left">
                    <h3 class="hny-title">Kids</h3>
                </div>
                <div class="headerhny-right text-lg-right">
                    <h4><a class="show-title" href="/movies">Show all</a></h4>
                </div>
            </div>
            <div class="w3l-populohny-grids">
                <c:forEach var="moviesMovieByKid" items="${moviesMovieByKids}" varStatus="status">
                    <div class="item vhny-grid">
                        <div class="box16 mb-0" style="height: 400px; width: 265px;">
                            <figure>
                                <img class="img-fluid" src="assets/images/banner/${moviesMovieByKid.movie_poster_url}"
                                     alt="">
                            </figure>
                            <a href=".id${moviesMovieByKid.movie_id}" data-toggle="modal">
                                <div class="box-content">
                                    <h3 class="title">${moviesMovieByKid.movie_title}</h3>
                                    <h4><span class="post"><span
                                            class="fa fa-clock-o"> </span>${moviesMovieByKid.movie_duration} minutes</span>
                                        <span class="post fa fa-heart text-right"></span>
                                    </h4>
                                </div>
                            </a>
                            <!-- Modal -->
                            <div class="modal fade id${moviesMovieByKid.movie_id}" id="myModal" tabindex="-1"
                                 role="dialog"
                                 aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content" id="mymodalcontent">
                                        <div class="modal-header">
                                            <h4 class="modal-title" id="exampleModalLongTitle">DETAILS</h4>
                                            <button type="button" class="closebtn" data-dismiss="modal"
                                                    aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body" id="dynamic-content">
                                            <img src="assets/images/banner/${moviesMovieByKid.movie_poster_url}"
                                                 class="img-fluid"
                                                 alt=""/>
                                            <p>
                                            <h3>Release Date&nbsp;:${moviesMovieByKid.movie_release_date}</h3>
                                            <h3>Venue&nbsp;:${moviesMovieByKid.movie_country} </h3>
                                            </p>
                                            <h4>About Movie</h4>
                                            <p>
                                                    ${moviesMovieByKid.movie_description}
                                            </p>
                                            <h4>Star Cast</h4>
                                            <p>
                                                Main actor: ${moviesMovieByKid.movie_main_actor}<br/>
                                                Audio: ${moviesMovieByKid.movie_studio}
                                            </p>
                                        </div>
                                        <div class="bookbtn">
                                            <button type="button" class="btn btn-success"
                                                    onclick="location.href='/ticket-booking?movie_id=${moviesMovieByKid.movie_id}';">
                                                Book
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- modal end -->
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="button-center text-center mt-3">
            <a href="#" class="btn view-button">View all <span class="fa fa-angle-double-right ml-2"
                                                               aria-hidden="true"></span></a>
        </div>
    </div>
</section>

<section class="w3l-albums py-5" id="projects">
    <div class="container py-lg-4">
        <div class="row">
            <div class="col-lg-12 mx-auto">
                <!--Horizontal Tab-->
                <div id="parentHorizontalTab">
                    <ul class="resp-tabs-list hor_1">
                        <li>Recent Movies</li>
                        <li>Popular Movies</li>
                        <li>Trend Movies</li>
                        <div class="clear"></div>
                    </ul>
                    <div class="resp-tabs-container hor_1">
                        <div class="albums-content">
                            <div class="row">
                                <!--/set1-->
                                <c:forEach var="RecentMovies" items="${RecentMovies}" varStatus="status">
                                    <div class="col-lg-4 new-relise-gd mt-lg-0 mt-0">
                                        <div class="slider-info">
                                            <div class="img-circle">
                                                <a href="/movies">
                                                    <img src="assets/images/banner/${RecentMovies.movie_poster_url}"
                                                         class="img-fluid"
                                                         alt="author image">
                                                    <div class="overlay-icon">
																<span class="fa fa-play video-icon"
                                                                      aria-hidden="true"></span>
                                                    </div>
                                                </a>
                                            </div>
                                            <div class="message">
                                                <p>${RecentMovies.movie_country}</p>
                                                <a class="author-book-title"
                                                   href="/movies">${RecentMovies.movie_title}</a>
                                                <h4><span class="post"><span
                                                        class="fa fa-clock-o"> </span>${RecentMovies.movie_duration} minutes</span>
                                                    <span class="post fa fa-heart text-right"></span>
                                                </h4>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="albums-content">
                            <div class="row">
                                <!--/set1-->
                                <c:forEach var="PopularMovies" items="${PopularMovies}" varStatus="status">
                                    <div class="col-lg-4 new-relise-gd mt-lg-0 mt-0">
                                        <div class="slider-info">
                                            <div class="img-circle">
                                                <a href="/movies"><img
                                                        src="assets/images/banner/${PopularMovies.movie_poster_url}"
                                                        class="img-fluid" alt="author image">
                                                    <div class="overlay-icon">

																<span class="fa fa-play video-icon"
                                                                      aria-hidden="true"></span>
                                                    </div>
                                                </a>
                                            </div>
                                            <div class="message">
                                                <p>${PopularMovies.movie_country}</p>
                                                <a class="author-book-title"
                                                   href="/movies">${PopularMovies.movie_title}</a>
                                                <h4><span class="post"><span
                                                        class="fa fa-clock-o"> </span>${PopularMovies.movie_duration} minutes</span>
                                                    <span class="post fa fa-heart text-right"></span>
                                                </h4>
                                            </div>
                                        </div>

                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="albums-content">
                            <div class="row">
                                <!--/set3-->
                                <c:forEach var="TrendMovies" items="${TrendMovies}" varStatus="status">
                                    <div class="col-lg-4 new-relise-gd mt-lg-0 mt-0">
                                        <div class="slider-info">
                                            <div class="img-circle">
                                                <a href="/movies"><img
                                                        src="assets/images/banner/${TrendMovies.movie_poster_url}"
                                                        class="img-fluid" alt="author image">
                                                    <div class="overlay-icon">
																<span class="fa fa-play video-icon"
                                                                      aria-hidden="true"></span>
                                                    </div>
                                                </a>
                                            </div>
                                            <div class="message">
                                                <p>${TrendMovies.movie_country}</p>
                                                <a class="author-book-title"
                                                   href="/movies">${TrendMovies.movie_title}</a>
                                                <h4><span class="post"><span
                                                        class="fa fa-clock-o"> </span>${TrendMovies.movie_duration} minutes</span>
                                                    <span class="post fa fa-heart text-right"></span>
                                                </h4>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--grids-sec2-->
<!-- footer-66 -->
<footer class="w3l-footer">
    <section class="footer-inner-main">
        <div class="footer-hny-grids py-5">
            <div class="container py-lg-4">
                <div class="text-txt">
                    <div class="right-side">
                        <div class="row footer-about">
                            <c:forEach var="itemMovie" items="${moviesBannerSlide}">
                                <div class="col-md-3 col-6 footer-img mb-lg-0 mb-4">
                                    <a href="/movies"><img class="img-fluid"
                                                           src="assets/images/banner-slide/${itemMovie.movie_poster_url}"
                                                           alt=""></a>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="row footer-links">
                            <div class="col-md-3 col-sm-6 sub-two-right mt-5">
                                <h6>Movies</h6>
                                <ul>
                                    <li><a href="#">Movies</a></li>
                                    <li><a href="#">Videos</a></li>
                                    <li><a href="#">English Movies</a></li>
                                    <li><a href="#">Tailor</a></li>
                                    <li><a href="#">Upcoming Movies</a></li>
                                    <li><a href="/Contact_Us">Contact Us</a></li>
                                </ul>
                            </div>
                            <div class="col-md-3 col-sm-6 sub-two-right mt-5">
                                <h6>Information</h6>
                                <ul>
                                    <li><a href="/home">Home</a></li>
                                    <li><a href="/about">About</a></li>
                                    <li><a href="#">Tv Series</a></li>
                                    <li><a href="/dashboard">DashBoard</a></li>
                                    <li><a href="/sign">Login</a></li>
                                    <li><a href="/Contact_Us">Contact</a></li>
                                </ul>
                            </div>
                            <div class="col-md-3 col-sm-6 sub-two-right mt-5">
                                <h6>Locations</h6>
                                <ul>
                                    <li><a href="/movies">Asia</a></li>
                                    <li><a href="/movies">France</a></li>
                                    <li><a href="/movies">Taiwan</a></li>
                                    <li><a href="/movies">United States</a></li>
                                    <li><a href="/movies">Korea</a></li>
                                    <li><a href="/movies">United Kingdom</a></li>
                                </ul>
                            </div>
                            <div class="col-md-3 col-sm-6 sub-two-right mt-5">
                                <h6>Newsletter</h6>
                                <form action="#" class="subscribe mb-3" method="post">
                                    <input type="email" name="email" placeholder="Your Email Address"
                                           required="">
                                    <button><span class="fa fa-envelope-o"></span></button>
                                </form>
                                <p>Enter your email and receive the latest news, updates and special offers
                                    from us.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
        <div class="below-section">
            <div class="container">
                <div class="copyright-footer">
                    <div class="columns text-lg-left">
                        <p>&copy; 2024 MyShowz. All rights reserved</p>
                    </div>

                    <ul class="social text-lg-right">
                        <li><a href="#facebook"><span class="fa fa-facebook" aria-hidden="true"></span></a>
                        </li>
                        <li><a href="#linkedin"><span class="fa fa-linkedin" aria-hidden="true"></span></a>
                        </li>
                        <li><a href="#twitter"><span class="fa fa-twitter" aria-hidden="true"></span></a>
                        </li>
                        <li><a href="#google"><span class="fa fa-google-plus" aria-hidden="true"></span></a>
                        </li>

                    </ul>
                </div>
            </div>
        </div>
        <!-- move top -->
        <button onclick="topFunction()" id="movetop" title="Go to top">
            <span class="fa fa-arrow-up" aria-hidden="true"></span>
        </button>
        <script>
            // When the user scrolls down 20px from the top of the document, show the button
            window.onscroll = function () {
                scrollFunction()
            };

            function scrollFunction() {
                if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
                    document.getElementById("movetop").style.display = "block";
                } else {
                    document.getElementById("movetop").style.display = "none";
                }
            }

            // When the user clicks on the button, scroll to the top of the document
            function topFunction() {
                document.body.scrollTop = 0;
                document.documentElement.scrollTop = 0;
            }
        </script>
        <!-- /move top -->

    </section>
</footer>
</body>

</html>
<script src="assets/js/jquery-3.3.1.min.js"></script>
<!--/theme-change-->
<script src="assets/js/theme-change.js"></script>
<script src="assets/js/owl.carousel.js"></script>
<script>
    $(document).ready(function () {
        $('.owl-four').owlCarousel({
            loop: true,
            margin: 20,
            nav: false,
            responsiveClass: true,
            autoplay: false,
            autoplayTimeout: 5000,
            autoplaySpeed: 1000,
            autoplayHoverPause: false,
            responsive: {
                0: {
                    items: 1,
                    nav: false
                },
                480: {
                    items: 2,
                    nav: true
                },
                667: {
                    items: 2,
                    nav: true
                },
                1000: {
                    items: 2,
                    nav: true
                }
            }
        })
    })
</script>
<script>
    $(document).ready(function () {
        $('.owl-two').owlCarousel({
            loop: true,
            margin: 40,
            nav: false,
            responsiveClass: true,
            autoplay: true,
            autoplayTimeout: 5000,
            autoplaySpeed: 1000,
            autoplayHoverPause: false,
            responsive: {
                0: {
                    items: 1,
                    nav: false
                },
                480: {
                    items: 2,
                    nav: true
                },
                667: {
                    items: 2,
                    margin: 20,
                    nav: true
                },
                1000: {
                    items: 3,
                    nav: true
                }
            }
        })
    })
</script>
<!-- script for owlcarousel -->
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
<script src="assets/js/easyResponsiveTabs.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        //Horizontal Tab
        $('#parentHorizontalTab').easyResponsiveTabs({
            type: 'default', //Types: default, vertical, accordion
            width: 'auto', //auto or any width like 600px
            fit: true, // 100% fit in a container
            tabidentify: 'hor_1', // The tab groups identifier
            activate: function (event) { // Callback function if tab is switched
                var $tab = $(this);
                var $info = $('#nested-tabInfo');
                var $name = $('span', $info);
                $name.text($tab.text());
                $info.show();
            }
        });
    });
</script>

<script src="assets/js/bootstrap.min.js"></script>