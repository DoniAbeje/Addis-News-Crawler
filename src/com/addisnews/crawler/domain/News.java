package com.addisnews.crawler.domain;


public class News {

    private int id;
    private String title;
    private String content;
    private String category_id;
    private String published_Date;
    private String source_website;
    private String source_url;
    private String image_url;

    public News(int id, String title, String content, String category_id, String published_Date, String source_website, String source_url, String image_url) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category_id = category_id;
        this.published_Date = published_Date;
        this.source_website = source_website;
        this.source_url = source_url;
        this.image_url = image_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getPublished_Date() {
        return published_Date;
    }

    public void setPublished_Date(String published_Date) {
        this.published_Date = published_Date;
    }

    public String getSource_website() {
        return source_website;
    }

    public void setSource_website(String source_website) {
        this.source_website = source_website;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "News{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", category_id='" + category_id + '\'' +
                ", published_Date=" + published_Date +
                ", source_website='" + source_website + '\'' +
                ", source_url='" + source_url + '\'' +
                '}';
    }
}
