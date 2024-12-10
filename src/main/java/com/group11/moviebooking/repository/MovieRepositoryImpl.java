package com.group11.moviebooking.repository;


import com.group11.moviebooking.util.MovieEntity;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.group11.moviebooking.util.AddMovieRS.addMovieRSToList;

@Repository
public class MovieRepositoryImpl extends BasicImpl implements MovieRepository {

    public MovieRepositoryImpl() {
        super("tblmovies");
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

        try {
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

    public ArrayList<MovieEntity> getMovies(String movie_title) {
        ArrayList<MovieEntity> movies = new ArrayList<>();

        String sql = "SELECT * FROM tblmovies WHERE movie_title LIKE ?";

        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
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

    public ArrayList<MovieEntity> getLatestMovies() {

        ArrayList<MovieEntity> movies = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM tblmovies ");
        sql.append("ORDER BY movie_release_date DESC ");
        sql.append("LIMIT 8;");

        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());

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

    public ArrayList<MovieEntity> getTopMovieByRating() {

        ArrayList<MovieEntity> movies = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM tblmovies ");
        sql.append("ORDER BY movie_rating DESC ");
        sql.append("LIMIT 8;");

        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());

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

    public ArrayList<MovieEntity> getMoviesForAdults() {
        ArrayList<MovieEntity> movies = new ArrayList<>();

        StringBuilder sql =  new StringBuilder();
        sql.append("SELECT * FROM tblmovies ");
        sql.append("WHERE movie_for_age >= 18 ");
        sql.append("ORDER BY movie_rating DESC ");

        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());

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

    public ArrayList<MovieEntity> getMoviesForKids() {
        ArrayList<MovieEntity> movies = new ArrayList<>();

        StringBuilder sql =  new StringBuilder();
        sql.append("SELECT * FROM tblmovies ");
        sql.append("WHERE movie_for_age <= 12 ");
        sql.append("ORDER BY movie_rating DESC ");

        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());

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

    public ResultSet getTopSellingMovies() {
        ResultSet rs = null;

        StringBuilder sql =  new StringBuilder();

        sql.append("SELECT" +
                "    m.movie_title, movie_poster_url, " +
                "    COUNT(bs.booking_seat_id) AS total_tickets_sold," +
                "    st.ticket_price," +
                "    COUNT(bs.booking_seat_id) * st.ticket_price AS revenue," +
                "    m.movie_rating " +
                "FROM " +
                "    tblmovies m " +
                "JOIN " +
                "    tblshowtimes st ON m.movie_id = st.movie_id " +
                "JOIN " +
                "    tblbookings b ON st.showtime_id = b.showtime_id " +
                "JOIN " +
                "    tblbooking_seats bs ON b.booking_id = bs.booking_id " +
                "GROUP BY " +
                "    m.movie_title, m.movie_rating, st.ticket_price " +
                "ORDER BY " +
                "    total_tickets_sold DESC, m.movie_rating DESC " +
                "LIMIT 5;");

        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());

            rs = pre.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();

            try {
                this.con.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        return rs;
    }

    public HashMap<Object,Object> getTicketsSoldAndRevenue() {

        HashMap<Object, Object> resultMap = new HashMap<>();
        StringBuilder sql =  new StringBuilder();
        sql.append(" SELECT COUNT(booking_seat_id) AS total_tickets_sold FROM tblbooking_seats;" +
                "SELECT SUM(total) AS total_revenue" +
                "    FROM (" +
                "        SELECT st.ticket_price * COUNT(bs.booking_seat_id) AS total" +
                "        FROM tblshowtimes st" +
                "        JOIN tblbookings b ON st.showtime_id = b.showtime_id" +
                "        JOIN tblbooking_seats bs ON b.booking_id = bs.booking_id" +
                "        GROUP BY st.showtime_id" +
                "    ) AS revenue_per_showtime;");

        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());

            boolean  hasMoreResults = pre.execute();

            if(hasMoreResults) {
                ResultSet s1 = pre.getResultSet();
                try {
                    if(s1.next()) {
                        resultMap.put("total_tickets_sold", s1.getInt("total_tickets_sold"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(pre.getMoreResults()){
                ResultSet s2 = pre.getResultSet();

                try {
                    if(s2.next()) {
                        resultMap.put("total_revenue", s2.getInt("total_revenue"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();

            try {
                this.con.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        return resultMap;
    }
}
