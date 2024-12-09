package com.group11.moviebooking.repository;


import com.group11.moviebooking.util.MovieEntity;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                MovieEntity movie = new MovieEntity();
                movie.setMovie_id(rs.getInt("movie_id"));
                movie.setMovie_title(rs.getString("movie_title"));
                movie.setMovie_description(rs.getString("movie_description"));
                movie.setMovie_rating(rs.getFloat("movie_rating"));
                movie.setMovie_duration(rs.getInt("movie_duration"));
                movie.setMovie_trailer_url(rs.getString("movie_trailer_url"));
                movie.setMovie_realease_date(rs.getString("movie_release_date"));
                movie.setMovie_created_at(rs.getString("movie_created_at"));
                movie.setMovie_main_actor(rs.getString("movie_main_actor"));
                movie.setMovie_director(rs.getString("movie_director"));
                movie.setMovie_studio(rs.getString("movie_studio"));
                movie.setMovie_country(rs.getString("movie_country"));
                movie.setMovie_genre(rs.getString("movie_genre"));
                movie.setMovie_for_age(rs.getInt("movie_for_age"));
                movie.setMovie_poster_url(rs.getString("movie_poster_url"));

                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.releaseConnection(); // Trả lại kết nối
        }
        return movies;
    }

    public List<MovieEntity> getMovies(String movie_title) {
        List<MovieEntity> movies = new ArrayList<>();

        String sql = "SELECT * FROM tblmovies WHERE movie_title LIKE ?";

        try {
            PreparedStatement pre = this.con.prepareStatement(sql.toString());
            pre.setString(1, "%" + movie_title + "%");
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                MovieEntity movie = new MovieEntity();
                movie.setMovie_id(rs.getInt("movie_id"));
                movie.setMovie_title(rs.getString("movie_title"));
                movie.setMovie_description(rs.getString("movie_description"));
                movie.setMovie_rating(rs.getFloat("movie_rating"));
                movie.setMovie_duration(rs.getInt("movie_duration"));
                movie.setMovie_trailer_url(rs.getString("movie_trailer_url"));
                movie.setMovie_realease_date(rs.getString("movie_release_date"));
                movie.setMovie_created_at(rs.getString("movie_created_at"));
                movie.setMovie_main_actor(rs.getString("movie_main_actor"));
                movie.setMovie_director(rs.getString("movie_director"));
                movie.setMovie_studio(rs.getString("movie_studio"));
                movie.setMovie_country(rs.getString("movie_country"));
                movie.setMovie_genre(rs.getString("movie_genre"));
                movie.setMovie_for_age(rs.getInt("movie_for_age"));
                movie.setMovie_poster_url(rs.getString("movie_poster_url"));

                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
                MovieEntity movie = new MovieEntity();
                movie.setMovie_id(rs.getInt("movie_id"));
                movie.setMovie_title(rs.getString("movie_title"));
                movie.setMovie_description(rs.getString("movie_description"));
                movie.setMovie_rating(rs.getFloat("movie_rating"));
                movie.setMovie_duration(rs.getInt("movie_duration"));
                movie.setMovie_trailer_url(rs.getString("movie_trailer_url"));
                movie.setMovie_realease_date(rs.getString("movie_release_date"));
                movie.setMovie_created_at(rs.getString("movie_created_at"));
                movie.setMovie_main_actor(rs.getString("movie_main_actor"));
                movie.setMovie_director(rs.getString("movie_director"));
                movie.setMovie_studio(rs.getString("movie_studio"));
                movie.setMovie_country(rs.getString("movie_country"));
                movie.setMovie_genre(rs.getString("movie_genre"));
                movie.setMovie_for_age(rs.getInt("movie_for_age"));
                movie.setMovie_poster_url(rs.getString("movie_poster_url"));

                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
                MovieEntity movie = new MovieEntity();
                movie.setMovie_id(rs.getInt("movie_id"));
                movie.setMovie_title(rs.getString("movie_title"));
                movie.setMovie_description(rs.getString("movie_description"));
                movie.setMovie_rating(rs.getFloat("movie_rating"));
                movie.setMovie_duration(rs.getInt("movie_duration"));
                movie.setMovie_trailer_url(rs.getString("movie_trailer_url"));
                movie.setMovie_realease_date(rs.getString("movie_release_date"));
                movie.setMovie_created_at(rs.getString("movie_created_at"));
                movie.setMovie_main_actor(rs.getString("movie_main_actor"));
                movie.setMovie_director(rs.getString("movie_director"));
                movie.setMovie_studio(rs.getString("movie_studio"));
                movie.setMovie_country(rs.getString("movie_country"));
                movie.setMovie_genre(rs.getString("movie_genre"));
                movie.setMovie_for_age(rs.getInt("movie_for_age"));
                movie.setMovie_poster_url(rs.getString("movie_poster_url"));

                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.releaseConnection(); // Trả lại kết nối
        }
        return movies;
    }

    public ArrayList<MovieEntity> getAdultMovies(){

        ArrayList<MovieEntity> movies = new ArrayList<>();

        return movies;
    }
}
