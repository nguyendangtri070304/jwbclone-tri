<!DOCTYPE html>
<html lang="en">
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<head>
    <meta charset="utf-8"/>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>

    <title>Tables / Data - NiceAdmin Bootstrap Template</title>
    <meta content="" name="description"/>
    <meta content="" name="keywords"/>

    <!-- Logo -->
    <link href="assets/images/logo.png" rel="icon"/>
    <link href="assets/images/logo.png" rel="apple-touch-icon"/>

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect"/>
    <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
            rel="stylesheet"/>

    <!-- Vendor CSS Files -->
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet"/>
    <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet"/>
    <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet"/>
    <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet"/>
    <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet"/>
    <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet"/>

    <!-- Template Main CSS File -->
    <link href="assets/css/style.css" rel="stylesheet"/>
    <link rel="stylesheet" href="assets/css/style-starter.css"/>
    <link
            href="//fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;1,600&display=swap"
            rel="stylesheet"/>
    <!-- =======================================================
* Template Name: NiceAdmin
* Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
* Updated: Apr 20 2024 with Bootstrap v5.3.3
* Author: BootstrapMade.com
* License: https://bootstrapmade.com/license/
======================================================== -->
</head>

<body>
<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center">
    <div class="d-flex align-items-center justify-content-between">
        <a href="/home" class="logo d-flex align-items-center navbar-brand">
            <img src="./assets/img/logo-haui-size.png" alt="Your logo" title="Your logo"
                 style="height: 35px"/>
            <span class="d-none d-lg-block">Myshowz</span>
        </a>
        <i class="bi bi-list toggle-sidebar-btn"></i>
    </div>
    <!-- End Logo -->

    <div class="search-bar">
        <form class="search-form d-flex align-items-center" method="POST" action="#">
            <input type="text" name="query" placeholder="Search" title="Enter search keyword"/>
            <button type="submit" title="Search">
                <i class="bi bi-search"></i>
            </button>
        </form>
    </div>
    <!-- End Search Bar -->

    <nav class="header-nav ms-auto">
        <ul class="d-flex align-items-center">
            <li class="nav-item d-block d-lg-none">
                <a class="nav-link nav-icon search-bar-toggle" href="#">
                    <i class="bi bi-search"></i>
                </a>
            </li>
            <!-- End Search Icon-->

            <li class="nav-item dropdown">
                <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
                    <i class="bi bi-bell"></i>
                    <span class="badge bg-primary badge-number">4</span>
                </a><!-- End Notification Icon -->

                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications">
                    <li class="dropdown-header">
                        You have 4 new notifications
                        <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View
                                                all</span></a>
                    </li>
                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li class="notification-item">
                        <i class="bi bi-exclamation-circle text-warning"></i>
                        <div>
                            <h4>Lorem Ipsum</h4>
                            <p>Quae dolorem earum veritatis oditseno</p>
                            <p>30 min. ago</p>
                        </div>
                    </li>

                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li class="notification-item">
                        <i class="bi bi-x-circle text-danger"></i>
                        <div>
                            <h4>Atque rerum nesciunt</h4>
                            <p>Quae dolorem earum veritatis oditseno</p>
                            <p>1 hr. ago</p>
                        </div>
                    </li>

                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li class="notification-item">
                        <i class="bi bi-check-circle text-success"></i>
                        <div>
                            <h4>Sit rerum fuga</h4>
                            <p>Quae dolorem earum veritatis oditseno</p>
                            <p>2 hrs. ago</p>
                        </div>
                    </li>

                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li class="notification-item">
                        <i class="bi bi-info-circle text-primary"></i>
                        <div>
                            <h4>Dicta reprehenderit</h4>
                            <p>Quae dolorem earum veritatis oditseno</p>
                            <p>4 hrs. ago</p>
                        </div>
                    </li>

                    <li>
                        <hr class="dropdown-divider"/>
                    </li>
                    <li class="dropdown-footer">
                        <a href="#">Show all notifications</a>
                    </li>
                </ul>
                <!-- End Notification Dropdown Items -->
            </li>
            <!-- End Notification Nav -->

            <li class="nav-item dropdown">
                <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
                    <i class="bi bi-chat-left-text"></i>
                    <span class="badge bg-success badge-number">3</span> </a><!-- End Messages Icon -->

                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow messages">
                    <li class="dropdown-header">
                        You have 3 new messages
                        <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View
                                                all</span></a>
                    </li>
                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li class="message-item">
                        <a href="#">
                            <img src="assets/img/messages-1.jpg" alt="" class="rounded-circle"/>
                            <div>
                                <h4>Maria Hudson</h4>
                                <p>
                                    Velit asperiores et ducimus soluta repudiandae labore
                                    officia est ut...
                                </p>
                                <p>4 hrs. ago</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li class="message-item">
                        <a href="#">
                            <img src="assets/img/messages-2.jpg" alt="" class="rounded-circle"/>
                            <div>
                                <h4>Anna Nelson</h4>
                                <p>
                                    Velit asperiores et ducimus soluta repudiandae labore
                                    officia est ut...
                                </p>
                                <p>6 hrs. ago</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li class="message-item">
                        <a href="#">
                            <img src="assets/img/messages-3.jpg" alt="" class="rounded-circle"/>
                            <div>
                                <h4>David Muldon</h4>
                                <p>
                                    Velit asperiores et ducimus soluta repudiandae labore
                                    officia est ut...
                                </p>
                                <p>8 hrs. ago</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li class="dropdown-footer">
                        <a href="#">Show all messages</a>
                    </li>
                </ul>
                <!-- End Messages Dropdown Items -->
            </li>
            <!-- End Messages Nav -->

            <li class="nav-item dropdown pe-3">
                <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#"
                   data-bs-toggle="dropdown">
                    <img src="assets/images/logo.png" alt="Profile" class="rounded-circle"/>
                    <span class="d-none d-md-block dropdown-toggle ps-2">Group 11</span>
                </a>
                <!-- End Profile Iamge Icon -->

                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                    <li class="dropdown-header">
                        <h6>Group 11</h6>
                        <span>Web Designer</span>
                    </li>
                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="/profile">
                            <i class="bi bi-person"></i>
                            <span>My Profile</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="/profile">
                            <i class="bi bi-gear"></i>
                            <span>Account Settings</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="/">
                            <i class="bi bi-question-circle"></i>
                            <span>Need Help?</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider"/>
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="/sign">
                            <i class="bi bi-box-arrow-right"></i>
                            <span>Sign Out</span>
                        </a>
                    </li>
                </ul>
                <!-- End Profile Dropdown Items -->
            </li>
            <!-- End Profile Nav -->
        </ul>
    </nav>
    <!-- End Icons Navigation -->
