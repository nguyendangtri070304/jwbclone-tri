-- CREATE SCHEMA `moviebooking_data` ;
USE moviebooking_data;
-- Tạo bảng tblcustomers (Người dùng)
CREATE TABLE tblcustomers (
    customer_id BIGINT AUTO_INCREMENT UNIQUE PRIMARY KEY,
    customer_name VARCHAR(100) NOT NULL,
    customer_email VARCHAR(100) NOT NULL UNIQUE,
    customer_password VARCHAR(255) NOT NULL,
    customer_phone VARCHAR(15) DEFAULT '0',
    customer_date_of_birth DATE,
    customer_gender ENUM('Male', 'Female', 'Other', 'Undetermined') DEFAULT 'Undetermined',
    customer_created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    customer_is_active TINYINT DEFAULT '1'
);

DELIMITER $$
CREATE TRIGGER before_insert_tblcustomers
BEFORE INSERT ON tblcustomers
FOR EACH ROW
BEGIN
    IF NEW.customer_date_of_birth IS NULL THEN
        SET NEW.customer_date_of_birth = CURRENT_DATE();
    END IF;
END$$
DELIMITER ;

-- Thêm 20 bản ghi cho bảng tblcustomers
INSERT INTO tblcustomers (customer_name, customer_email, customer_password, customer_phone, customer_date_of_birth, customer_gender)
VALUES
('Nguyen Van A', 'nguyenvana@example.com', md5('password123'), '0123456789', '1985-01-01', 'Male'),
('Tran Thi B', 'tranthib@example.com', md5('password123'), '0123456790', '1990-02-02', 'Female'),
('Le Van C', 'levanc@example.com', md5('password123'), '0123456791', '1995-03-03', 'Male'),
('Pham Thi D', 'phamthid@example.com', md5('password123'), '0123456792', '1980-04-04', 'Female'),
('Hoang Van E', 'hoangvane@example.com', md5('password123'), '0123456793', '1988-05-05', 'Male'),
('Vo Thi F', 'vothif@example.com', md5('password123'), '0123456794', '1992-06-06', 'Female'),
('Ngo Van G', 'ngovang@example.com', md5('password123'), '0123456795', '1986-07-07', 'Male'),
('Dao Thi H', 'daothih@example.com', md5('password123'), '0123456796', '1994-08-08', 'Female'),
('Ho Van I', 'hovani@example.com', md5('password123'), '0123456797', '1987-09-09', 'Male'),
('Ly Thi J', 'lythij@example.com', md5('password123'), '0123456798', '1991-10-10', 'Female'),
('Tran Van K', 'tranvank@example.com', md5('password123'), '0123456799', '1983-11-11', 'Male'),
('Ngo Thi L', 'ngothil@example.com', md5('password123'), '0123456800', '1989-12-12', 'Female'),
('Bui Van M', 'buivanm@example.com', md5('password123'), '0123456801', '1981-01-13', 'Male'),
('Pham Thi N', 'phamthin@example.com', md5('password123'), '0123456802', '1993-02-14', 'Female'),
('Vu Van O', 'vuvano@example.com', md5('password123'), '0123456803', '1984-03-15', 'Male'),
('Do Thi P', 'dothip@example.com', md5('password123'), '0123456804', '1996-04-16', 'Female'),
('Nguyen Van Q', 'nguyenvanq@example.com', md5('password123'), '0123456805', '1982-05-17', 'Male'),
('Tran Thi R', 'tranthir@example.com', md5('password123'), '0123456806', '1997-06-18', 'Female'),
('Le Van S', 'levans@example.com', md5('password123'), '0123456807', '1986-07-19', 'Male'),
(N'Nguyễn Tiến Hội', 'hoinguyen@gmail.com', md5('123456'), '0123456807', '1986-07-19', 'Male'),
('Vo Thi T', 'vothit@example.com', md5('password123'), '0123456808', '1998-08-20', 'Female');

