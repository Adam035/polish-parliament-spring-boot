package com.lipian.polishparliament.politicians;

import com.lipian.polishparliament.http.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliticianService {

    private final String apiUrl;

    @Autowired
    public PoliticianService() {
        apiUrl = "https://api.sejm.gov.pl/sejm/term10/MP";
    }

    public List<Politician> getPoliticians() {
         return Http.getList(Politician.class, apiUrl);
    }
}
