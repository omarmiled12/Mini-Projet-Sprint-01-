package com.omar.tvs;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.omar.tvs.entities.Marque;
import com.omar.tvs.entities.Tv;
import com.omar.tvs.repos.TvRepository;

@SpringBootTest
class TvApplicationTests {

    @Autowired
    private TvRepository tvRepository;

    @Test
    public void testCreateTv() {
        Tv tv = new Tv("55 inch", 499.99, "4K UHD", "Samsung OLED TV", new Date());
        tvRepository.save(tv);
    }

    @Test
    public void testFindTv() {
        Tv t = tvRepository.findById(1L).get();
        System.out.println(t);
    }

    @Test
    public void testUpdateTv() {
        Tv t = tvRepository.findById(1L).get();
        t.setPriceTv(449.99); // Updating the TV price
        tvRepository.save(t);
    }

    @Test
    public void testDeleteTv() {
        tvRepository.deleteById(1L);
    }

    @Test
    public void testListAllTvs() {
        List<Tv> tvs = tvRepository.findAll();
        for (Tv t : tvs) {
            System.out.println(t);
        }
    }

    @Test
    public void testFindByNomTv() {
        List<Tv> tvs = tvRepository.findByNomTv("Samsung OLED TV");
        for (Tv t : tvs) {
            System.out.println(t);
        }
    }

    @Test
    public void testFindByNomTvPrix() {
        // Find TVs with name containing "Samsung" and price > 2000.0
        List<Tv> tvs = tvRepository.findByNomTvPrix("Samsung", 2000.0);
        for (Tv t : tvs) {
            System.out.println(t);
        }
    }

    @Test
    public void testFindByMarque() {
        // Create a Marque object with ID
        Marque marque = new Marque();
        marque.setIdMarque(1L);  // Make sure ID is correctly set
        
        // Find all TVs belonging to this marque
        List<Tv> tvs = tvRepository.findByMarque(marque);
        for (Tv t : tvs) {
            System.out.println(t);
        }
    }
    @Test
    public void testFindByOrderByNomTvAsc() {
        List<Tv> tvs = tvRepository.findByOrderByNomTvAsc();
        for (Tv t : tvs) {
            System.out.println(t);
        }
    }
    @Test
    public void testTrierTvsNomPrix() {
        List<Tv> tvs = tvRepository.trierTvsNomPrix();
        for (Tv t : tvs) {
            System.out.println(t);
        }
    }


}