CREATE TABLE tbladmins (
    admin_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    admin_name VARCHAR(100) NOT NULL,
    admin_email VARCHAR(100) NOT NULL UNIQUE,
    admin_password VARCHAR(255) NOT NULL,
    admin_phone VARCHAR(15) DEFAULT '0',
    admins_created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    admins_is_active TINYINT DEFAULT 1
);

-- Thêm 20 bản ghi cho bảng tbladmins
INSERT INTO tbladmins (admin_name, admin_email, admin_password, admin_phone)
VALUES
('Admin One', 'adminone@example.com', md5('adminpass123'), '0123456789'),
('Admin Two', 'admintwo@example.com', md5('adminpass123'), '0123456790'),
('Admin Three', 'adminthree@example.com', md5('adminpass123'), '0123456791'),
('Admin Four', 'adminfour@example.com', md5('adminpass123'), '0123456792'),
('Admin Five', 'adminfive@example.com', md5('adminpass123'), '0123456793'),
('Admin Six', 'adminsix@example.com', md5('adminpass123'), '0123456794'),
('Admin Seven', 'adminseven@example.com', md5('adminpass123'), '0123456795'),
('Admin Eight', 'admineight@example.com', md5('adminpass123'), '0123456796'),
('Admin Nine', 'adminnine@example.com', md5('adminpass123'), '0123456797'),
('Admin Ten', 'adminten@example.com', md5('adminpass123'), '0123456798'),
('Admin Eleven', 'admineleven@example.com', md5('adminpass123'), '0123456799'),
('Admin Twelve', 'admintwelve@example.com', md5('adminpass123'), '0123456800'),
('Admin Thirteen', 'adminthirteen@example.com', md5('adminpass123'), '0123456801'),
('Admin Fourteen', 'adminfourteen@example.com', md5('adminpass123'), '0123456802'),
('Admin Fifteen', 'adminfifteen@example.com', md5('adminpass123'), '0123456803'),
('Admin Sixteen', 'adminsixteen@example.com', md5('adminpass123'), '0123456804'),
('Admin Seventeen', 'adminseventeen@example.com', md5('adminpass123'), '0123456805'),
('Admin Eighteen', 'admineighteen@example.com', md5('adminpass123'), '0123456806'),
('Admin Nineteen', 'adminnineteen@example.com', md5('adminpass123'), '0123456807'),
('hoinguyenAdmin', 'hoi@gmail.com', md5('123456'), '0889452997'),
('Hoi Nguyen', 'admin@gmail.com', md5('123456'), '0123456807'),
('Admin Twenty', 'admintwenty@example.com', md5('adminpass123'), '0123456808');

-- Tạo bảng tblmovies (Phim)
CREATE TABLE tblmovies (
    movie_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    movie_title VARCHAR(255) NOT NULL,
    movie_description TEXT,
	movie_rating DECIMAL(3,2) CHECK (movie_Rating BETWEEN 0 AND 10),
    movie_duration INT,  -- Thời gian phim tính bằng phút
    movie_trailer_url TEXT,
    movie_release_date DATE,
    movie_created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    movie_main_actor TEXT,
    movie_director VARCHAR(100),
    movie_studio VARCHAR(100),
    movie_country VARCHAR(100),
    movie_genre VARCHAR(100),
    movie_for_age INT,
    movie_poster_url VARCHAR(255)
);

