package com.example.movieinfo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Search implements Serializable {
    @Expose
    @SerializedName("Title")
    private String title;

    @Expose
    @SerializedName("Year")
    private String year;

    @Expose
    @SerializedName("imdbID")
    private String imdbID;

    @Expose
    @SerializedName("Type")
    private String type;

    @Expose
    @SerializedName("Poster")
    private String poster;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Search{");
        sb.append("title='").append(title).append('\'');
        sb.append(", year='").append(year).append('\'');
        sb.append(", imdbID='").append(imdbID).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", poster='").append(poster).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
