package com.lipian.polishparliament.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Politician {
    private String firstName, secondName, lastName, club, birthDate, birthLocation, email, educationLevel, districtName, profession, voivodeship;
    private int id, numberOfVotes;
    private boolean active;

    @Override
    public String toString() {
        if (secondName == null)
            return String.format("%s %s", firstName, lastName);
        return String.format("%s %s %s", firstName, secondName ,lastName);
    }
}
