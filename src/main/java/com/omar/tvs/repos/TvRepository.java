package com.omar.tvs.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.omar.tvs.entities.Marque;
import com.omar.tvs.entities.Tv;

public interface TvRepository extends JpaRepository<Tv, Long> {
    
    // Search by nomTv
    List<Tv> findByNomTv(String nomTv);
    
    // Search with 'contains' in nomTv
    List<Tv> findByNomTvContains(String nomTv);
    
    // Search by nomTv and minimum price
    @Query("select t from Tv t where t.nomTv like %?1 and t.priceTv > ?2")
    List<Tv> findByNomTvPrix(String nomTv, Double prix);
    
    // Named parameters version
    @Query("select t from Tv t where t.nomTv like %:nomTv and t.priceTv > :prix")
    List<Tv> findByNomTvPrix1(
        @Param("nomTv") String nomTv, 
        @Param("prix") Double prix);
    
    // Search by marque entity
    @Query("select t from Tv t where t.marque = ?1")
    List<Tv> findByMarque(Marque marque);
    
    // Search by marque ID
    List<Tv> findByMarqueIdMarque(Long id);
    
    // Sort TVs by nomTv ascending
    List<Tv> findByOrderByNomTvAsc();
    
    // Custom sort: nomTv ASC, then priceTv DESC
    @Query("select t from Tv t order by t.nomTv ASC, t.priceTv DESC")
    List<Tv> trierTvsNomPrix();
}
