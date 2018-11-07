package com.pencaksilat.app.pencaksilatapp.model;

public class RuleModel {
    private String kode;
    private int title;
    private String content;
    private int image;

    public RuleModel(String kode, int title, String content, int image) {
        this.kode = kode;
        this.title = title;
        this.content = content;
        this.image = image;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
