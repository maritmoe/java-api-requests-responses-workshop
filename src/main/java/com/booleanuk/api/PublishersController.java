package com.booleanuk.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@RequestMapping("publishers")
public class PublishersController {
    private ArrayList<Publisher> publishers;

    public PublishersController() {
        this.publishers = new ArrayList<>();
        
        this.publishers.add(new Publisher("Kunnskapsforlaget", "Trondheim"));
        this.publishers.add(new Publisher("Damm", "Bergen"));
    }
    
    @GetMapping
    public ArrayList<Publisher> getAll() {
        return this.publishers;
    }
    
    @GetMapping("/{id}")
    public Publisher getOnePublisher(@PathVariable int id) {
        if(id < this.publishers.size() && id >= 0) {
            return this.publishers.get(id);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id out of range");
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher create(@RequestBody Publisher publisher) {
        this.publishers.add(publisher);
        return publisher;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher update(@PathVariable int id, @RequestBody Publisher publisher) {
        if (id < this.publishers.size() && id >= 0) {
            this.publishers.get(id).setName(publisher.getName());
            this.publishers.get(id).setCity(publisher.getCity());
            return this.publishers.get(id);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id out of range");
    }

    @DeleteMapping("/{id}")
    public Publisher delete(@PathVariable int id) {
        if (id < this.publishers.size() && id >= 0) {
            return this.publishers.remove(id);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id out of range");
    }
}
