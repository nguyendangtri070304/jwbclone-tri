<!doctype html>
<html lang="zxx">
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>My Show</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <title>Home</title>
    <!-- Logo -->
    <link href="assets/images/logo.png" rel="icon"/>
    <link href="assets/images/logo.png" rel="apple-touch-icon"/>
    <link rel="stylesheet" href="./assets/css/style-starter.css">
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
                MyShowz</a></h1>
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
                    <li class="nav-item active">
                        <a class="nav-link" href="/home">Home</a>
                    </li>
                    <li class="nav-item">
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
<!-- main-slider -->
<section class="w3l-main-slider position-relative" id="home">
    <div class="companies20-content">
        <div class="owl-one owl-carousel owl-theme">
            <c:forEach var="itemMovie" items="${moviesBannerSlide}">
                <div class="item">
                    <li>
                        <div class="slider-info banner-view bg bg2"
                             style="background: url(./assets/images/banner-slide/${itemMovie.movie_poster_url}) no-repeat center;">
                            <div class="banner-info">
                                <h3>${itemMovie.movie_title}</h3>
                                <p>${itemMovie.movie_description} <br><span
                                        class="over-para">${itemMovie.movie_duration} minutes</span>
                                </p>
                                <a href="#small-dialog${itemMovie.movie_id}" class="popup-with-zoom-anim play-view1">
                                            <span class="video-play-icon">
                                                <span class="fa fa-play"></span>
                                            </span>
                                    <h6>Watch Trailer</h6>
                                </a>
                                <div id="small-dialog${itemMovie.movie_id}" class="zoom-anim-dialog mfp-hide ">
                                    <iframe width="1862" height="765"
                                            src="https://www.youtube.com/embed/${itemMovie.movie_trailer_url}"
                                            title="Marvel Studios&#39; Avengers: Endgame - Official Trailer"
                                            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                                            referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                                </div>
                            </div>
                        </div>
                    </li>
                </div>
            </c:forEach>
        </div>
    </div>
</section>

<%--                    .w3l-main-slider .banner-top1 {--%>
<%--                    background: url(../images/banner2.jpg) no-repeat center;--%>
<%--                    background-size: cover;--%>
<%--                    }--%>

<%--                    .w3l-main-slider .banner-top2 {--%>
<%--                    background: url(../images/banner3.jpg) no-repeat center;--%>
<%--                    background-size: cover;--%>
<%--                    }--%>

<%--                    .w3l-main-slider .banner-top3 {--%>
<%--                    background: url(../images/banner4.jpg) no-repeat center;--%>
<%--                    background-size: cover;--%>
<%--                    }--%>
<%--                        .w3l-main-slider .banner-view {--%>
<%--                        background: url(../images/banner1.jpg) no-repeat center;--%>
<%--                        background-size: cover;--%>
<%--                        min-height: 500px;--%>
<%--                        position: relative;--%>
<%--                        z-index: 0;--%>
<%--                        display: grid;--%>
<%--                        align-items: center;--%>
<%--                        border-radius: 6px;--%>
<%--                        -webkit-border-radius: 6px;--%>
<%--                        -o-border-radius: 6px;--%>
<%--                        -ms-border-radius: 6px;--%>
<%--                        -moz-border-radius: 6px;--%>
<%--                        }--%>
<!-- main-slider -->
<!--grids-sec1-->
<section class="w3l-grids">
    <div class="grids-main py-5">
        <div class="container py-lg-3">
            <div class="headerhny-title">
                <div class="w3l-title-grids">
                    <div class="headerhny-left">
                        <h3 class="hny-title">Popular Movies</h3>
                    </div>
                    <div class="headerhny-right text-lg-right">
                        <h4><a class="show-title" href="/movies">Show all</a></h4>
                    </div>
                </div>
            </div>
            <div class="w3l-populohny-grids">
                <c:forEach var="itemMovieRating" items="${moviesMovieByRating}">
                    <div class="item vhny-grid">
                        <div class="box16" style="height: 400px; width: 265px;">
                            <a href="/movies">
                                <figure>
                                    <img class="img-fluid"
                                         src="assets/images/banner/${itemMovieRating.movie_poster_url}"
                                         alt="${itemMovieRating.movie_description}">
                                </figure>
                                <div class="box-content">
                                    <h3 class="title">${itemMovieRating.movie_title}</h3>
                                    <h4><span class="post"><span
                                            class="fa fa-clock-o"> </span>${itemMovieRating.movie_duration} minutes </span>
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
<!--//grids-sec1-->
<!--grids-sec2-->
<section class="w3l-grids">
    <div class="grids-main py-5">
        <div class="container py-lg-3">
            <div class="headerhny-title">
                <div class="w3l-title-grids">
                    <div class="headerhny-left">
                        <h3 class="hny-title">New Releases</h3>
                    </div>
                    <div class="headerhny-right text-lg-right">
                        <h4><a class="show-title" href="/movies">Show all</a></h4>
                    </div>
                </div>
            </div>
            <div class="owl-three owl-carousel owl-theme">
                <c:forEach var="itemMovieLatest" items="${moviesMovieByLatestMovies}">
                    <div class="item vhny-grid">
                        <div class="box16 mb-0" style="height: 320px;">
                            <a href="/movies">
                                <figure>
                                    <img class="img-fluid"
                                         src="assets/images/banner/${itemMovieLatest.movie_poster_url}" alt="">
                                </figure>
                                <div class="box-content">
                                    <h4><span class="post">
                                        <span class="fa fa-clock-o"> </span>
                                            ${itemMovieLatest.movie_duration} minutes </span>
                                        <span class="post fa fa-heart text-right"></span>
                                    </h4>
                                </div>
                                <span class="fa fa-play video-icon" aria-hidden="true"></span>
                            </a>
                        </div>
                        <h3><a class="title-gd" href="/movies">${itemMovieLatest.movie_title}</a></h3>
                        <div class="button-center text-center mt-4">
                            <a href="/movies" class="btn watch-button">Watch now</a>
                        </div>
                        <p>${itemMovieLatest.movie_description}</p>
                    </div>
                </c:forEach>
            </div>
        </div>

    </div>
