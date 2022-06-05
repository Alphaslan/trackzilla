package com.trackzilla.data;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Release {

    @Id
    private String id;
    private String name;
    private String description;
    private List<Ticket> tickets;

    public Release() {
    }

    public Release(String name, String description, List<Ticket> tickets) {
        this.name = name;
        this.description = description;
        this.tickets = tickets;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}
