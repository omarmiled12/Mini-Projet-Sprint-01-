package com.omar.tvs.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.omar.tvs.entities.Tv;

public interface TvRepository extends JpaRepository<Tv, Long> {
}