-- Thêm 20 bản ghi cho bảng tblmovies
INSERT INTO tblmovies 
(movie_title, movie_description, movie_rating, movie_duration, movie_trailer_url, movie_release_date, movie_main_actor, movie_director, movie_studio, movie_country, movie_genre, movie_for_age, movie_poster_url)
VALUES
('Avengers: Endgame',	 	'The Avengers assemble to defeat Thanos.',8.8, 181, 'TcMBFSGVi1c', '2010-07-16', 'Leonardo DiCaprio', 'Christopher Nolan', 'Warner Bros.', 'USA', 'Sci-Fi', 13, 'EndGame-slide.jpg'),
('Frozen II', 				'Elsa and Anna’s journey to uncover the secrets of their past.',6.6, 103, 'xJgAypHXCZo', '2013-11-27', 'Kristen Bell', 'Chris Buck', 'Walt Disney Animation Studios', 'USA', 'Animation', 0, 'Frozen-slide.jpg'),
('Joker', 					'A story about the man who became the Joker.',3.5, 122, 'zAGVQLHvwOY', '1993-12-15', 'Liam Neeson', 'Steven Spielberg', 'Universal Pictures', 'USA', 'Biography', 16, 'Joker-slide.jpg'),
('Aladin',					'Aladdin, a kind thief, woos Jasmine, the princess of Agrabah, with the help of Genie. When Jafar, the grand vizier, tries to usurp the king, Jasmine, Aladdin and Genie must stop him from succeeding.',9.4, 100, '2PlfNBihinw', '2000-05-05', 'Russell Crowe', 'Ridley Scott', 'DreamWorks', 'USA', 'Action', 16, 'Aladin-slide.jpg'),
('The Lion King',		 	'The adventure of Simba, a lion cub.',8.7, 118, 'lMXh6vjiZrI', '1999-03-31', 'Keanu Reeves', 'The Wachowskis', 'Warner Bros.', 'USA', 'Action', 16, 'TheLionKing-slide.png'),
('Thor',				 	'Thor, the god of thunder, must prove himself worthy to wield his magical hammer.',2.5, 115, 'Go8nTmfrQd8', '2014-11-07', 'Matthew McConaughey', 'Christopher Nolan', 'Paramount Pictures', 'USA', 'Sci-Fi', 13, 'thor-slide.png'),
('Captain Marvel',		 	'Carol Danvers becomes Captain Marvel to fight against a galactic war.',9.0, 123, '1pHDWnXmK7Y', '2009-12-18', 'Sam Worthington', 'James Cameron', '20th Century Fox', 'USA', 'Adventure', 13, 'CaptainMarvel-slide.png'),
('The Avengers',		 	'A team of superheroes assemble to save Earth from Loki.',9.9, 143, '6ZfuNTqbHE8', '2008-07-18', 'Christian Bale', 'Christopher Nolan', 'Warner Bros.', 'USA', 'Action', 13, 'TheAvengers-slide.png'),
('Deadpool',			 	'A former soldier becomes the mercenary known as Deadpool.',9.9, 108, '73_1biulkYk', '1997-12-19', 'Leonardo DiCaprio', 'James Cameron', '20th Century Fox', 'USA', 'Drama', 13, 'DeadpoolDiscordBanner-slide.png'),
('Wonder Woman',		 	'Diana, an Amazonian princess, becomes Wonder Woman to fight for justice.',2.4, 141, '1Q8fG0TtVAY', '1993-06-11', 'Sam Neill', 'Steven Spielberg', 'Universal Pictures', 'USA', 'Adventure', 13, 'WonderWoman-slide.png'),
('Shazam',				 	'A boy can turn into an adult superhero by saying the word "Shazam".',6.8, 132, 'go6GEIrcvFY', '1994-06-24', 'Matthew Broderick', 'Roger Allers', 'Walt Disney', 'USA', 'Animation', 0, 'Shazam-slide.png'),
('Doctor Strange',		 	'A former surgeon becomes the Sorcerer Supreme to protect the Earth.',2.5, 115, 'HSzx-zryEgM', '1972-03-24', 'Marlon Brando', 'Francis Ford Coppola', 'Paramount Pictures', 'USA', 'Crime', 16, 'DoctorStrange-slide.png'),
('Guardians of the Galaxy', 'A group of misfits must work together to save the universe.',5.5, 121, 'u3V5KDHRQvk', '1994-10-14', 'Tim Robbins', 'Frank Darabont', 'Columbia Pictures', 'USA', 'Drama', 16, 'GuardiansoftheGalaxy-slide.png'),
('The Matrix',				'A hacker learns that the world is controlled by machines.',9.9, 136, '9ix7TUGVYIo', '1994-07-06', 'Tom Hanks', 'Robert Zemeckis', 'Paramount Pictures', 'USA', 'Drama', 13, 'TheMatrix-slide.png'),
('The Dark Knight',			'Batman faces off against the Joker in Gotham City.', 2.5, 152, 'EXeTwQWrcwY', '1998-07-24', 'Tom Hanks', 'Steven Spielberg', 'DreamWorks', 'USA', 'War', 16, 'TheDarkKnight-slide.png'),
('Batman v Superman',		'Batman and Superman battle each other over their differences.',3.5, 151, '0WWzgGyAH6Y', '1995-05-24', 'Mel Gibson', 'Mel Gibson', 'Paramount Pictures', 'USA', 'History', 16, 'BatmanvsSuperman-slide.png'),
('Inception', 				'A skilled thief is tasked with planting an idea in someone’s mind.',1.5, 148, 'y2TCjYiTGIo', '1999-10-15', 'Brad Pitt', 'David Fincher', '20th Century Fox', 'USA', 'Drama', 18, 'Inception-slide.png'),
('Interstellar', 			'A team of astronauts travels through a wormhole to save humanity.',5.5, 169, 'zSWdZVtXT7E', '1999-12-10', 'Tom Hanks', 'Frank Darabont', 'Warner Bros.', 'USA', 'Crime', 16, 'Interstellar-slide.png'),
('Titanic', 				'A love story set aboard the doomed Titanic ship.',7.7, 195, 'kVrqfYjkTdQ', '2022-12-16', 'Sam Worthington', 'James Cameron', '20th Century Studios', 'USA', 'Sci-Fi', 13, 'Titanic-slide.png'),
('Avatar', 					'A paraplegic Marine on an alien planet helps the Na’vi people fight back.',3.3, 162, '7B_QyEpeEAQ', '2012-05-04', 'Robert Downey Jr.', 'Joss Whedon', 'Marvel Studios', 'USA', 'Action', 13, 'avatar-slide.png');


