package com.trackzilla.controllers;

import com.trackzilla.data.Application;
import com.trackzilla.data.Release;
import com.trackzilla.data.Ticket;
import com.trackzilla.service.ApplicationServiceImp;
import com.trackzilla.service.ReleaseServiceImp;
import com.trackzilla.service.TicketServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trackzilla")
public class Controller {

    private final ApplicationServiceImp applicationService;
    private final ReleaseServiceImp releaseService;
    private final TicketServiceImp ticketService;

    public Controller(ApplicationServiceImp applicationService,
                      ReleaseServiceImp releaseService,
                      TicketServiceImp ticketService) {
        this.applicationService = applicationService;
        this.releaseService = releaseService;
        this.ticketService = ticketService;
    }

    @GetMapping("/getAllApps")
    public List<Application> getAllApps() {
        return applicationService.findAll();
    }

    @GetMapping("/getAppById/{id}")
    public Application getAppById(@PathVariable String id) {
        if (applicationService.findById(id).isPresent()) {
            return applicationService.findById(id).get();
        }
        return null;
    }

    @GetMapping("/getAppsByName/{name}")
    public List<Application> getAppsByName(@PathVariable String name) {
        return applicationService.findByName(name);
    }

    @GetMapping("/getAppByIdMT/{id}")
    public Application getAppByIdMT(@PathVariable String id) {
        return applicationService.findByIdWTemplate(id);
    }

    @PostMapping("/saveAllApps")
    public List<Application> saveAllApps(@RequestBody List<Application> applicationList) {
        return applicationService.saveAll(applicationList);
    }

    @PostMapping("/saveApp")
    public Application saveApp(@RequestBody Application app) {
        return applicationService.save(app);
    }

    @PostMapping("/saveAppMT")
    public Application saveAppMT(@RequestBody Application app) {
        return applicationService.addNewApplicationWTemplate(app);
    }

    @DeleteMapping("/deleteAppById/{id}")
    public HttpStatus deleteAppById(@PathVariable String id) {
        if (applicationService.findById(id).isPresent()) {
            applicationService.deleteById(id);
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }

    @DeleteMapping("/deleteAllApps")
    public HttpStatus deleteAllApps() {
        applicationService.deleteAll();
        return HttpStatus.OK;
    }

    @DeleteMapping("/deleteAppMT/{id}")
    public HttpStatus deleteAppMT(@PathVariable String id) {
        applicationService.deleteWTemplate(getAppById(id));
        return HttpStatus.OK;
    }

    @PutMapping("/updateAppById/{id}")
    public Application updateAppById(@PathVariable String id, @RequestBody Application application) {
        return applicationService.update(id, application);
    }

    @PutMapping("/updateAppNameTemplate/{name}")
    public void updateAppNameTemplate(@PathVariable String name, @RequestBody Application application) {
        applicationService.updateApplicationNameWTemplate(name, application);
    }

    @PutMapping("/updateAppId/{id}")
    public Application updateAppId(@PathVariable String id, @RequestBody Application application) {
        return applicationService.updateId(id, application);
    }

    // ************** Methods for Tickets *************************
    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public List<Ticket> getAllTickets() {
        return ticketService.findAll();
    }

    @RequestMapping(value = "/tickets/{id}", method = RequestMethod.GET)
    public Optional<Ticket> getTicketById(@PathVariable("id") String id) {
        return ticketService.findById(id);
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.POST)
    public Ticket addNewApplication(@RequestBody Ticket ticket) {
        return ticketService.save(ticket);
    }

    @RequestMapping(value = "/tickets/{id}", method = RequestMethod.PUT)
    public Ticket updateApplication(@PathVariable("id") String id, @RequestBody Ticket ticket) {
        ticket.setId(id);
        return ticketService.save(ticket);
    }

    @RequestMapping(value = "/tickets/{id}", method = RequestMethod.DELETE)
    public void deleteTicket(@PathVariable("id") String id) {
        ticketService.delete(id);
    }

    @RequestMapping(value = "/tickets/status/{status}", method = RequestMethod.GET)
    public List<Ticket> findByStatus(@PathVariable("status") String status) {
        return ticketService.findByStatus(status);
    }

    @RequestMapping(value = "/tickets/count", method = RequestMethod.GET)
    public Long countAllTickets() {
        return ticketService.countAllOpenTickets();
    }
    @RequestMapping(value = "/tickets/appid/{appId}", method = RequestMethod.GET)
    public List<Ticket> findByAppId(@PathVariable("appId") String appId) {
        return ticketService.findByAppId(appId);
    }

    // ************** Methods for Releases *************************

    @RequestMapping(value = "/releases", method = RequestMethod.GET)
    public List<Release> getAllReleases() {
        return releaseService.findAll();
    }

    @RequestMapping(value = "/releases/{id}", method = RequestMethod.GET)
    public Optional<Release> getReleaseId(@PathVariable("id") String id) {
        return releaseService.findById(id);
    }

    @RequestMapping(value = "/releases", method = RequestMethod.POST)
    public Release addNewRelease(@RequestBody Release release) {
        return releaseService.save(release);
    }

    @RequestMapping(value = "/releases/{id}", method = RequestMethod.PUT)
    public Release updateRelease(@PathVariable("id") String id, @RequestBody Release release) {
        release.setId(id);
        return releaseService.save(release);
    }

    @RequestMapping(value = "/releases/{id}", method = RequestMethod.DELETE)
    public void deleteRelease(@PathVariable("id") String id) {
        releaseService.deleteById(id);
    }

    @RequestMapping(value = "/releases/tickets", method = RequestMethod.PUT)
    public void addNewReleaseWTickets(@RequestBody Release release) {
        releaseService.insert(release);
    }

    @RequestMapping(value = "/releases/status/{status}", method = RequestMethod.GET)
    public List<Release> getReleaseByTicketStatus(@PathVariable("status") String status) {
        return releaseService.getReleaseByTicketStatus(status);
    }


}
