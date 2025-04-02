package com.omar.tvs.controllers;

import com.omar.tvs.entities.Tv;
import com.omar.tvs.service.TvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class TvsController {

    @Autowired
    private TvService tvService;

    // List TVs with pagination
    @RequestMapping("/listeTvs")
    public String listeTvs(ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        
        Page<Tv> tvs = tvService.getAllTvsParPage(page, size);
        modelMap.addAttribute("tvs", tvs);
        modelMap.addAttribute("pages", new int[tvs.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeTvs";
    }

    // Show create form
    @RequestMapping("/showCreateTv")
    public String showCreate(ModelMap modelMap) {
        modelMap.addAttribute("tv", new Tv());
        return "createTv";
    }

    @RequestMapping("/saveTv")
    public String saveTv(@ModelAttribute("tv") Tv tv,
                       @RequestParam("date") String date,
                       ModelMap modelMap) throws ParseException {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date manufactureDate = dateFormat.parse(date);
        tv.setManufactureDate(manufactureDate);

        Tv savedTv = tvService.saveTv(tv);
        String msg = "TV enregistrée avec ID " + savedTv.getIdTv();
        modelMap.addAttribute("msg", msg);
        return "createTv";
    }

    // Delete TV
    @RequestMapping("/supprimerTv")
    public String supprimerTv(@RequestParam("id") Long id,
            ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        
        tvService.deleteTvById(id);
        Page<Tv> tvs = tvService.getAllTvsParPage(page, size);
        modelMap.addAttribute("tvs", tvs);
        modelMap.addAttribute("pages", new int[tvs.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeTvs";
    }

    // Edit TV
    @RequestMapping("/modifierTv")
    public String editerTv(@RequestParam("id") Long id, ModelMap modelMap) {
        Tv t = tvService.getTv(id);
        modelMap.addAttribute("tv", t);
        return "editerTv";
    }

    // Update TV
    @RequestMapping("/updateTv")
    public String updateTv(@ModelAttribute("tv") Tv tv,
                         @RequestParam("date") String date,
                         ModelMap modelMap) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date manufactureDate = dateFormat.parse(date);
        tv.setManufactureDate(manufactureDate);
        tvService.updateTv(tv);
        return "redirect:/listeTvs";
    }
}