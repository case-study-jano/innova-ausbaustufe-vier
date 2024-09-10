package io.mesoneer.external;

import io.mesoneer.dtos.ScoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ScoreServiceExternal {

    private final RestClient restClient;

    @Autowired
    public ScoreServiceExternal(RestClient restClient) {
        this.restClient = restClient;
    }

    public void createScore(String creatorName) {
        ScoreDTO scoreDTO = new ScoreDTO(creatorName);

        this.restClient.post()
                .uri("/scores")
                .body(scoreDTO)
                .retrieve();
    }

    public void updateScoreInnovationApproved(String creatorName) {
        ScoreDTO scoreDTO = new ScoreDTO(creatorName);

        this.restClient.put()
                .uri("/scores")
                .body(scoreDTO)
                .retrieve();
    }
}
