package com.omar.tvs.service;

import com.omar.tvs.entities.Tv;
import com.omar.tvs.repos.TvRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class TvServiceImpl implements TvService {

    @Autowired
    private TvRepository tvRepository;

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
        return tvRepository.findById(id).orElse(null);
    }

    @Override
    public List<Tv> getAllTvs() {
        return tvRepository.findAll();
    }

    @Override
    public Page<Tv> getAllTvsParPage(int page, int size) {
        return tvRepository.findAll(PageRequest.of(page, size));
    }
}