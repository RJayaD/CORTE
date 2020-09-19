package com.example.corte.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Edicion {
    private String issueId;
    private String volume;
    private String number;
    private String year;
    private String datePublished;
    private String title;
    private String doi;
    private String cover;


    public Edicion(JSONObject item) throws JSONException {
        this.issueId = item.getString("issue_id");
        this.title = item.getString("title");
        this.volume = item.getString("volume");
        this.number = item.getString("number");
        this.datePublished =item.getString("date_published");
        this.year = item.getString("year");
        this.doi = item.getString("doi");
        this.cover = item.getString("cover");
    }

    public static ArrayList<Edicion> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Edicion> edicions = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            edicions.add(new Edicion(datos.getJSONObject(i)));
        }
        return edicions;
    }



    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }


}