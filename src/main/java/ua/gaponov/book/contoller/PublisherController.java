package ua.gaponov.booklib.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.gaponov.booklib.entity.Publisher;
import ua.gaponov.booklib.services.PublisherServive;

import java.util.List;


@RestController
@RequestMapping("publishers")
public class PublisherController {


    @Autowired
    PublisherServive publisherServive;


    @GetMapping("/all")
    public List<Publisher> list() {
        return publisherServive.getAll();
    }


    @GetMapping("{id}")
    public Publisher getOne(@PathVariable("id") Publisher publisher){
        return publisher;
    }


    @PostMapping
    public Publisher create(@RequestBody Publisher publisher) {
        return publisherServive.save(publisher);
    }


    @PutMapping("{id}")
    public Publisher update(
            @PathVariable("id") Publisher publisherFromDb,
            @RequestBody Publisher publisher
    ) {
        BeanUtils.copyProperties(publisher, publisherFromDb, "id");

        return publisherServive.save(publisherFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Publisher publisher) {
        publisherServive.delete(publisher);
    }
}
