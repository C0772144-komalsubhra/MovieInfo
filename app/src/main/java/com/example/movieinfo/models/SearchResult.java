package com.example.movieinfo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SearchResult implements Serializable {
    @Expose
    @SerializedName("Search")
    private List<Search> search;

    @Expose
    @SerializedName("totalResults")
    private int totalResults;

    @Expose
    @SerializedName("Response")
    private String response;

    public List<Search> getSearch() {
        return search;
    }

    public void setSearch(List<Search> search) {
        this.search = search;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = Integer.parseInt(totalResults);
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SearchResult{");
        sb.append("search=").append(search);
        sb.append(", totalResults=").append(totalResults);
        sb.append(", response='").append(response).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
