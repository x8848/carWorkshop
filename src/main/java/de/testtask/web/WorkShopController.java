package de.testtask.web;

import de.testtask.domain.WorkShop;
import de.testtask.service.WorkShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class WorkShopController {

    @Autowired
    private WorkShopRepository repository;

    @PostConstruct
    private void postConstruct() {
        repository.save(new WorkShop("wsh1", new String[]{"vw", "bmw"}, "kiev", "03123", "ua"));
        repository.save(new WorkShop("wsh2", new String[]{"audi"}, "munich", "43242", "de"));
    }

    @GetMapping("/workshop")
    public List getAll() {
        return (List) repository.findAll();
    }

    @PostMapping("/workshop")
    public void create(@RequestBody WorkShop workShop) {
        repository.save(workShop);
    }

    @DeleteMapping("/workshop")
    void delete(@RequestBody WorkShop workShop) {
        repository.delete(workShop);
    }

    @GetMapping("/workshop/search")
    public List search(@RequestParam String city) {
        return repository.findByCity(city);
    }
}