package com.group11.moviebooking.repository;


import com.group11.moviebooking.entity.MovieEntity;
import com.group11.moviebooking.util.ConnectionPool;
import com.group11.moviebooking.util.ConnectionPoolImpl;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.group11.moviebooking.util.AddMovieRS.addMovieRSToList;

@Repository
public class MovieRepositoryImpl extends BasicImpl implements MovieRepository {
    private final ConnectionPool connectionPool;

    public MovieRepositoryImpl() {
        super("tblmovies");
        this.connectionPool = ConnectionPoolImpl.getInstance();
    }

    @Override
    public List<MovieEntity> getMovies(MovieEntity similar, int at, byte total) {
        List<MovieEntity> movies = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM tblmovies WHERE 1=1");
        // Điều kiện lọc theo các thuộc tính không null của similar
        if (similar.getMovie_title() != null) {
            sql.append(" AND movie_title LIKE ?");
        }
        if (similar.getMovie_genre() != null) {
            sql.append(" AND movie_genre = ?");
        }
        if (similar.getMovie_director() != null) {
            sql.append(" AND movie_director LIKE ?");
        }
        if (similar.getMovie_for_age() != 0) {
            sql.append(" AND movie_for_age >= ?");
        }
        if (similar.getMovie_rating() > 0) {
            sql.append(" AND movie_rating >= ?");
        }
        sql.append(" LIMIT ?,?");
        try (Connection connection = connectionPool.getConnection("MovieRepositoryImpl.getMovies")) {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            int index = 1;
            // Gán giá trị cho các tham số truy vấn
            if (similar.getMovie_title() != null) {
                pre.setString(index++, "%" + similar.getMovie_title() + "%");
            }
            if (similar.getMovie_genre() != null) {
                pre.setString(index++, similar.getMovie_genre());
            }
            if (similar.getMovie_director() != null) {
                pre.setString(index++, "%" + similar.getMovie_director() + "%");
            }
            if (similar.getMovie_for_age() != 0) {
                pre.setInt(index++, similar.getMovie_for_age());
            }
            if (similar.getMovie_rating() > 0) {
                pre.setFloat(index++, similar.getMovie_rating());
            }
            // Thêm tham số phân trang
            pre.setInt(index++, at);
            pre.setInt(index, total);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                addMovieRSToList(rs, movies);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                this.con.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } finally {
            this.releaseConnection(); // Trả lại kết nối
        }
        return movies;
    }