</section>
<!--grids-sec2-->
<!--mid-slider -->
<section class="w3l-mid-slider position-relative">
    <div class="companies20-content">
        <div class="owl-mid owl-carousel owl-theme">
            <c:forEach var="itemMovieRandom" items="${moviesRandom}">
                <div class="item">
                    <li>
                        <div class="slider-info banner-view bg bg2"
                             style="background: url(./assets/images/banner-slide/${itemMovieRandom.movie_poster_url}) no-repeat center;  min-height: 100%; height: 700px; width: 1680px;
                                     background-position: top center;
                                     border-radius:20px;
                                     box-sizing: border-box;
                                     justify-self: center">
                            <div class="container">
                                <div class="mid-info" style="background-color: rgba(0, 0, 0, 0.75);
                                                             border-radius: 15px;
                                                             padding: 15px;
                                                                    ">
                                    <span class="sub-text">${itemMovieRandom.movie_genre}</span>
                                    <h3>${itemMovieRandom.movie_title}</h3>
                                    <p>${itemMovieRandom.movie_release_date}
                                        ‧ ${itemMovieRandom.movie_country}/${itemMovieRandom.movie_for_age}
                                        ‧ ${itemMovieRandom.movie_duration} minutes </p>
                                    <a class="watch" href="/movies"><span class="fa fa-play" aria-hidden="true"></span>
                                        Watch Trailer</a>
                                </div>
                            </div>
                        </div>
                    </li>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
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
<!-- responsive tabs -->
<script src="assets/js/jquery-1.9.1.min.js"></script>
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
<!--/theme-change-->
<script src="assets/js/theme-change.js"></script>
<script src="assets/js/owl.carousel.js"></script>
<!-- script for banner slider-->
<script>
    $(document).ready(function () {
        $('.owl-one').owlCarousel({
            stagePadding: 280,
            loop: true,
            margin: 20,
            nav: true,
            responsiveClass: true,
            autoplay: true,
            autoplayTimeout: 5000,
            autoplaySpeed: 1000,
            autoplayHoverPause: false,
            responsive: {
                0: {
                    items: 1,
                    stagePadding: 40,
                    nav: false
                },
                480: {
                    items: 1,
                    stagePadding: 60,
                    nav: true
                },
                667: {
                    items: 1,
                    stagePadding: 80,
                    nav: true
                },
                1000: {
                    items: 1,
                    nav: true
                }
            }
        })
    })
</script>
<script>
    $(document).ready(function () {
        $('.owl-three').owlCarousel({
            loop: true,
            margin: 20,
            nav: false,
            responsiveClass: true,
            autoplay: true,
            autoplayTimeout: 5000,
            autoplaySpeed: 1000,
            autoplayHoverPause: false,
            responsive: {
                0: {
                    items: 2,
                    nav: false
                },
                480: {
                    items: 2,
                    nav: true
                },
                667: {
                    items: 3,
                    nav: true
                },
                1000: {
                    items: 5,
                    nav: true
                }
            }
        })
    })
</script>
<script>
    $(document).ready(function () {
        $('.owl-mid').owlCarousel({
            loop: true,
            margin: 0,
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
                    items: 1,
                    nav: false
                },
                667: {
                    items: 1,
                    nav: true
                },
                1000: {
                    items: 1,
                    nav: true
                }
            }
        })
    })
</script>
<!-- script for owlcarousel -->
<script src="assets/js/jquery.magnific-popup.min.js"></script>
<script>
    $(document).ready(function () {
        $('.popup-with-zoom-anim').magnificPopup({
            type: 'inline',

            fixedContentPos: false,
            fixedBgPos: true,

            overflowY: 'auto',

            closeBtnInside: true,
            preloader: false,

            midClick: true,
            removalDelay: 300,
            mainClass: 'my-mfp-zoom-in'
        });

        $('.popup-with-move-anim').magnificPopup({
            type: 'inline',

            fixedContentPos: false,
            fixedBgPos: true,

            overflowY: 'auto',

            closeBtnInside: true,
            preloader: false,

            midClick: true,
            removalDelay: 300,
            mainClass: 'my-mfp-slide-bottom'
        });
    });
</script>
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