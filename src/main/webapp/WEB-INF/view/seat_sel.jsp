<!DOCTYPE html>
<html>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<head>
			<title>Movie Ticket Booking Widget Flat Responsive Widget Template :: w3layouts</title>
			<!-- Logo -->
			<link href="assets/images/logo.png" rel="icon" />
			<link href="assets/images/logo.png" rel="apple-touch-icon" />
			<!-- for-mobile-apps -->
			<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
			<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
			<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
			<meta name="keywords"
				content="Movie Ticket Booking Widget Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
			<link href="seat_selection/css/style.css" rel="stylesheet" type="text/css" media="all" />
			<script src="seat_selection/js/jquery-1.11.0.min.js"></script>
			<script src="seat_selection/js/jquery.seat-charts.js"></script>
		</head>

<body>
<div class="content">
	<h2>Seat Booking</h2>
	<div class="main">
		<div class="demo">
			<div id="seat-map">
				<div class="front">SCREEN ${room_id}</div>
			</div>
			<div class="booking-details">
				<ul class="book-left">
					<li>Movie </li>
					<li>Date </li>
					<li>Time</li>
					<li>Tickets</li>
					<li>Total</li>
					<li>Selected Seats</li>
				</ul>
				<ul class="book-right">
					<li>: Commando 3</li>
					<li>: ${show_date}</li>
					<li>: ${start_time}</li>
					<li>: <span id="counter">0</span></li>
					<li>: <b><span id="total">0<i> VND</i></span></b></li>
				</ul>
				<div class="clear"></div>
				<ul id="selected-seats" class="scrollbar scrollbar1"></ul>


				<div id="legend"></div>
			</div>

			<script type="text/javascript">
				var price = ${ticket_price}; //price
				var selectedSeats = []; // Mảng lưu các ghế đã chọn
				var room_id = ${room_id};
				var show_date = ${show_date};
				$(document).ready(function () {
					var $cart = $('#selected-seats'), //Sitting Area
							$counter = $('#counter'), //Votes
							$total = $('#total'); //Total money

					var sc = $('#seat-map').seatCharts({
						map: [ //Seating chart
							'aaaaaaaaaa',
							'aaaaaaaaaa',
							'__________',
							'aaaaaaaa__',
							'aaaaaaaaaa',
							'aaaaaaaaaa',
							'aaaaaaaaaa',
							'aaaaaaaaaa',
							'aaaaaaaaaa',
							'__aaaaaa__'
						],
						naming: {
							top: false,
							getLabel: function (character, row, column) {
								return column;
							}
						},
						legend: { //Definition legend
							node: $('#legend'),
							items: [
								['a', 'available', 'Available'],
								['a', 'unavailable', 'Sold'],
								['a', 'selected', 'Selected']
							]
						},
						click: function () { //Click event
							if (this.status() == 'available') { //optional seat
								selectedSeats.push({ row: this.settings.row + 1, column: this.settings.label });
								$('<li>R-' + (this.settings.row + 1) + '	S-' + this.settings.label + '</li>')
										.attr('id', 'cart-item-' + this.settings.id)
										.data('seatId', this.settings.id)
										.appendTo($cart);

								$counter.text(sc.find('selected').length + 1);
								$total.text(recalculateTotal(sc) + price);
								console.log("Selected seats:", selectedSeats);
								return 'selected';
							} else if (this.status() == 'selected') { //Checked
								// Loại bỏ ghế khỏi danh sách đã chọn
								selectedSeats = selectedSeats.filter(function (seat) {
									return seat.row !== (this.settings.row + 1) || seat.column !== this.settings.label;
								}.bind(this));
								//Update Number
								$counter.text(sc.find('selected').length - 1);
								//update totalnum
								$total.text(recalculateTotal(sc) - price);

								//Delete reservation
								$('#cart-item-' + this.settings.id).remove();
								//optional
								console.log("Selected seats after removal:", selectedSeats); // Log sau khi loại bỏ
								return 'available';
							} else if (this.status() == 'unavailable') { //sold
								return 'unavailable';
							} else {
								return this.style();
							}
						}
					});
					// Nhận JSON từ backend
					var soldseats = [];
					try {
						// ${soldseats} được JSP render dưới dạng chuỗi
						soldseats = JSON.parse('${soldseats}'.replace(/&quot;/g, '"'));
						console.log("Sold seats:", soldseats);
					} catch (e) {
						console.error("Lỗi khi parse JSON:", e);
					}
					// Đánh dấu ghế đã bán
					soldseats.forEach(function (seat) {
						var seatId = seat.seat_row + "_" + seat.seat_column;
						console.log("Marking seat as unavailable:", seatId); // In ra ID ghế
						sc.get([seatId]).status('unavailable');
					});
					// Lắng nghe yêu cầu từ trang cha
					window.addEventListener('message', function(event) {
						if (event.data.action === 'getSelectedSeats') {
							// Gửi dữ liệu ghế đã chọn và tổng tiền về trang cha
							event.source.postMessage({
								selectedSeats: selectedSeats,
								totalPrice: recalculateTotal(sc),
								room_id: room_id
								//show_date: show_date,
								//start_time: start_time
							}, event.origin);
						}
					});

				});

				//sum total money
				function recalculateTotal(sc) {
					var total = 0;
					sc.find('selected').each(function () {
						total += price;
					});

					return total;
				}
			</script>
		</div>
	</div>
	<script type="text/javascript" src="js/theme-change-seat-sel.js"></script>
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
</body>

</html>