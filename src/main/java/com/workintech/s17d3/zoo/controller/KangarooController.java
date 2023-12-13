package com.workintech.s17d3.zoo.controller;

import com.workintech.s17d3.zoo.entity.Kangaroo;
import com.workintech.s17d3.zoo.exceptions.error.KangarooValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kangaroos")
public class KangarooController {

    private Map<Integer, Kangaroo> kangaroos;

    @PostConstruct
    public void init(){
        kangaroos = new HashMap<>();
    }

    @GetMapping("/")
    public List<Kangaroo> allKangaroos(){
        return kangaroos.values().stream().toList();
    }
    @GetMapping("/{id}")
    public Kangaroo getKangaroo(@PathVariable int id){
        KangarooValidation.IDisNotValid(id);
        KangarooValidation.kangarooIsNotExist(kangaroos,id);
            return kangaroos.get(id);
    }
    @PostMapping("/")
    public Kangaroo addKangaroo(@RequestBody Kangaroo kangaroo){
        KangarooValidation.kangarooExist(kangaroos, kangaroo.getId());
        return kangaroos.put(kangaroo.getId(), kangaroo);
    }
    @PutMapping("/{id}")
    public Kangaroo updateKangaroo(@PathVariable int id,@RequestBody Kangaroo kangaroo){
        KangarooValidation.kangarooIsNotExist(kangaroos, kangaroo.getId());
            kangaroo.setId(id);
            kangaroos.put(id, kangaroo);
            return kangaroo;
    }
    @DeleteMapping("/{id}")
    public Kangaroo deleteKangaroo(@PathVariable int id){
        KangarooValidation.kangarooIsNotExist(kangaroos,id);
        return kangaroos.remove(id);
    }
}
