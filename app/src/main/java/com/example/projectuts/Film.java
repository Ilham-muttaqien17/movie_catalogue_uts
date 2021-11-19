package com.example.projectuts;

public class Film {
    private String title;
    private String synopsis;
    private String releaseDate;
    private String coverImage;
    private String rate;
    private String language;

    private static String URL_COVER = "https://themoviedb.org/t/p/w500/";

    public Film(){}

    public Film(String title, String synopsis, String releaseDate, String coverImage, String rate, String language) {
        this.title = title;
        this.synopsis = synopsis;
        this.releaseDate = releaseDate;
        this.coverImage = coverImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = URL_COVER + coverImage;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
