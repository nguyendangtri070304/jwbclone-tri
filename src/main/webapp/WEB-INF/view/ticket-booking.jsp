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
                      src=""></iframe>
            </div>
            <br>
            <input type="button" name="next-step" class="next-step" value="Proceed to Payment" id ="proceed-button" />
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

                        <div class="payment-row">
                          <div class="col-50">
                            <label for="fname">Your Name</label>
                            <input type="text" id="fname" name="fname" placeholder="Firstname Lastname"
                                   required />
                          </div>
                          <div class="col-50">
                            <label for="pnum">Phone number</label>
                            <input type="text" id="pnum" name="pnum" placeholder="xxxx-xxx-xxxx"
                                   required />
                          </div>
                        </div>
                        <div class="payment-row">
                          <div class="col-50">
                            <label for="email">Email</label>
                            <input type="text" id="email" name="email" placeholder="example@gmail.com" required />
                          </div>
                          <div class="col-50">

                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <input type="button" name="next-step" class="next-step pay-btn" value="Confirm Information" onclick="submitPayment()"/>
            <input type="button" name="previous-step" class="cancel-pay-btn" value="Cancel"
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
                      <td class="bigger">${room_id}</td>
                      <td class="bigger">${seat_row}</td>
                      <td class="bigger">${seat_column}</td>
                    </tr>
                  </table>
                  <table class="info-table ticket-table">
                    <tr>
                      <th>PRICE</th>
                      <th>DATE</th>
                      <th>TIME</th>
                    </tr>
                    <tr>
                      <td>${ticket_price}</td>
                      <td>${show_date}</td>
                      <td>${start_time}</td>
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
  let selectedDate = null;
  let selectedTime = null;
  let selectedRoomId = null;

  window.onload = function () {
    document.getElementById("screen-next-btn").disabled = true;

    // Tự động chọn ngày đầu tiên trong danh sách
    const firstButton = document.querySelector('.carousel-cell');
    if (firstButton) {
      const id = firstButton.id;
      const date = firstButton.querySelector('.date-numeric').innerText;
      myFunction(id, date);
    }
  };

  function myFunction(id, date) {
    // Thay đổi màu nền của ngày đã chọn
    if (prevId !== null) {
      document.getElementById(prevId).style.background = "rgb(243, 235, 235)";
    }
    document.getElementById(id).style.background = "#df0e62";
    prevId = id;

    selectedDate = date;
    selectedTime = "";
    checkContinueButton();

    const form = document.createElement("form");
    form.method = "GET";
    form.action = "/showrooms";

    const movieIdInput = document.createElement("input");
    movieIdInput.type = "hidden";
    movieIdInput.name = "movie_id";
    movieIdInput.value = document.querySelector('[data-movie-id]').getAttribute('data-movie-id');
    form.appendChild(movieIdInput);

    const dateInput = document.createElement("input");
    dateInput.type = "hidden";
    dateInput.name = "show_date";
    dateInput.value = date;
    form.appendChild(dateInput);

    fetch(form.action + "?" + new URLSearchParams(new FormData(form)).toString())
            .then(response => response.json())
            .then(data => {
              const timeUl = document.querySelector(".time-ul");
              timeUl.innerHTML = ""; // Xóa nội dung cũ

              let screens = {};
              data.forEach(showtime => {
                const roomId = showtime.room_id;
                const startTime = showtime.start_time;

                if (!screens[roomId]) {
                  screens[roomId] = [];
                }
                screens[roomId].push(startTime);
              });

              for (const roomId in screens) {
                let screenLi = document.createElement("li");
                screenLi.classList.add("time-li");

                let screenDiv = document.createElement("div");
                screenDiv.classList.add("screens");
                screenDiv.innerText = "Screen " + roomId;
                screenLi.appendChild(screenDiv);

                let timeBtnDiv = document.createElement("div");
                timeBtnDiv.classList.add("time-btn");

                screens[roomId].forEach(time => {
                  let button = document.createElement("button");
                  button.classList.add("screen-time");
                  button.innerText = time;

                  button.onclick = function () {
                    timeFunction(roomId, time);
                    document.querySelectorAll('.screen-time').forEach(btn => btn.classList.remove('selected'));
                    button.classList.add('selected');
                  };

                  timeBtnDiv.appendChild(button);
                });

                screenLi.appendChild(timeBtnDiv);
                timeUl.appendChild(screenLi);
              }
            })
            .catch(error => {
              console.error('Error fetching showtimes:', error);
            });
  }

  function timeFunction(roomId, startTime) {
    selectedRoomId = roomId;
    selectedTime = startTime;
    checkContinueButton();
  }

  function checkContinueButton() {
    document.getElementById("screen-next-btn").disabled = !(selectedDate && selectedRoomId && selectedTime);
  }

  function continueBooking() {
    const movie_id = document.querySelector('[data-movie-id]').getAttribute('data-movie-id');
    const room_id = selectedRoomId;
    const start_time = selectedTime;

    // Kiểm tra các giá trị để đảm bảo không trống
    if (!movie_id || !room_id || !start_time) {
      alert("Please select a date, room, and start time before continuing!");
      return;
    }

    console.log("movie_id: ", movie_id);
    console.log("room id: ", room_id);
    console.log("start time: ", start_time);

    // Tạo URL và gửi request
    const url = '/seat?movie_id=' +  movie_id + '&room_id=' + room_id + '&start_time=' + start_time;
    console.log("Requesting URL:", url);

    const iframe = document.getElementById('seat-sel-iframe');
    iframe.src = url;
  }

  // Lắng nghe sự kiện click vào nút "Proceed to Payment"
  document.getElementById("proceed-button").addEventListener("click", function() {
    const iframe = document.getElementById("seat-sel-iframe");

    // Kiểm tra xem iframe có nội dung không
    if (iframe && iframe.contentWindow) {
      // Lấy dữ liệu từ iframe thông qua postMessage
      iframe.contentWindow.postMessage({ action: 'getSelectedSeats' }, '*');
    }
  });

  // Lắng nghe dữ liệu từ iframe
  window.addEventListener('message', function(event) {
    // Kiểm tra nguồn gửi dữ liệu để đảm bảo an toàn
    // if (event.origin === 'https://your-iframe-source.com') {
    const data = event.data;
    if (data.selectedSeats && data.totalPrice !== undefined) {
      // Gửi dữ liệu lên backend (Spring Boot controller)
      fetch('/your-controller-endpoint', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          selectedSeats: data.selectedSeats,
          totalPrice: data.totalPrice,
          room_id: data.room_id,
          //show_date: data.show_date,
          //start_time: data.start_time
        })
      })
              .then(response => response.json())
              .then(result => {
                console.log('Success:', result);
              })
              .catch(error => {
                console.error('Error:', error);
              });
    }
  });


</script>

<script>
  function submitPayment() {
    // Thu thập dữ liệu từ các trường nhập liệu
    const name = document.getElementById("fname").value;
    const phone = document.getElementById("pnum").value;
    const email = document.getElementById("email").value;

    // Kiểm tra dữ liệu nhập vào
    if (!name || !phone || !email) {
      alert("Please fill out all fields.");
      return;
    }


    const data = {
      name,
      phone,
      email,
    };

    // Gửi yêu cầu POST đến endpoint /booking
    fetch('/booking', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    })
            .then(response => {
              if (response.ok) {
                alert("Payment confirmed. Details sent to /booking.");
              } else {
                alert("Failed to confirm payment. Please try again.");
              }
            })
            .catch(error => {
              console.error('Error:', error);
              alert("An error occurred. Please try again.");
            });
  }
</script>

<script type="text/javascript" src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<script src="assets/js/easyResponsiveTabs.js"></script>
<script src="https://npmcdn.com/flickity@2/dist/flickity.pkgd.js"></script>
<script type="text/javascript" src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js'>
</script>
<script src="assets/js/theme-change.js"></script>
<script type="text/javascript" src="assets/js/ticket-booking.js"></script>

</html>