-- Tạo bảng tblrooms (Phòng chiếu)
CREATE TABLE tblrooms (
    room_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    room_name VARCHAR(50) NOT NULL,  -- Tên phòng chiếu (Screen 1, Screen 2, v.v.)
    room_capacity INT NOT NULL,  -- Số ghế trong phòng
    room_location VARCHAR(255),
    room_screen_type ENUM('2D', '3D', 'IMAX', '4DX'),
    room_sound_system VARCHAR(100),
    room_created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Thêm 20 bản ghi cho bảng tblrooms
INSERT INTO tblrooms (room_name, room_capacity, room_screen_type, room_sound_system)
VALUES
('Screen 1', 150, 'IMAX', 'Dolby Atmos'),
('Screen 2', 100, '4DX', 'THX'),
('Screen 3', 200, '3D', 'Dolby Digital'),
('Screen 4', 120, '2D', 'DTS:X'),
('Screen 5', 180, 'IMAX', 'Auro 11.1'),
('Screen 6', 130, '3D', 'Dolby Atmos'),
('Screen 7', 160, '4DX', 'IMAX 12-channel'),
('Screen 8', 140, '2D', 'Sony Dynamic Digital Sound'),
('Screen 9', 110, '3D', 'THX'),
('Screen 10', 170, 'IMAX', 'Dolby Digital'),
('Screen 11', 150, '4DX', 'Dolby Atmos'),
('Screen 12', 90, '2D', 'Auro 11.1'),
('Screen 13', 200, '3D', 'DTS:X'),
('Screen 14', 130, 'IMAX', 'THX'),
('Screen 15', 120, '4DX', 'Sony Dynamic Digital Sound'),
('Screen 16', 140, '2D', 'Dolby Digital'),
('Screen 17', 160, '3D', 'IMAX 12-channel'),
('Screen 18', 180, 'IMAX', 'Dolby Atmos'),
('Screen 19', 100, '2D', 'THX'),
('Screen 20', 190, '3D', 'DTS:X');

-- Tạo bảng tblseats (Ghế ngồi)
CREATE TABLE tblseats (
    seat_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    room_id BIGINT NOT NULL,
    seat_row CHAR(3) NOT NULL, -- R1, R2, ..., R10
    seat_column CHAR(3) NOT NULL, -- S1, S2, ..., S10
    seat_type ENUM('Standard', 'Premium', 'VIP'),
    seat_status ENUM('available', 'reserved', 'booked') DEFAULT 'available',
    FOREIGN KEY (room_id) REFERENCES tblrooms(room_id) ON DELETE CASCADE
);

-- Thêm dữ liệu mẫu cho bảng tblseats
INSERT INTO tblseats (room_id, seat_row, seat_column, seat_type, seat_status)
VALUES
(1, 'R1', 'S1', 'Standard', 'available'),
(1, 'R1', 'S2', 'Standard', 'available'),
(1, 'R2', 'S1', 'Premium', 'reserved'),
(1, 'R2', 'S2', 'Premium', 'booked'),
(2, 'R1', 'S1', 'VIP', 'available'),
(2, 'R1', 'S2', 'VIP', 'available'),
(2, 'R2', 'S1', 'Standard', 'reserved'),
(2, 'R2', 'S2', 'Standard', 'booked'),
(3, 'R1', 'S1', 'Premium', 'available'),
(3, 'R1', 'S2', 'Premium', 'available'),
(3, 'R2', 'S1', 'VIP', 'reserved'),
(3, 'R2', 'S2', 'VIP', 'booked'),
(4, 'R1', 'S1', 'Standard', 'available'),
(4, 'R1', 'S2', 'Standard', 'available'),
(4, 'R2', 'S1', 'Premium', 'reserved'),
(4, 'R2', 'S2', 'Premium', 'booked'),
(5, 'R1', 'S1', 'VIP', 'available'),
(5, 'R1', 'S2', 'VIP', 'available'),
(5, 'R2', 'S1', 'Standard', 'reserved'),
(5, 'R2', 'S2', 'Standard', 'booked');

-- Tạo bảng tblshowtimes (Lịch chiếu)
CREATE TABLE tblshowtimes (
    showtime_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    movie_id BIGINT NOT NULL,
    room_id BIGINT NOT NULL,
    show_date DATE NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    ticket_price DECIMAL(10, 2) NOT NULL,  -- Giá vé cho buổi chiếu
    showtime_created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    showtime_updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (movie_id) REFERENCES tblmovies(movie_id) ON DELETE CASCADE,
    FOREIGN KEY (room_id) REFERENCES tblrooms(room_id) ON DELETE CASCADE
);

-- Thêm 20 bản ghi cho bảng tblshowtimes
INSERT INTO tblshowtimes (movie_id, room_id, show_date, start_time, end_time, ticket_price)
VALUES
(1, 1, '2024-12-01', '18:00:00', '20:30:00', 150000),
(1, 2, '2024-12-01', '21:00:00', '23:30:00', 150000),
(2, 1, '2024-12-02', '14:00:00', '16:10:00', 120000),
(2, 2, '2024-12-02', '16:30:00', '18:40:00', 120000),
(3, 3, '2024-12-03', '10:00:00', '13:00:00', 180000),
(3, 4, '2024-12-03', '13:30:00', '16:30:00', 180000),
(4, 5, '2024-12-04', '19:00:00', '21:42:00', 150000),
(4, 6, '2024-12-04', '22:00:00', '00:42:00', 150000),
(5, 7, '2024-12-05', '17:00:00', '19:32:00', 150000),
(5, 8, '2024-12-05', '20:00:00', '22:32:00', 150000),
(6, 9, '2024-12-06', '09:00:00', '12:15:00', 200000),
(6, 10, '2024-12-06', '12:45:00', '16:00:00', 200000),
(7, 11, '2024-12-07', '14:00:00', '16:07:00', 120000),
(7, 12, '2024-12-07', '16:30:00', '18:37:00', 120000),
(8, 13, '2024-12-08', '13:00:00', '14:58:00', 100000),
(8, 14, '2024-12-08', '15:30:00', '17:28:00', 100000),
(9, 15, '2024-12-09', '18:00:00', '20:55:00', 180000),
(9, 16, '2024-12-09', '21:30:00', '00:25:00', 180000),
(10, 17, '2024-12-10', '11:00:00', '13:30:00', 150000),
(10, 18, '2024-12-10', '14:00:00', '16:30:00', 150000);


-- Tạo bảng tblbookings (Đặt vé)
CREATE TABLE tblbookings (
    booking_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    showtime_id BIGINT NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,  -- Tổng giá vé
    booking_created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES tblcustomers(customer_id) ON DELETE CASCADE,
    FOREIGN KEY (showtime_id) REFERENCES tblshowtimes(showtime_id) ON DELETE CASCADE
);

-- Thêm 20 bản ghi cho bảng tblbookings
INSERT INTO tblbookings (customer_id, showtime_id, total_price)
VALUES
(1, 1, 150000.00),
(2, 2, 150000.00),
(3, 3, 120000.00),
(4, 4, 120000.00),
(5, 5, 150000.00),
(6, 6, 150000.00),
(7, 7, 120000.00),
(8, 8, 120000.00),
(9, 9, 150000.00),
(10, 10, 150000.00),
(11, 11, 200000.00),
(12, 12, 200000.00),
(13, 13, 120000.00),
(14, 14, 120000.00),
(15, 15, 100000.00),
(16, 16, 100000.00),
(17, 17, 180000.00),
(18, 18, 180000.00),
(19, 19, 150000.00),
(20, 20, 150000.00);


-- Tạo bảng tblbooking_seats (Ghế đã chọn trong vé)
CREATE TABLE tblbooking_seats (
    booking_seat_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    booking_id BIGINT NOT NULL,
    seat_id BIGINT NOT NULL,
    FOREIGN KEY (booking_id) REFERENCES tblbookings(booking_id) ON DELETE CASCADE,
    FOREIGN KEY (seat_id) REFERENCES tblseats(seat_id) ON DELETE CASCADE
);

-- Thêm 20 bản ghi cho bảng tblbooking_seats
INSERT INTO tblbooking_seats (booking_id, seat_id)
VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 5),
(3, 6),
(4, 7),
(4, 8),
(5, 9),
(5, 10),
(6, 11),
(6, 12),
(7, 13),
(7, 14),
(8, 15),
(8, 16),
(9, 17),
(9, 18),
(10, 19),
(10, 20);

