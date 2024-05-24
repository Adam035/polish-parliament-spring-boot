package com.lipian.polishparliament.politicians;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Politician {
    private String firstName, lastName, club, birthDate, birthLocation, email, educationLevel, districtName, profession, voivodeship;
    private int id, numberOfVotes;
    private boolean active;

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}
