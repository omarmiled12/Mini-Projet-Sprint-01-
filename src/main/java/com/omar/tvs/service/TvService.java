package com.omar.tvs.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.omar.tvs.entities.Marque;
import com.omar.tvs.entities.Tv;

public interface TvService {
    Tv saveTv(Tv t);
    Tv updateTv(Tv t);
    void deleteTv(Tv t);
    void deleteTvById(Long id);
    Tv getTv(Long id);
    List<Tv> getAllTvs();
    
    List<Tv> findByNomTv(String nomTv);
    List<Tv> findByNomTvContains(String nomTv);
    List<Tv> findByNomTvPrix(String nomTv, Double prix);
    
    List<Tv> findByMarque(Marque marque);
    List<Tv> findByMarqueIdMarque(Long id);
    
    List<Tv> findByOrderByNomTvAsc();
    List<Tv> trierTvsNomPrix();
    
    Page<Tv> getAllTvsParPage(int page, int size);
}
