package com.group11.moviebooking.builer;//package btljavaweb.builer;
//
//import java.sql.Date;
//import java.sql.Timestamp;
//import java.text.DecimalFormat;
//
//import javax.xml.soap.Text;
//
//import btljavaweb.builer.CustomerSearchBuilder.Customer;
//
//public class MovieSearchBuilder {
//	private int movie_id;
//
//	private String movie_title;
//	
//
//	private String movie_description;
//	
//
//	private DecimalFormat movie_rating;
//	
//	
//	private int movie_duration;
//
//	private String movie_trailer_url;
//	
//
//	private Date movie_release_date;
//	
//
//	private Timestamp movie_created_at;
//	
//	
//	private Text movie_main_actor;
//	
//
//	private String movie_director;
//	
//
//	private String movie_studio;
//
//	private String movie_country;
//	
//
//	private String movie_gentre;
//	
//
//	private int movie_for_age;
//
//	private String movie_poster_url;
//
//	public int getMovie_id() {
//		return movie_id;
//	}
//
//	public void setMovie_id(int movie_id) {
//		this.movie_id = movie_id;
//	}
//
//	public String getMovie_title() {
//		return movie_title;
//	}
//
//	public void setMovie_title(String movie_title) {
//		this.movie_title = movie_title;
//	}
//
//	public String getMovie_description() {
//		return movie_description;
//	}
//
//	public void setMovie_description(String movie_description) {
//		this.movie_description = movie_description;
//	}
//
//	public DecimalFormat getMovie_rating() {
//		return movie_rating;
//	}
//
//	public void setMovie_rating(DecimalFormat movie_rating) {
//		this.movie_rating = movie_rating;
//	}
//
//	public int getMovie_duration() {
//		return movie_duration;
//	}
//
//	public void setMovie_duration(int movie_duration) {
//		this.movie_duration = movie_duration;
//	}
//
//	public String getMovie_trailer_url() {
//		return movie_trailer_url;
//	}
//
//	public void setMovie_trailer_url(String movie_trailer_url) {
//		this.movie_trailer_url = movie_trailer_url;
//	}
//
//	public Date getMovie_release_date() {
//		return movie_release_date;
//	}
//
//	public void setMovie_release_date(Date movie_release_date) {
//		this.movie_release_date = movie_release_date;
//	}
//
//	public Timestamp getMovie_created_at() {
//		return movie_created_at;
//	}
//
//	public void setMovie_created_at(Timestamp movie_created_at) {
//		this.movie_created_at = movie_created_at;
//	}
//
//	public Text getMovie_main_actor() {
//		return movie_main_actor;
//	}
//
//	public void setMovie_main_actor(Text movie_main_actor) {
//		this.movie_main_actor = movie_main_actor;
//	}
//
//	public String getMovie_director() {
//		return movie_director;
//	}
//
//	public void setMovie_director(String movie_director) {
//		this.movie_director = movie_director;
//	}
//
//	public String getMovie_studio() {
//		return movie_studio;
//	}
//
//	public void setMovie_studio(String movie_studio) {
//		this.movie_studio = movie_studio;
//	}
//
//	public String getMovie_country() {
//		return movie_country;
//	}
//
//	public void setMovie_country(String movie_country) {
//		this.movie_country = movie_country;
//	}
//
//	public String getMovie_gentre() {
//		return movie_gentre;
//	}
//
//	public void setMovie_gentre(String movie_gentre) {
//		this.movie_gentre = movie_gentre;
//	}
//
//	public int getMovie_for_age() {
//		return movie_for_age;
//	}
//
//	public void setMovie_for_age(int movie_for_age) {
//		this.movie_for_age = movie_for_age;
//	}
//
//	public String getMovie_poster_url() {
//		return movie_poster_url;
//	}
//
//	public void setMovie_poster_url(String movie_poster_url) {
//		this.movie_poster_url = movie_poster_url;
//	}
//	public static class Movie{
//		private int movie_id;
//
//		private String movie_title;
//		
//
//		private String movie_description;
//		
//
//		private DecimalFormat movie_rating;
//		
//		
//		private int movie_duration;
//
//		private String movie_trailer_url;
//		
//
//		private Date movie_release_date;
//		
//
//		private Timestamp movie_created_at;
//		
//		
//		private Text movie_main_actor;
//		
//
//		private String movie_director;
//		
//
//		private String movie_studio;
//
//		private String movie_country;
//		
//
//		private String movie_gentre;
//		
//
//		private int movie_for_age;
//
//
//		public int getMovie_id() {
//			return movie_id;
//		}
//
//
//		public String getMovie_title() {
//			return movie_title;
//		}
//
//
//		public String getMovie_description() {
//			return movie_description;
//		}
//
//
//		public DecimalFormat getMovie_rating() {
//			return movie_rating;
//		}
//
//
//		public int getMovie_duration() {
//			return movie_duration;
//		}
//
//
//		public String getMovie_trailer_url() {
//			return movie_trailer_url;
//		}
//
//
//		public Date getMovie_release_date() {
//			return movie_release_date;
//		}
//
//
//		public Timestamp getMovie_created_at() {
//			return movie_created_at;
//		}
//
//
//		public Text getMovie_main_actor() {
//			return movie_main_actor;
//		}
//
//
//		public String getMovie_director() {
//			return movie_director;
//		}
//
//
//		public String getMovie_studio() {
//			return movie_studio;
//		}
//
//
//		public String getMovie_country() {
//			return movie_country;
//		}
//
//
//		public String getMovie_gentre() {
//			return movie_gentre;
//		}
//
//
//		public int getMovie_for_age() {
//			return movie_for_age;
//		}
//		public Movie setId(int movie_id) {
//			this.movie_id = movie_id;
//			return this;
//		}
//		public Movie setMovie_title(String movie_title) {
//			this.movie_title = movie_title;
//			return this;
//		}
//		public Movie setMovie_description(String movie_description) {
//			this.movie_description = movie_description;
//			return this;
//		}
//		public Movie setMovie_rating(DecimalFormat movie_rating) {
//			this.movie_rating = movie_rating;
//			return this;
//		}
//		public Movie setMovie_duration(int movie_duration) {
//			this.movie_duration = movie_duration;
//			return this;
//		}
//		public Movie setMovie_trailer_url(String movie_trailer_url) {
//			this.movie_trailer_url = movie_trailer_url;
//			return this;
//		}
//		public Movie setMovie_release_date(Date movie_release_date) {
//			this.movie_release_date = movie_release_date;
//			return this;
//		}
//		public Movie setMovie_created_at(Timestamp movie_created_at) {
//			this.movie_created_at = movie_created_at;
//			return this;
//		}
//		public Movie setMovie_main_actor(Text movie_main_actor) {
//			this.movie_main_actor = movie_main_actor;
//			return this;
//		}
//		public Movie setMovie_director(String movie_director) {
//			this.movie_director = movie_director;
//			return this;
//		}
//		public Movie setMovie_country(String movie_country) {
//			this.movie_country = movie_country;
//			return this;
//		}
//		public Movie setMovie_gentre(String movie_gentre) {
//			this.movie_gentre = movie_gentre;
//			return this;
//		}
//		public Movie setMovie_studio(String movie_studio) {
//			this.movie_studio = movie_studio;
//			return this;
//		}
//		public Movie setMovie_for_age(int movie_for_age) {
//			this.movie_for_age = movie_for_age;
//			return this;
//		}
//		public MovieSearchBuilder build() { 
//			return new MovieSearchBuilder(this);	
//	}
//
//}
