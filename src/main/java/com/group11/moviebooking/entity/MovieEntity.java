package com.group11.moviebooking.entity;

public class MovieEntity {
    private int movie_id;
    private String movie_title;
    private String movie_description;
    private float movie_rating;
    private int movie_duration;
    private String movie_trailer_url;
    private String movie_release_date;
    private String movie_created_at;
    private String movie_main_actor;
    private String movie_director;
    private String movie_studio;
    private String movie_country;
    private String movie_genre;
    private int movie_for_age;
    private String movie_poster_url;

    // Getter and Setter for movie_id
    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    // Getter and Setter for movie_title
    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    // Getter and Setter for movie_description
    public String getMovie_description() {
        return movie_description;
    }

    public void setMovie_description(String movie_description) {
        this.movie_description = movie_description;
    }

    // Getter and Setter for movie_rating
    public float getMovie_rating() {
        return movie_rating;
    }

    public void setMovie_rating(float movie_rating) {
        this.movie_rating = movie_rating;
    }

    // Getter and Setter for movie_duration
    public int getMovie_duration() {
        return movie_duration;
    }

    public void setMovie_duration(int movie_duration) {
        this.movie_duration = movie_duration;
    }

    // Getter and Setter for movie_trailer_url
    public String getMovie_trailer_url() {
        return movie_trailer_url;
    }

    public void setMovie_trailer_url(String movie_trailer_url) {
        this.movie_trailer_url = movie_trailer_url;
    }

    // Getter and Setter for movie_release_date
    public String getMovie_release_date() {
        return movie_release_date;
    }

    public void setMovie_release_date(String movie_release_date) {
        this.movie_release_date = movie_release_date;
    }

    // Getter and Setter for movie_created_at
    public String getMovie_created_at() {
        return movie_created_at;
    }

    public void setMovie_created_at(String movie_created_at) {
        this.movie_created_at = movie_created_at;
    }

    // Getter and Setter for movie_main_actor
    public String getMovie_main_actor() {
        return movie_main_actor;
    }

    public void setMovie_main_actor(String movie_main_actor) {
        this.movie_main_actor = movie_main_actor;
    }

    // Getter and Setter for movie_director
    public String getMovie_director() {
        return movie_director;
    }

    public void setMovie_director(String movie_director) {
        this.movie_director = movie_director;
    }

    // Getter and Setter for movie_studio
    public String getMovie_studio() {
        return movie_studio;
    }

    public void setMovie_studio(String movie_studio) {
        this.movie_studio = movie_studio;
    }

    // Getter and Setter for movie_country
    public String getMovie_country() {
        return movie_country;
    }

    public void setMovie_country(String movie_country) {
        this.movie_country = movie_country;
    }

    // Getter and Setter for movie_genre
    public String getMovie_genre() {
        return movie_genre;
    }

    public void setMovie_genre(String movie_genre) {
        this.movie_genre = movie_genre;
    }

    // Getter and Setter for movie_for_age
    public int getMovie_for_age() {
        return movie_for_age;
    }

    public void setMovie_for_age(int movie_for_age) {
        this.movie_for_age = movie_for_age;
    }

    // Getter and Setter for movie_poster_url
    public String getMovie_poster_url() {
        return movie_poster_url;
    }

    public void setMovie_poster_url(String movie_poster_url) {
        this.movie_poster_url = movie_poster_url;
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "movie_id=" + movie_id +
                ", movie_title='" + movie_title + '\'' +
                ", movie_description='" + movie_description + '\'' +
                ", movie_rating=" + movie_rating +
                ", movie_duration=" + movie_duration +
                ", movie_trailer_url='" + movie_trailer_url + '\'' +
                ", movie_release_date='" + movie_release_date + '\'' +
                ", movie_created_at='" + movie_created_at + '\'' +
                ", movie_main_actor='" + movie_main_actor + '\'' +
                ", movie_director='" + movie_director + '\'' +
                ", movie_studio='" + movie_studio + '\'' +
                ", movie_country='" + movie_country + '\'' +
                ", movie_genre='" + movie_genre + '\'' +
                ", movie_for_age=" + movie_for_age +
                ", movie_poster_url='" + movie_poster_url + '\'' +
                "}\n";
    }
}
