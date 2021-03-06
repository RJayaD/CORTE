package com.example.corte.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Articulo_Base {
    private String section;
    private String publicationId;
    private String title;
    private String doi;
    private String _abstract;
    private String datePublished;
    private String submissionId;
    private String sectionId;
    private String seq;
    private List<Galey> galeys = null;
    private List<Keyword> keywords = null;
    private List<Author> authors = null;


    public Articulo_Base(JSONObject item) throws JSONException {

        title =item.getString("title");
        doi = item.getString("doi");
        _abstract = item.getString("abstract");
        datePublished= item.getString("date_published");

    }



    public static ArrayList<Articulo_Base> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Articulo_Base> articulos = new ArrayList<>();

        for (int i = 0; i < datos.length() ; i++) {
            articulos.add(new Articulo_Base(datos.getJSONObject(i)));
        }
        return articulos;
    }



    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(String publicationId) {
        this.publicationId = publicationId;
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

    public String getAbstract() {
        return _abstract;
    }

    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public List<Galey> getGaleys() {
        return galeys;
    }

    public void setGaleys(List<Galey> galeys) {
        this.galeys = galeys;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public class Keyword {

        private String keyword;

        public Keyword()
        {

        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

    }
}

