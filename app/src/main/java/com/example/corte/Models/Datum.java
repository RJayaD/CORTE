package com.example.corte.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Datum {
    private String journalId;
    private String portada;
    private String abbreviation;
    private String description;
    private String journalThumbnail;
    private String name;

    public Datum(JSONObject a)throws JSONException {
         journalId  = a.getString("journal_id").toString();
         portada  = a.getString("portada").toString();
         description = a.getString("description").toString();
         name = a.getString("name").toString();
    }

    public static ArrayList<Datum> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Datum> data = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            data.add(new Datum(datos.getJSONObject(i)));
        }
        return data;
    }

    public String getJournalId() {
        return journalId;
    }

    public void setJournalId(String journalId) {
        this.journalId = journalId;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJournalThumbnail() {
        return journalThumbnail;
    }

    public void setJournalThumbnail(String journalThumbnail) {
        this.journalThumbnail = journalThumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }







}
