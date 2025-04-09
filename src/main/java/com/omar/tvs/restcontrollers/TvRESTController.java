package com.omar.tvs.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.omar.tvs.entities.Tv;
import com.omar.tvs.service.TvService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TvRESTController {

    @Autowired
    TvService tvService;

    // Get all TVs
    @GetMapping
    public List<Tv> getAllTvs() {
        return tvService.getAllTvs();
    }

    // Get TV by ID
    @GetMapping("/{id}")
    public Tv getTvById(@PathVariable("id") Long id) {
        return tvService.getTv(id);
    }

    // Create a new TV
    @PostMapping
    public Tv createTv(@RequestBody Tv tv) {
        return tvService.saveTv(tv);
    }

    // Update TV
    @PutMapping
    public Tv updateTv(@RequestBody Tv tv) {
        return tvService.updateTv(tv);
    }

    // Delete TV
    @DeleteMapping("/{id}")
    public void deleteTv(@PathVariable("id") Long id) {
        tvService.deleteTvById(id);
    }

    // Get TVs by marque ID
    @GetMapping("/tvsbycat/{idMarque}")
    public List<Tv> getTvsByMarqueId(@PathVariable("idMarque") Long idMarque) {
        return tvService.findByMarqueIdMarque(idMarque);
    }
}
