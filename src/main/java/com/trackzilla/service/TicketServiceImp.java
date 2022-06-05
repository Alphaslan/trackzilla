package com.trackzilla.service;

import com.trackzilla.data.Ticket;
import com.trackzilla.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImp {


    @Autowired
    private TicketRepository ticketR;

    public List<Ticket> findAll(){
        return ticketR.findAll();
    }

    public Optional<Ticket> findById (String id){
        return ticketR.findById(id);
    }

    public Ticket save(Ticket ticket){
        return ticketR.save(ticket);
    }

    public void delete(String id){
        ticketR.deleteById(id);
    }

    public List<Ticket> findByStatus (String status){
        return ticketR.findByStatus(status);
    }

    public long countAllOpenTickets(){
        return ticketR.findAllByCustomQuery("open").count();//For sake of customQuery method:)
    }

    public List<Ticket> findByAppId(String id){
        return ticketR.findByAppId(id);
    }

    public Ticket findDescriptionById(String description){
        return ticketR.findByDescription(description);
    }

}
