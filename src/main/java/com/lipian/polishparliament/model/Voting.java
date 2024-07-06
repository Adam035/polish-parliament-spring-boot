package com.lipian.polishparliament.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Voting {
    private int votingNumber, sitting, sittingDay, totalVoted, notParticipating, yes, abstain, no, term;
    private String title, topic, date, kind;
    private List<Vote> votes;
}
