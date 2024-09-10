package ch.mesoneer.innovapoints.services;

import ch.mesoneer.innovapoints.entities.Score;
import ch.mesoneer.innovapoints.repositories.ScoreRepository;
import org.springframework.stereotype.Service;


@Service
public class ScoreService {

    private final static int POINTS_FOR_INNOVATION_CREATION = 10;
    private final static int POINTS_FOR_APPROVED_INNOVATION = 30;


    private final ScoreRepository scoreRepository;

    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public Score addPointsForInnovationCreation(String creatorName) {
        Score score = scoreRepository.findByCreatorName(creatorName)
                .orElse(new Score(creatorName, 0));

        score.addScorePoints(POINTS_FOR_INNOVATION_CREATION);

        return scoreRepository.save(score);
    }

    public Score addPointsForInnovationApproved(String creatorName) {
        Score score = scoreRepository.findByCreatorName(creatorName)
                .orElseThrow(NullPointerException::new);

        score.addScorePoints(POINTS_FOR_APPROVED_INNOVATION);

        return scoreRepository.save(score);
    }
}