    public ArrayList<MovieEntity> getMoviesByTitle(String movie_title) {
        ArrayList<MovieEntity> movies = new ArrayList<>();
        String sql = "SELECT * FROM tblmovies WHERE movie_title LIKE ?";
        try (Connection connection = connectionPool.getConnection("MovieRepositoryImpl.getMoviesByTitle")) {
            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setString(1, "%" + movie_title + "%");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                addMovieRSToList(rs, movies);
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();

            try {
                this.con.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } finally {
            this.releaseConnection(); // Trả lại kết nối
        }
        return movies;
    }

    @Override
    public List<MovieEntity> getAllMovies() {
        ArrayList<MovieEntity> movies = new ArrayList<>();
        String sql = "SELECT * FROM tblmovies";
        try (Connection connection = connectionPool.getConnection("MovieRepositoryImpl.getAllMovies"); PreparedStatement pre = this.con.prepareStatement(sql)) {
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                addMovieRSToList(rs, movies);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    @Override
    public String getMovies(int movie_id) {
        String movie_title = "";
        String sql = "SELECT movie_title FROM tblmovies WHERE movie_id = ?";
        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setInt(1, movie_id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                movie_title = rs.getString("movie_title");
            }
            return movie_title;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<MovieEntity> getAllMoviesLimit(int limit) {
        ArrayList<MovieEntity> movies = new ArrayList<>();
//        String sql = "SELECT * FROM tblmovies LIMIT ?";
        String sql = "SELECT * FROM tblmovies ORDER BY RAND() LIMIT ?";
        try (Connection connection = connectionPool.getConnection("MovieRepositoryImpl.getAllMoviesLimit" + limit); PreparedStatement pre = this.con.prepareStatement(sql)) {
            pre.setInt(1, limit);
            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    addMovieRSToList(rs, movies);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public ArrayList<MovieEntity> getLatestMovies() {
        ArrayList<MovieEntity> movies = new ArrayList<>();
        String sql = "SELECT * FROM tblmovies " + "ORDER BY movie_release_date DESC " + "LIMIT 12;";
        try (Connection connection = connectionPool.getConnection("MovieRepositoryImpl.getLatestMovies"); PreparedStatement pre = this.con.prepareStatement(sql)) {
            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    addMovieRSToList(rs, movies);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public ArrayList<MovieEntity> getTopMovieByRating() {
        ArrayList<MovieEntity> movies = new ArrayList<>();
        String sql = "SELECT * FROM tblmovies " + "ORDER BY movie_rating DESC " + "LIMIT 12;";
        try (Connection connection = connectionPool.getConnection("MovieRepositoryImpl.getTopMovieByRating"); PreparedStatement pre = this.con.prepareStatement(sql)) {
            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    addMovieRSToList(rs, movies);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public ArrayList<MovieEntity> getMoviesForAdults() {
        ArrayList<MovieEntity> movies = new ArrayList<>();
        String sql = "SELECT * FROM tblmovies " + "WHERE movie_for_age >= 18 " + "ORDER BY movie_rating DESC ";
        try (Connection connection = connectionPool.getConnection("MovieRepositoryImpl.getMoviesForAdults"); PreparedStatement pre = this.con.prepareStatement(sql)) {
            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    addMovieRSToList(rs, movies);
                }
                if (connection != null) {
                    connection.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public ArrayList<MovieEntity> getMoviesForKids() {
        ArrayList<MovieEntity> movies = new ArrayList<>();
        String sql = "SELECT * FROM tblmovies " + "WHERE movie_for_age <= 14 " + "ORDER BY movie_rating DESC ";
        try (Connection connection = connectionPool.getConnection("MovieRepositoryImpl.getMoviesForKids"); PreparedStatement pre = this.con.prepareStatement(sql)) {
            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    addMovieRSToList(rs, movies);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public ResultSet getTopSellingMovies() {
        String sql = "SELECT "
                + "m.movie_id, "
                + "m.movie_title, "
                + "m.movie_poster_url, "
                + "m.movie_description, "
                + "m.movie_main_actor, "
                + "m.movie_studio , "
                + "m.movie_release_date , "
                + "m.movie_director , "
                + "m.movie_rating , "
                + "m.movie_duration, "
                + "COUNT(b.booking_id) AS total_tickets_sold, "
                + "b.total_price AS ticket_price, "
                + "SUM(b.total_price) AS revenue "
                + "FROM "
                + "tblmovies m "
                + "JOIN "
                + "tblshowtimes s ON m.movie_id = s.movie_id "
                + "JOIN "
                + "tblbookings b ON s.showtime_id = b.showtime_id "
                + "GROUP BY " + "m.movie_id, m.movie_title, m.movie_poster_url "
                + "ORDER BY " + "total_tickets_sold DESC, revenue DESC " + "LIMIT 5;";
        try (Connection connection = connectionPool.getConnection("MovieRepositoryImpl.getTopSellingMovies"); PreparedStatement pre = this.con.prepareStatement(sql)) {
            try (ResultSet rs = pre.executeQuery()) {
                return rs;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HashMap<Object, Object> getTicketsSoldAndRevenue() {
        HashMap<Object, Object> resultMap = new HashMap<>();
        String sql = " SELECT COUNT(booking_id) AS total_tickets_sold FROM tblbookings;" + "SELECT SUM(total_price) AS total_revenue FROM tblbookings;";
        try (Connection connection = connectionPool.getConnection("MovieRepositoryImpl.getTicketsSoldAndRevenue"); PreparedStatement pre = this.con.prepareStatement(sql)) {
            boolean hasMoreResults = pre.execute();
            if (hasMoreResults) {
                ResultSet s1 = pre.getResultSet();
                try {
                    if (s1.next()) {
                        resultMap.put("total_tickets_sold", s1.getInt("total_tickets_sold"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pre.getMoreResults()) {
                ResultSet s2 = pre.getResultSet();
                try {
                    if (s2.next()) {
                        resultMap.put("total_revenue", s2.getInt("total_revenue"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    @Override
    public boolean addMovie(MovieEntity entity) {
        String sql = "INSERT INTO tblmovies (movie_title, movie_description, movie_rating, movie_duration, movie_trailer_url, movie_release_date, movie_main_actor, movie_director, movie_studio, movie_country, movie_genre, movie_for_age, movie_poster_url) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = connectionPool.getConnection("MovieRepositoryImpl.addMovie"); PreparedStatement pre = connection.prepareStatement(sql)) {
            pre.setString(1, entity.getMovie_title());
            pre.setString(2, entity.getMovie_description());
            pre.setFloat(3, entity.getMovie_rating());
            pre.setInt(4, entity.getMovie_duration());
            pre.setString(5, entity.getMovie_trailer_url());
            pre.setString(6, entity.getMovie_release_date());
            pre.setString(7, entity.getMovie_main_actor());
            pre.setString(8, entity.getMovie_director());
            pre.setString(9, entity.getMovie_studio());
            pre.setString(10, entity.getMovie_country());
            pre.setString(11, entity.getMovie_genre());
            pre.setInt(12, entity.getMovie_for_age());
            pre.setString(13, entity.getMovie_poster_url());
            return pre.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateMovie(MovieEntity entity) {
        String sql = "UPDATE tblmovies SET movie_title = ?, movie_description = ?, movie_rating = ?, movie_duration = ?, movie_trailer_url = ?, movie_release_date = ?, movie_main_actor = ?, movie_director = ?, movie_studio = ?, movie_country = ?, movie_genre = ?, movie_for_age = ?, movie_poster_url = ? WHERE movie_id = ?";
        try (Connection connection = connectionPool.getConnection("MovieRepositoryImpl.updateMovie"); PreparedStatement pre = connection.prepareStatement(sql)) {
            pre.setString(1, entity.getMovie_title());
            pre.setString(2, entity.getMovie_description());
            pre.setFloat(3, entity.getMovie_rating());
            pre.setInt(4, entity.getMovie_duration());
            pre.setString(5, entity.getMovie_trailer_url());
            pre.setString(6, entity.getMovie_release_date());
            pre.setString(7, entity.getMovie_main_actor());
            pre.setString(8, entity.getMovie_director());
            pre.setString(9, entity.getMovie_studio());
            pre.setString(10, entity.getMovie_country());
            pre.setString(11, entity.getMovie_genre());
            pre.setInt(12, entity.getMovie_for_age());
            pre.setString(13, entity.getMovie_poster_url());
            pre.setInt(14, entity.getMovie_id());
            return pre.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteMovie(int id) {
        String sql = "DELETE FROM tblmovies WHERE movie_id = ?";
        try (Connection connection = connectionPool.getConnection("MovieRepositoryImpl.deleteMovie")) {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            int rowsAffected = pre.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                this.con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return false;
    }
}