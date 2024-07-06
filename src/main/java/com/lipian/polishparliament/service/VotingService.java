package com.lipian.polishparliament.service;

import com.lipian.polishparliament.http.Http;
import com.lipian.polishparliament.model.Voting;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotingService {

    private final String apiUrl;

    public VotingService() {
        apiUrl = "https://api.sejm.gov.pl/sejm/term10/votings/";
    }

    public List<Voting> getSitting(int sitting) {
        String url = apiUrl.concat(Integer.toString(sitting));
        return Http.getList(Voting.class, url);
    }

    public Voting getVoting(int sitting, int votingNumber) {
        String url = apiUrl
                .concat(Integer.toString(sitting))
                .concat("/")
                .concat(Integer.toString(votingNumber));
        return Http.getObject(Voting.class, url);
    }
}
