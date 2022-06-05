package com.trackzilla.data;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Ticket {

    @Id
    private String id;
    private String title;
    private String description;
    private String appId;
    private String status;

    public Ticket(){}

    public Ticket(String title, String description, String appId, String status) {
        this.title = title;
        this.description = description;
        this.appId = appId;
        this.status = status;
    }

    public Ticket(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAppId() {
        return appId;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "Id='" + id + '\'' +
                ", Title='" + title + '\'' +
                ", Description='" + description + '\'' +
                ", AppId='" + appId + '\'' +
                ", Status='" + status + '\'' +
                '}';
    }
}