</header>
<!-- End Header -->

<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">
    <ul class="sidebar-nav" id="sidebar-nav">
        <!-- Dashboard -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/dashboard">
                <i class="bi bi-grid"></i>
                <span>Dashboard</span>
            </a>
        </li>
        <!-- End Dashboard Nav -->
        <!-- Movies -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/Movies">
                <i class="bi bi-film"></i>
                <span>Movies</span>
            </a>
        </li>
        <!-- End Movies Nav -->
        <!-- Showtimes -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/showtimes">
                <i class="bi bi-calendar"></i>
                <span>Showtimes</span>
            </a>
        </li>
        <!-- End Showtimes Nav -->
        <!-- Tickets -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="e-ticket">
                <i class="bi bi-ticket-perforated"></i>
                <span>Tickets</span>
            </a>
        </li>
        <!-- End Tickets Nav -->
        <!-- Customers -->
        <li class="nav-item">
            <a class="nav-link" href="/Customers">
                <i class="bi bi-people"></i>
                <span>Customers</span>
            </a>
        </li>
        <!-- End Customers Nav -->
        <!-- Employees -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/employees">
                <i class="bi bi-person-badge"></i>
                <span>Employees</span>
            </a>
        </li>
        <!-- End Employees Nav -->
        <!-- Pages Section -->
        <li class="nav-heading">Pages</li>
        <!-- Profile -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/profile">
                <i class="bi bi-person"></i>
                <span>Profile</span>
            </a>
        </li>
        <!-- End Profile Page Nav -->
        <!-- F.A.Q -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/">
                <i class="bi bi-question-circle"></i>
                <span>F.A.Q</span>
            </a>
        </li>
        <!-- End F.A.Q Page Nav -->
        <!-- Contact -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/Contact_Us">
                <i class="bi bi-envelope"></i>
                <span>Contact</span>
            </a>
        </li>
        <!-- End Contact Page Nav -->
        <!-- Login -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/sign">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Login</span>
            </a>
        </li>
        <!-- End Login Page Nav -->
        <!-- Error 404 -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/">
                <i class="bi bi-dash-circle"></i>
                <span>Error 404</span>
            </a>
        </li>
        <!-- End Error 404 Page Nav -->
    </ul>
