package com.example.hansity.syyyz;

import android.graphics.Bitmap;

public class Movie {
	private int movieId;
	private String movieName;
	private String movieType;
	private int movieDuration; // In minutes
	private String movieDirector;
	private String movieDescription;
    private Bitmap movieImage;

    public Movie(int movieId, String movieName, String movieType, int movieDuration, String movieDirector, String movieDescription, Bitmap movieImage) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieType = movieType;
        this.movieDuration = movieDuration;
        this.movieDirector = movieDirector;
        this.movieDescription = movieDescription;
        this.movieImage = movieImage;
    }

    public Movie(String movieName, String movieType, int movieDuration, String movieDirector, String movieDescription, Bitmap movieImage) {
        this.movieName = movieName;
        this.movieType = movieType;
        this.movieDuration = movieDuration;
        this.movieDirector = movieDirector;
        this.movieDescription = movieDescription;
        this.movieImage = movieImage;
    }

    public Movie(int movieid, String movieName, Bitmap movieImage) {
        this.movieId = movieid;
        this.movieName = movieName;
        this.movieImage = movieImage;
    }

    public Movie() {
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieType() {
        return movieType;
    }

    public int getMovieDuration() {
        return movieDuration;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public Bitmap getMovieImage() {
        return movieImage;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public void setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public void setMovieImage(Bitmap movieImage) {
        this.movieImage = movieImage;
    }
}
