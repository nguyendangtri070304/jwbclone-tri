<!DOCTYPE html>
<html lang="en">
<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Ticket Booking</title>
      <link rel="stylesheet" type="text/css" href="assets/css/style-starter.css">
      <link rel="stylesheet" href="https://npmcdn.com/flickity@2/dist/flickity.css">
      <link rel="stylesheet" type="text/css" href="assets/css/progress.css">

      <link rel="stylesheet" type="text/css" href="assets/css/ticket-booking.css">

      <!-- ..............For progress-bar............... -->
      <link rel="stylesheet" type="text/css" href="assets/css/e-ticket.css">

      <link rel="stylesheet" type="text/css" href="assets/css/payment.css" />
      <link href="https://fonts.googleapis.com/css?family=Yanone+Kaffeesatz:400,700" rel="stylesheet">
    </head>

    <body>
      <header id="site-header" class="w3l-header fixed-top">

        <!--/nav-->
        <nav class="navbar navbar-expand-lg navbar-light fill px-lg-0 py-0 px-3">
          <div class="container">
            <h1><a class="navbar-brand" href="/home"><span class="fa fa-play icon-log" aria-hidden="true"></span>
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

      <div class="container" id="progress-container-id">
        <div class="row">
          <div class="col">
            <div class="px-0 pt-4 pb-0 mt-3 mb-3">
              <form id="form">
                <ul id="progressbar" class="progressbar-class">
                  <li class="active" id="step1">Show timing selection</li>
                  <li id="step2" class="not_active">Seat Selection</li>
                  <li id="step3" class="not_active">Payment</li>
                  <li id="step4" class="not_active">E-Ticket</li>
                </ul>
                <br>
                <fieldset>
                  <div id="screen-select-div">
                    <h2>Show time Selection</h2>
                    <div class="carousel carousel-nav" data-flickity='{"contain": true, "pageDots": false }'>
                      <c:if test="${empty uniqueDates}">
                        <div class="no-dates-message">No show dates available.</div>
                      </c:if>
                      <c:if test="${not empty uniqueDates}">
                        <c:forEach items="${uniqueDates}" var="date" varStatus="status" begin="1">
                          <button class="carousel-cell" id="${status.index}" data-movie-id="${movie_id}" onclick="myFunction(${status.index}, '${date}')">
                            <div class="date-numeric">${date}</div>
                            <div class="date-day"></div>
                          </button>
                        </c:forEach>

                      </c:if>
                    </div>

                    <ul class="time-ul">
                      <!-- Các phần tử li sẽ được tạo động từ dữ liệu API -->
                    </ul>

                  </div>
                  <input id="screen-next-btn" type="button" name="next-step" class="next-step" value="Continue Booking"
                    disabled onclick="continueBooking()"/>
                </fieldset>
                <fieldset>

                  <div>
                    <iframe id="seat-sel-iframe"
                      style="  box-shadow: 0 14px 12px 0 var(--theme-border), 0 10px 50px 0 var(--theme-border); width: 800px; height: 550px; display: block; margin-left: auto; margin-right: auto;"
                      src="/seat_sel"></iframe>
                  </div>
                  <br>
                  <input type="button" name="next-step" class="next-step" value="Proceed to Payment" />
                  <input type="button" name="previous-step" class="previous-step" value="Back" />
                </fieldset>
                <fieldset>
                  <!-- Payment Page -->
                  <div id="payment_div">
                    <div class="payment-row">
                      <div class="col-75">
                        <div class="payment-container">
                          <div class="payment-row">
                            <div class="col-50">
                              <h3 id="payment-h3">Payment</h3>
                              <div class="payment-row payment">
                                <div class="col-50 payment">
                                  <label for="card" class="method card">
                                    <div class="icon-container">
                                      <i class="fa fa-cc-visa" style="color: navy"></i>
                                      <i class="fa fa-cc-amex" style="color: blue"></i>
                                      <i class="fa fa-cc-mastercard" style="color: red"></i>
                                      <i class="fa fa-cc-discover" style="color: orange"></i>
                                    </div>
                                    <div class="radio-input">
                                      <input type="radio" id="card" />
                                      Pay RS.200.00 with credit card
                                    </div>
                                  </label>
                                </div>
                                <div class="col-50 payment">
                                  <label for="paypal" class="method paypal">
                                    <div class="icon-container">
                                      <i class="fa fa-paypal" style="color: navy"></i>
                                    </div>
                                    <div class="radio-input">
                                      <input id="paypal" type="radio" checked>
                                      Pay $30.00 with PayPal
                                    </div>
                                  </label>
                                </div>
                              </div>

                              <div class="payment-row">
                                <div class="col-50">
                                  <label for="cname">Cardholder's Name</label>
                                  <input type="text" id="cname" name="cardname" placeholder="Firstname Lastname"
                                    required />
                                </div>
                                <div class="col-50">
                                  <label for="ccnum">Credit card number</label>
                                  <input type="text" id="ccnum" name="cardnumber" placeholder="xxxx-xxxx-xxxx-xxxx"
                                    required />
                                </div>
                              </div>
                              <div class="payment-row">
                                <div class="col-50">
                                  <label for="expmonth">Exp Month</label>
                                  <input type="text" id="expmonth" name="expmonth" placeholder="September" required />
                                </div>
                                <div class="col-50">
                                  <div class="payment-row">
                                    <div class="col-50">
                                      <label for="expyear">Exp Year</label>
                                      <input type="text" id="expyear" name="expyear" placeholder="yyyy" required />
                                    </div>
                                    <div class="col-50">
                                      <label for="cvv">CVV</label>
                                      <input type="text" id="cvv" name="cvv" placeholder="xxx" required />
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <input type="button" name="next-step" class="next-step pay-btn" value="Confirm Payment" />
                  <input type="button" name="previous-step" class="cancel-pay-btn" value="Cancel Payment"
                    onclick="location.href='/home';" />
                </fieldset>
                <fieldset>
                  <h2>E-Ticket</h2>
                  <div class="ticket-body">
                    <div class="ticket">
                      <div class="holes-top"></div>
                      <div class="title">
                        <p class="cinema">MyShowz Entertainment</p>
                        <p class="movie-title">Movie Name</p>
                      </div>
                      <div class="poster">
                        <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/25240/only-god-forgives.jpg"
                          alt="Movie: Only God Forgives" />
                      </div>
                      <div class="info">
                        <table class="info-table ticket-table">
                          <tr>
                            <th>SCREEN</th>
                            <th>ROW</th>
                            <th>SEAT</th>
                          </tr>
                          <tr>
                            <td class="bigger">18</td>
                            <td class="bigger">H</td>
                            <td class="bigger">24</td>
                          </tr>
                        </table>
                        <table class="info-table ticket-table">
                          <tr>
                            <th>PRICE</th>
                            <th>DATE</th>
                            <th>TIME</th>
                          </tr>
                          <tr>
                            <td>RS.12.00</td>
                            <td>4/13/21</td>
                            <td>19:30</td>
                          </tr>
                        </table>
                      </div>
                      <div class="holes-lower"></div>
                      <div class="serial">
                        <table class="barcode ticket-table">
                          <tr>
                            <td style="background-color:black;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                            <td style="background-color:black;"></td>
                            <td style="background-color:white;"></td>
                          </tr>
                        </table>
                        <table class="numbers ticket-table">
                          <tr>
                            <td>9</td>
                            <td>1</td>
                            <td>7</td>
                            <td>3</td>
                            <td>7</td>
                            <td>5</td>
                            <td>4</td>
                            <td>4</td>
                            <td>4</td>
                            <td>5</td>
                            <td>4</td>
                            <td>1</td>
                            <td>4</td>
                            <td>7</td>
                            <td>8</td>
                            <td>7</td>
                            <td>3</td>
                            <td>4</td>
                            <td>1</td>
                            <td>4</td>
                            <td>5</td>
                            <td>2</td>
                          </tr>
                        </table>
                      </div>
                    </div>
                  </div>
                  <input type="button" name="previous-step" class="home-page-btn" value="Browse to Home Page"
                    onclick="location.href='/home';" />
                </fieldset>
              </form>
            </div>
          </div>
        </div>
      </div>
    </body>

    <script>
      let prevId = "1";

      window.onload = function () {
        document.getElementById("screen-next-btn").disabled = true;
      }

      let selectedDate = null;
      let selectedTime = null;
      let selectedRoomId = null;

      function timeFunction() {
        document.getElementById("screen-next-btn").disabled = false;
      }

      function checkContinueButton() {
        // Kiểm tra nếu cả ngày và giờ đều đã được chọn, kích hoạt nút "Continue"
        if (selectedDate && selectedTime) {
          document.getElementById("screen-next-btn").disabled = false;
        } else {
          document.getElementById("screen-next-btn").disabled = true;
        }
      }

      window.onload = function() {
        // Tự động chọn ngày đầu tiên trong danh sách khi trang được tải
        const firstButton = document.querySelector('.carousel-cell'); // Lấy button đầu tiên trong danh sách
        if (firstButton) {
          const id = firstButton.id; // Lấy ID của button đầu tiên
          const date = firstButton.querySelector('.date-numeric').innerText; // Lấy giá trị ngày từ button
          myFunction(id, date); // Gọi hàm myFunction với ID và ngày đó
        }
      };

      function myFunction(id, date) {
        // Thay đổi màu nền của ngày đã chọn
        if (prevId !== null) {
          document.getElementById(prevId).style.background = "rgb(243, 235, 235)";
        }
        document.getElementById(id).style.background = "#df0e62";
        prevId = id;

        selectedDate = date; // Lưu ngày đã chọn
        checkContinueButton(); // Kiểm tra lại trạng thái nút "Continue"

        var form = document.createElement("form");
        form.method = "GET";
        form.action = "/showrooms"; // Đảm bảo rằng URL trùng với đường dẫn API của bạn

        // Thêm tham số vào form
        var movieIdInput = document.createElement("input");
        movieIdInput.type = "hidden";
        movieIdInput.name = "movie_id"; // Tên tham số phải trùng với @RequestParam trong Controller
        movieIdInput.value = document.querySelector('[data-movie-id]').getAttribute('data-movie-id'); // Lấy movie_id từ thuộc tính data của nút
        form.appendChild(movieIdInput);

        var dateInput = document.createElement("input");
        dateInput.type = "hidden";
        dateInput.name = "show_date"; // Tên tham số phải trùng với @RequestParam trong Controller
        dateInput.value = date;
        form.appendChild(dateInput);

        // Gửi form qua fetch
        fetch(form.action + "?" + new URLSearchParams(new FormData(form)).toString())
                .then(response => response.json()) // Giả sử API trả về dữ liệu JSON
                .then(data => {
                  if (data && data.length > 0) {
                    // Cập nhật nội dung phòng và thời gian chiếu
                    var timeUl = document.querySelector(".time-ul");
                    timeUl.innerHTML = ""; // Xóa nội dung cũ

                    // Lặp qua các dữ liệu showtime để tạo danh sách phòng chiếu và thời gian chiếu
                    let screens = {}; // Để nhóm thời gian chiếu theo phòng

                    data.forEach(showtime => {
                      const roomId = showtime.room_id;
                      const startTime = showtime.start_time;

                      // Tạo cấu trúc nhóm theo phòng
                      if (!screens[roomId]) {
                        screens[roomId] = [];
                      }
                      screens[roomId].push(startTime);
                    });

                    // Tạo phần tử li cho mỗi phòng chiếu và thời gian chiếu
                    for (const roomId in screens) {
                      let screenLi = document.createElement("li");
                      screenLi.classList.add("time-li");

                      // Tạo phần tử cho tên phòng
                      let screenDiv = document.createElement("div");
                      screenDiv.classList.add("screens");
                      screenDiv.innerText = "Screen " + roomId;
                      screenLi.appendChild(screenDiv);

                      // Tạo phần tử cho danh sách thời gian chiếu
                      let timeBtnDiv = document.createElement("div");
                      timeBtnDiv.classList.add("time-btn");

                      screens[roomId].forEach(time => {
                        let button = document.createElement("button");
                        button.classList.add("screen-time");
                        button.innerText = time;
                        button.onclick = function() {
                          timeFunction(); // Hàm bạn cần để xử lý khi chọn thời gian
                        };
                        timeBtnDiv.appendChild(button);
                      });

                      screenLi.appendChild(timeBtnDiv);
                      timeUl.appendChild(screenLi);
                    }
                  }
                })
                .catch(error => {
                  console.error('Error fetching showtimes:', error);
                });
      }

      function continueBooking() {
        const movieId = document.querySelector('[data-movie-id]').getAttribute('data-movie-id'); // Lấy movie_id
        const selectedRoom = document.querySelector('.screens.selected').getAttribute('data-room-id'); // Lấy room_id từ phòng được chọn
        const selectedTime = document.querySelector('.screen-time.selected').innerText; // Lấy start_time từ thời gian được chọn

        // Xây dựng URL với các tham số
        const url = `/seat?movie_id=${movieId}&room_id=${selectedRoom}&start_time=${selectedTime}`;
        window.location.href = url; // Điều hướng tới API
      }

    </script>

<script src="assets/js/easyResponsiveTabs.js"></script>

    <script src="https://npmcdn.com/flickity@2/dist/flickity.pkgd.js"></script>
    <script type="text/javascript" src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js'>
    </script>
    <script type="text/javascript" src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    <script src="assets/js/theme-change.js"></script>

    <script type="text/javascript" src="assets/js/ticket-booking.js"></script>

</html>