</aside>
<!-- End Sidebar -->

<main id="main" class="main">
    <div class="pagetitle">
        <h1>Data Tables</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="/dashboard">Dashboard</a></li>
                <li class="breadcrumb-item active">Customer</li>
            </ol>
        </nav>
    </div>
    <!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
<%--                        <h5 class="card-title">Datatables</h5>--%>
                        <button type="button" class="btn btn-info mb-2">
                            <a href="/create-User" style="color: black;">Add Customer</a>
                        </button>
<%--                        <p>--%>
<%--                            Add lightweight datatables to your project with using the--%>
<%--                            <a href="https://github.com/fiduswriter/Simple-DataTables"--%>
<%--                               target="_blank">Simple--%>
<%--                                DataTables</a>--%>
<%--                            library. Just add <code>.datatable</code> class name to any--%>
<%--                            table you wish to conver to a datatable. Check for--%>
<%--                            <a href="https://fiduswriter.github.io/simple-datatables/demos/"--%>
<%--                               target="_blank">more--%>
<%--                                examples</a>.--%>
<%--                        </p>--%>

                        <!-- Table with stripped rows -->
                        <table class="table datatable">
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>Full Name</th>
                                <th>Email</th>
                                <th>Mobile</th>
                                <th data-type="date" data-format="YYYY/DD/MM">
                                    Date Of Birth
                                </th>
                                <th>Gender</th>
                                <th>Active</th>
                                <th>Options</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${customersList}">
                                <tr>
                                    <td>${item.customer_id}</td>
                                    <td>${item.customer_name}</td>
                                    <td>${item.customer_email}</td>
                                    <td>${item.customer_phone}</td>
                                    <td>${item.customer_date_of_birth}</td>
                                    <td>${item.customer_gender}</td>
                                    <td>${item.customer_is_active}</td>
                                    <td>
                                        <div class="wrapper-btn d-flex justify-content-between">
                                            <button type="button" class="btn btn-success mb-2"
                                                    onclick="ViewPassWord(${item.customer_id}, '${item.customer_password}')">
                                                View
                                            </button>
                                            <button type="button" class="btn btn-warning mb-2">
                                                <a href="/editCustomer/${item.customer_id}"
                                                   class="btn btn-warning mb-2"> Edit </a>
                                            </button>
                                            <button type="button" class="btn btn-danger mb-2"
                                                    onclick="confirmDelete(${item.customer_id})">
                                                Change status
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                        <!-- End Table with stripped rows -->
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<!-- End #main -->

<!-- ======= Footer ======= -->
<footer id="footer" class="footer">
    <div class="copyright">
        &copy; Copyright <strong><span>NiceAdmin</span></strong>. All Rights Reserved
    </div>
    <div class="credits">
        <!-- All the links in the footer should remain intact. -->
        <!-- You can delete the links only if you purchased the pro version. -->
        <!-- Licensing information: https://bootstrapmade.com/license/ -->
        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
        Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
    </div>
</footer>
<!-- End Footer -->

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>

<!-- Vendor JS Files -->
<script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="assets/vendor/chart.js/chart.umd.js"></script>
<script src="assets/vendor/echarts/echarts.min.js"></script>
<script src="assets/vendor/quill/quill.js"></script>
<script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
<script src="assets/vendor/tinymce/tinymce.min.js"></script>
<script src="assets/vendor/php-email-form/validate.js"></script>
<%--<script> function editCustomer(customerId) {--%>
<%--    fetch(`/api/customers/${customerId}`).then(response => response.json()).then(data => {--%>
<%--        localStorage.setItem('customer', JSON.stringify(data));--%>
<%--        window.location.href = '/editCustomer.html';--%>
<%--    }).catch(error => console.error('Error:', error));--%>
<%--} </script>--%>
<!-- Template Main JS File -->
<script>
    function confirmDelete(customerId) {
        var result = confirm("Are you sure you want to delete Customer with id = " + customerId);
        if (result) {
// Thực hiện hành động xóa, ví dụ như gửi yêu cầu tới server
            window.location.href = '/deleteCustomer/' + customerId;
        }
    }

    function ViewPassWord(customerId, customerPass) {
        var result = confirm("passwords is of " + customerId + " is: " + customerPass);
        if (result) {
// Thực hiện hành động xóa, ví dụ như gửi yêu cầu tới server
        }
    }
</script>

<script src="assets/js/main.js"></script>
</body>

</html>