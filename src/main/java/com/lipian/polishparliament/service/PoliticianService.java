package com.lipian.polishparliament.service;

import com.lipian.polishparliament.http.Http;
import com.lipian.polishparliament.model.Politician;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliticianService {

    private final String apiUrl;

    public PoliticianService() {
        apiUrl = "https://api.sejm.gov.pl/sejm/term10/MP";
    }

    public List<Politician> getPoliticians() {
         return Http.getList(Politician.class, apiUrl);
    }
}
