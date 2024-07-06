package com.lipian.polishparliament.controller;

import com.lipian.polishparliament.model.Voting;
import com.lipian.polishparliament.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/sittings")
public class VotingController {

    public VotingService votingService;

    @Autowired
    public VotingController(VotingService votingService) {
        this.votingService = votingService;
    }

    @GetMapping
    public String getSittings(Model model) {
        List<Voting> temp;
        int i = 0;
        do temp = votingService.getSitting(++i);
        while (!temp.isEmpty());
        model.addAttribute("numberOfSittings", --i);
        return "sittings_list";
    }

    @GetMapping("/{sittingNumber}")
    public String getSitting(@PathVariable int sittingNumber, Model model) {
        List<Voting> sitting = votingService.getSitting(sittingNumber);
        model.addAttribute("sitting", sitting);
        return "sitting";
    }

    @GetMapping("/{sittingNumber}/{votingNumber}")
    public String getVoting(@PathVariable int sittingNumber, @PathVariable int votingNumber, Model model) {
        Voting voting = votingService.getVoting(sittingNumber, votingNumber);
        model.addAttribute("voting", voting);
        return "voting";
    }
}
