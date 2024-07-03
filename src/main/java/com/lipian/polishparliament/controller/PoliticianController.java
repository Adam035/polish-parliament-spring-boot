package com.lipian.polishparliament.controller;

import com.lipian.polishparliament.model.Politician;
import com.lipian.polishparliament.service.PoliticianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/politicians")
public class PoliticianController {

    public final PoliticianService politicianService;
    private final List<Politician> politicians;

    @Autowired
    public PoliticianController(PoliticianService politicianService) {
        this.politicianService = politicianService;
        politicians = politicianService.getPoliticians();
    }

    @GetMapping
    public String getPoliticians(Model model) {
        model.addAttribute("politicians", politicians);
        return "politicians_table";
    }

    @GetMapping("/{id}")
    public String getPolitician(@PathVariable int id, Model model) {
        model.addAttribute("politician", politicians.get(id - 1));
        return "politician";
    }
}