CREATE TABLE promotions (
    promotion_id INT PRIMARY KEY AUTO_INCREMENT,
    promotion_name VARCHAR(100),
    promotion_discount_percentage DECIMAL(5,2) CHECK (promotion_discount_percentage BETWEEN 0 AND 100),
    promotion_start_date DATE,
    promotion_end_date DATE,
    promotion_conditions TEXT,
    promotion_description TEXT
);

 -- nhâp 20 dữ liệu cho bảng
INSERT INTO Promotions (promotion_name, promotion_discount_percentage, promotion_start_date, promotion_end_date, promotion_conditions, promotion_description)
VALUES
('Summer Sale', 20.00, '2024-06-01', '2024-06-30', 'Applicable to all movies', 'Enjoy 20% off on all movies during summer'),
('Christmas Special', 30.00, '2024-12-20', '2024-12-25', 'Applicable to selected movies', 'Celebrate Christmas with 30% off on selected movies'),
('New Year Blast', 25.00, '2024-12-31', '2025-01-01', 'All day discount', 'Ring in the new year with 25% off on all tickets'),
('Student Discount', 15.00, '2024-09-01', '2024-09-30', 'Valid student ID required', 'Special 15% discount for students'),
('Weekend Offer', 10.00, '2024-11-01', '2024-11-30', 'Only on weekends', 'Enjoy your weekends with a 10% discount on all movies'),
('Early Bird', 20.00, '2024-10-01', '2024-10-31', 'Before 12 PM', 'Get 20% off on tickets for shows before noon'),
('Loyalty Bonus', 15.00, '2024-08-01', '2024-08-31', 'For loyalty card holders', 'Exclusive 15% discount for our loyal customers'),
('Halloween Spooktacular', 25.00, '2024-10-25', '2024-10-31', 'Applicable to horror movies', 'Get spooked with 25% off on all horror movies'),
('Family Fun', 20.00, '2024-07-01', '2024-07-31', 'Minimum purchase of 4 tickets', 'Enjoy family time with 20% off when buying 4 or more tickets'),
('Anniversary Special', 30.00, '2024-04-01', '2024-04-10', 'Applicable to all movies', 'Celebrate our anniversary with a 30% discount on all movies'),
('Valentine\'s Day', 20.00, '2025-02-14', '2025-02-14', 'Applicable to romantic movies', 'Celebrate love with 20% off on romantic movies'),
('Back to School', 15.00, '2024-09-01', '2024-09-10', 'Applicable to all movies', 'Kick off the new school year with a 15% discount'),
('Black Friday', 50.00, '2024-11-29', '2024-11-29', 'Only on Black Friday', 'Get an amazing 50% off on Black Friday'),
('Cyber Monday', 40.00, '2024-12-02', '2024-12-02', 'Only on Cyber Monday', 'Enjoy 40% off on Cyber Monday'),
('Mother\'s Day Special', 25.00, '2025-05-11', '2025-05-11', 'Applicable to family movies', 'Celebrate Mother\'s Day with a 25% discount'),
('Father\'s Day Treat', 25.00, '2025-06-15', '2025-06-15', 'Applicable to family movies', 'Treat dad with 25% off on family movies'),
('Teacher\'s Appreciation', 20.00, '2024-10-05', '2024-10-05', 'Valid teacher ID required', 'Special 20% discount for teachers'),
('Veterans Day', 30.00, '2024-11-11', '2024-11-11', 'Applicable to all movies', 'Honoring veterans with a 30% discount'),
('Independence Day', 20.00, '2024-07-04', '2024-07-04', 'Applicable to all movies', 'Celebrate Independence Day with 20% off'),
('Spring Festival', 25.00, '2024-03-01', '2024-03-31', 'Applicable to all movies', 'Welcome spring with a 25% discount on all movies');

CREATE TABLE customer_promotions (
    customer_promotion_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    customer_id BIGINT NOT NULL,
    promotion_id INT NOT NULL,
    used BOOLEAN DEFAULT FALSE, -- Chỉ được sử dụng một lần
    FOREIGN KEY (customer_id) REFERENCES tblcustomers(customer_id) ON DELETE CASCADE,
    FOREIGN KEY (promotion_id) REFERENCES promotions(promotion_id) ON DELETE CASCADE
);
INSERT INTO customer_promotions (customer_id, promotion_id, used)
VALUES
(1, 1, FALSE),
(2, 2, FALSE),
(3, 3, FALSE),
(4, 4, FALSE),
(5, 5, FALSE),
(6, 6, FALSE),
(7, 7, FALSE),
(8, 8, FALSE),
(9, 9, FALSE),
(10, 10, FALSE),
(11, 11, FALSE),
(12, 12, FALSE),
(13, 13, FALSE),
(14, 14, FALSE),
(15, 15, FALSE),
(16, 16, FALSE),
(17, 17, FALSE),
(18, 18, FALSE),
(19, 19, FALSE),
(20, 20, FALSE);
