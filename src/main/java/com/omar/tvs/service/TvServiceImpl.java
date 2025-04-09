package com.omar.tvs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.omar.tvs.entities.Marque;
import com.omar.tvs.entities.Tv;
import com.omar.tvs.repos.TvRepository;

@Service
public class TvServiceImpl implements TvService {
    
    @Autowired
    TvRepository tvRepository;
    
    @Override
    public Tv saveTv(Tv t) {
        return tvRepository.save(t);
    }
    
    @Override
    public Tv updateTv(Tv t) {
        return tvRepository.save(t);
    }
    
    @Override
    public void deleteTv(Tv t) {
        tvRepository.delete(t);
    }
    
    @Override
    public void deleteTvById(Long id) {
        tvRepository.deleteById(id);
    }
    
    @Override
    public Tv getTv(Long id) {
        return tvRepository.findById(id).get();
    }
    
    @Override
    public List<Tv> getAllTvs() {
        return tvRepository.findAll();
    }
    
    @Override
    public List<Tv> findByNomTv(String nomTv) {
        return tvRepository.findByNomTv(nomTv);
    }
    
    @Override
    public List<Tv> findByNomTvContains(String nomTv) {
        return tvRepository.findByNomTvContains(nomTv);
    }
    
    @Override
    public List<Tv> findByNomTvPrix(String nomTv, Double prix) {
        return tvRepository.findByNomTvPrix(nomTv, prix);
    }
    
    @Override
    public List<Tv> findByMarque(Marque marque) {
        return tvRepository.findByMarque(marque);
    }
    
    @Override
    public List<Tv> findByMarqueIdMarque(Long id) {
        return tvRepository.findByMarqueIdMarque(id);
    }
    
    @Override
    public List<Tv> findByOrderByNomTvAsc() {
        return tvRepository.findByOrderByNomTvAsc();
    }
    
    @Override
    public List<Tv> trierTvsNomPrix() {
        return tvRepository.trierTvsNomPrix();
    }

    @Override
    public Page<Tv> getAllTvsParPage(int page, int size) {
        return tvRepository.findAll(PageRequest.of(page, size));
    }
}
