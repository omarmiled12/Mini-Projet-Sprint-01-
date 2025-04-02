package com.omar.tvs.service;

import com.omar.tvs.entities.Tv;
import java.util.List;
import org.springframework.data.domain.Page;

public interface TvService {
    // Save a TV
    Tv saveTv(Tv t);
    
    // Update a TV
    Tv updateTv(Tv t);
    
    // Delete a TV
    void deleteTv(Tv t);
    
    // Delete a TV by ID
    void deleteTvById(Long id);
    
    // Get a TV by ID
    Tv getTv(Long id);
    
    // Get all TVs
    List<Tv> getAllTvs();
    
    // Get TVs with pagination
    Page<Tv> getAllTvsParPage(int page, int size);
}