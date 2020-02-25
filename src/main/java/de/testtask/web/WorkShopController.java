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
        repository.save(new WorkShop("1", new String[]{"vw", "bmw"}, "kiev", "03123", "ua"));
        repository.save(new WorkShop("2", new String[]{"audi"}, "munich", "43242", "de"));
    }

    @GetMapping("/workshop")
    public List<WorkShop> getAll() {
        return (List<WorkShop>) repository.findAll();
    }

    @PostMapping("/workshop")
    public WorkShop create(@RequestBody WorkShop workShop) {
        return repository.save(workShop);
    }

    @GetMapping("/workshop/delete/{name}")
    public List<WorkShop> deleteByName(@PathVariable String name) {
        repository.deleteById(name);
        return getAll();
    }

    @GetMapping("/workshop/search")
    public List<WorkShop> search(@RequestParam String city) {
        return repository.findByCity(city);
    }
}