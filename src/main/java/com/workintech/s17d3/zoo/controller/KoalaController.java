package com.workintech.s17d3.zoo.controller;

import com.workintech.s17d3.zoo.entity.Koala;
import com.workintech.s17d3.zoo.exceptions.error.KoalaValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {

    private Map<Integer, Koala> koalas;

    @PostConstruct
    public void init(){
        koalas = new HashMap<>();
    }
    @GetMapping("/")
    public List<Koala> allKoalas(){
        return koalas.values().stream().toList();
    }
    @GetMapping("/{id}")
    public Koala getKoala(@PathVariable int id){
        KoalaValidation.IDisNotValid(id);
        KoalaValidation.koalaNotExist(koalas,id);
            return koalas.get(id);
    }
    @PostMapping("/")
    public Koala addKoala(@RequestBody Koala koala){
        KoalaValidation.koalaExist(koalas, koala.getId());
        KoalaValidation.sleepHourIsNotValid(koala.getSleepHour());
        return koalas.put(koala.getId(), koala);
    }
    @PutMapping("/{id}")
    public Koala updateKoala(@PathVariable int id, @RequestBody Koala koala){
        KoalaValidation.koalaNotExist(koalas, koala.getId());
        KoalaValidation.sleepHourIsNotValid(koala.getSleepHour());
        koala.setId(id);
        koalas.put(id, koala);
        return koala;
    }
    @DeleteMapping("/{id}")
    public Koala deleteKoala(@PathVariable int id){
        KoalaValidation.koalaNotExist(koalas,id);
        return koalas.remove(id);
    }
}
